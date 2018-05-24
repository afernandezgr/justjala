package net.primarycode.justjala.fragment

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_list_tables.*
import net.primarycode.justjala.R
import net.primarycode.justjala.activity.OrderActivity
import net.primarycode.justjala.adapters.ListTablesRecyclerViewAdapter
import net.primarycode.justjala.model.Tables


class ListTablesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
         super.onCreateView(inflater, container, savedInstanceState)
         val root=inflater?.inflate(R.layout.fragment_list_tables, container, false)


         return root!!
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView_tableList.layoutManager = LinearLayoutManager(activity)
        val adapter =  ListTablesRecyclerViewAdapter()
        adapter.onClickListener = View.OnClickListener {
            val tableIndex = recyclerView_tableList.getChildAdapterPosition(it)

            startActivity(OrderActivity.intent(activity, tableIndex))
        }
        recyclerView_tableList.adapter = adapter

    }
}