package net.primarycode.justjala.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_tables.*
import net.primarycode.justjala.R
import net.primarycode.justjala.adapters.ListTablesRecyclerViewAdapter

class ListTablesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_tables)

    }
}
