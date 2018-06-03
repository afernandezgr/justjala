package net.primarycode.justjala.fragment

import android.app.Activity
import android.content.Intent
import android.content.Context
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.design.widget.Snackbar
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

    private var onDishAddedListener: OnDishAddedListener? = null

    companion object {
        val ARG_TABLE_INDEX = "ARG_TABLE_INDEX"

        fun newInstance(tableIndex: Int): ListDishesFragment {
            val arguments = Bundle()
            arguments.putInt(ARG_TABLE_INDEX, tableIndex)
            val fragment = ListDishesFragment()
            fragment.arguments = arguments

            return fragment
        }
    }



    val indexTable by lazy {
        arguments?.getInt(ARG_TABLE_INDEX,0)
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

        labelDishTable.text = "Please select  new dish for table " + Tables[indexTable!!].name


        //val tableIndex=arguments?.getInt(ListDishesActivity.EXTRA_INDEX_TABLE, 0)
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
                                    var comment = data.getStringExtra(CustomizeDishDialogFragment.ARG_DISH_COMMENT) as String
                                    val indexDish = data.getIntExtra(CustomizeDishDialogFragment.ARG_DISH_INDEX,0)
                                    //val indexTable = arguments?.getInt(ListDishesActivity.ARG_INDEX_TABLE, 0)

                                    if (comment == ""){
                                        comment = "No comments"
                                    }
                                    //generate the new command
                                    val newCommand: Command = Command(Dishes[indexDish], comment)

                                    //add this command in table we're working
                                   Tables[indexTable!!].commands.add(newCommand)
                                    //show the user the add has been include in the bill of the table
                                    Snackbar.make(view!!,"New dish added: " + Dishes[indexDish].name + " with comment '" + comment + "'",Snackbar.LENGTH_LONG).show()
                                    onDishAddedListener?.onDishAdded()

                                 }
        }
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        commonAttach(context as? Activity)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        commonAttach(activity)
    }

    fun commonAttach(activity: Activity?) {
        if (activity is OnDishAddedListener) {
            onDishAddedListener = activity
        }
        else {
            onDishAddedListener = null
        }
    }

    override fun onDetach() {
        super.onDetach()
        onDishAddedListener = null
    }

    interface OnDishAddedListener {
        fun onDishAdded()
    }

}