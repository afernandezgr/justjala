package net.primarycode.justjala.fragment

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_list_commands.*
import net.primarycode.justjala.R
import net.primarycode.justjala.activity.ListCommadsActivity
import net.primarycode.justjala.adapters.CommandsRecyclerViewAdapter
import net.primarycode.justjala.model.Command
import net.primarycode.justjala.model.Tables

class ListCommandFragment : Fragment() {



    companion object {
        val ARG_TABLE_INDEX = "ARG_TABLE_INDEX"



        fun newInstance(tableIndex: Int): ListCommandFragment {
            val arguments = Bundle()
            arguments.putInt(ARG_TABLE_INDEX, tableIndex)
            val fragment = ListCommandFragment()
            fragment.arguments = arguments

            return fragment
        }
    }

    val indexTable by lazy {
        arguments?.getInt(ListDishesFragment.ARG_TABLE_INDEX,0)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val root=inflater?.inflate(R.layout.fragment_list_commands, container, false)

        return root!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView_commandList.layoutManager = LinearLayoutManager(activity)

        val tableIndex=arguments?.getInt(ListCommadsActivity.EXTRA_TABLE_INDEX, 0)
        val adapter =  CommandsRecyclerViewAdapter(Tables[tableIndex!!].commands)

        recyclerView_commandList.adapter = adapter
    }


    fun moveToTable(indexTable : Int){
        val adapter =  CommandsRecyclerViewAdapter(Tables[indexTable!!].commands)

        recyclerView_commandList.adapter = adapter
    }
}