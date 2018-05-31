package net.primarycode.justjala.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_list_tables.*
import net.primarycode.justjala.R


class ListTablesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tables)

    }

    override fun onRestart() {
        super.onRestart()

        updateActivityTables()

    }

    fun updateActivityTables(){
        recyclerView_tableList.adapter.notifyDataSetChanged()
    }
}
