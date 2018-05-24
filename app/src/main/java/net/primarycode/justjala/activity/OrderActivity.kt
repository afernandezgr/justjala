package net.primarycode.justjala.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_order.*
import net.primarycode.justjala.R
import net.primarycode.justjala.adapters.OrderAdapter
import net.primarycode.justjala.model.Table
import net.primarycode.justjala.model.Tables

class OrderActivity : AppCompatActivity() {

    companion object {

        val EXTRA_TABLE_INDEX = "EXTRA_TABLE_INDEX"

        fun intent(context: Context, tableIndex: Int): Intent {
            val intent = Intent(context, OrderActivity::class.java)
            intent.putExtra(EXTRA_TABLE_INDEX, tableIndex)
            return intent
        }
    }

    var table = Table("Mesa 1", 100.75f)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        recyclerView_Order.layoutManager = LinearLayoutManager(this)
        recyclerView_Order.itemAnimator = DefaultItemAnimator()
        recyclerView_Order.adapter = OrderAdapter()


        //Actualizamos la interfaz


        tableName.text = Tables[intent.getIntExtra(EXTRA_TABLE_INDEX, 0)].name
        tableBill.text = Tables[intent.getIntExtra(EXTRA_TABLE_INDEX, 0)].bill.toString()


    }
}
