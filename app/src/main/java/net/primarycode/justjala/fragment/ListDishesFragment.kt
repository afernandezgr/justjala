package net.primarycode.justjala.fragment

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_list_dishes.*
import net.primarycode.justjala.R

import net.primarycode.justjala.activity.ListDishesActivity
import net.primarycode.justjala.adapters.DishesRecyclerViewAdapter

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
    }


 //   fun setIndexTable(index: Int){
 //       indexTableSelected=index
 //   }
}