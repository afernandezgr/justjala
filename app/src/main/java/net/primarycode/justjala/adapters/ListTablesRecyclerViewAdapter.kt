package net.primarycode.justjala.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import net.primarycode.justjala.R
import net.primarycode.justjala.model.Table
import net.primarycode.justjala.model.Tables


class ListTablesRecyclerViewAdapter: RecyclerView.Adapter<ListTablesRecyclerViewAdapter.TableViewHolder>() {

    var onClickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.table_row, parent, false)
        cellForRow.setOnClickListener {
            onClickListener?.onClick(it)
        }
        return TableViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return Tables.count
    }


    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {

        holder.bindTable(Tables[position])

    }


    inner class TableViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val tableName = itemView.findViewById<TextView?>(R.id.idTableName)
        val tableBill = itemView.findViewById<TextView?>(R.id.idTableBill)

        fun bindTable(table: Table)
        {
            tableName?.text = table.name
            tableBill?.text = String.format("%s €", table.bill.toString())
        }


    }
}


/*

class ListTablesAdapter: RecyclerView.Adapter<CustomViewHolderTable>() {


    override fun getItemCount(): Int {
        return Tables.count
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolderTable {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.table_row, parent, false)
        return CustomViewHolderTable(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolderTable, position: Int) {
        holder?.itemView?.idTableName?.text = Tables[position].name
        holder?.itemView?.idTableBill?.text = String.format("%s $",Tables[position].bill.toString(),R.string.currency)

    }
}

class CustomViewHolderTable(val itemView: View): RecyclerView.ViewHolder(itemView) {

}*/
