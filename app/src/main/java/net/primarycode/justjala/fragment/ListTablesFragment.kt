package net.primarycode.justjala.fragment

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_list_tables.*
import net.primarycode.justjala.R
import net.primarycode.justjala.activity.ListCommadsActivity
import net.primarycode.justjala.activity.ListDishesActivity
import net.primarycode.justjala.adapters.ListTablesRecyclerViewAdapter


class ListTablesFragment : Fragment() {

    private var onTableClickedListener: OnTableClickedListener? = null

    companion object {

        fun newInstance(): ListTablesFragment {
            val arguments = Bundle()
            val fragment = ListTablesFragment()

            return fragment
        }
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val root=inflater?.inflate(R.layout.fragment_list_tables, container, false)

        return root!!
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView_tableList.layoutManager = LinearLayoutManager(activity)
        val adapter =  ListTablesRecyclerViewAdapter()
      /*  adapter.onClickListener = View.OnClickListener {
          val tableIndex = recyclerView_tableList.getChildAdapterPosition(it)
          startActivity(ListCommadsActivity.intent(activity!!, tableIndex))
        }*/
        //val tableIndex = recyclerView_tableList.getChildAdapterPosition(it)
        adapter.onClickListener = View.OnClickListener {
            val tableIndex = recyclerView_tableList.getChildAdapterPosition(it)
            onTableClickedListener?.onTableClicked(tableIndex)
        }
        recyclerView_tableList.adapter = adapter
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
        if (activity is OnTableClickedListener) {
            onTableClickedListener = activity
        }
        else {
            onTableClickedListener = null
        }
    }

    override fun onDetach() {
        super.onDetach()
        onTableClickedListener = null
    }


    interface OnTableClickedListener {
        fun onTableClicked(indexTable: Int)
    }

}