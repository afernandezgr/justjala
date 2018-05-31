package net.primarycode.justjala.fragment

import android.app.Activity
import android.content.Intent
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_list_dishes.*
import net.primarycode.justjala.R
import net.primarycode.justjala.activity.ListDishesActivity
import net.primarycode.justjala.adapters.DishesRecyclerViewAdapter
import net.primarycode.justjala.model.Command
import net.primarycode.justjala.model.Dishes
import net.primarycode.justjala.model.Tables


class ListDishesFragment : Fragment() {

    companion object {
        val EXTRA_TABLE_INDEX = "EXTRA_TABLE_INDEX"

        fun newInstance(tableIndex: Int): ListDishesFragment {
            val arguments = Bundle()
            arguments.putInt(ListDishesActivity.EXTRA_INDEX_TABLE, tableIndex)
            val fragment = ListDishesFragment()
            fragment.arguments = arguments

            return fragment
        }
    }


    val REQUEST_COMMENTS = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val root=inflater?.inflate(R.layout.fragment_list_dishes, container, false)

        return root!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView_dishList.layoutManager = LinearLayoutManager(activity)



        val tableIndex=arguments?.getInt(ListDishesActivity.EXTRA_INDEX_TABLE, 0)
        val adapter =  DishesRecyclerViewAdapter()
        recyclerView_dishList.adapter = adapter
        adapter.onClickListener = View.OnClickListener {
            val dishIndex = recyclerView_dishList.getChildAdapterPosition(it)


            val dialog = CustomizeDishDialogFragment.newInstance(dishIndex)
            dialog.setTargetFragment(this, REQUEST_COMMENTS)
            dialog.show(fragmentManager, null)


        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
         REQUEST_COMMENTS -> if (resultCode == Activity.RESULT_OK && data != null) {
                                    val comment = data.getStringExtra(CustomizeDishDialogFragment.DISH_COMMENT) as String
                                    val indexDish = data.getIntExtra(CustomizeDishDialogFragment.DISH_INDEX,0)
                                    val indexTable = arguments?.getInt(ListDishesActivity.EXTRA_INDEX_TABLE, 0)

                                    val newCommand: Command = Command(Dishes[indexDish], comment)

                                   Tables[indexTable!!].commands.add(newCommand)
                                   Toast.makeText(context, "New dish added: " + Dishes[indexDish].name + " with comment: " + comment, Toast.LENGTH_LONG).show()
                                 }
        }
    }

}