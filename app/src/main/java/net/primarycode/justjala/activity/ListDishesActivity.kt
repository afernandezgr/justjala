package net.primarycode.justjala.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_list_tables.*
import net.primarycode.justjala.R
import net.primarycode.justjala.fragment.ListDishesFragment
import net.primarycode.justjala.fragment.ListTablesFragment


class ListDishesActivity : AppCompatActivity(), ListDishesFragment.OnDishAddedListener {


    companion object {
        val EXTRA_INDEX_TABLE = "EXTRA_INDEX_TABLE"

        fun intent(context: Context, indexTable: Int): Intent {
            val intent = Intent(context, ListDishesActivity::class.java)
            intent.putExtra(EXTRA_INDEX_TABLE, indexTable)
            return intent
        }
    }

    val indexTable by lazy {
        intent.getIntExtra(ListDishesActivity.EXTRA_INDEX_TABLE, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_dishes)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (findViewById<ViewGroup>(R.id.list_tables_fragment)!=null){
            if (supportFragmentManager.findFragmentById(R.id.list_tables_fragment)== null) {
                val fragment = ListTablesFragment.newInstance()
                supportFragmentManager.beginTransaction()
                        .add(R.id.list_tables_fragment, fragment)
                        .commit()
            }
        }

        if (supportFragmentManager.findFragmentById(R.id.list_dishes_fragment)== null) {
            val fragment = ListDishesFragment.newInstance(indexTable)
            supportFragmentManager.beginTransaction()
                    .add(R.id.list_dishes_fragment, fragment)
                    .commit()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }


    override fun onDishAdded(){

        //Refrescamos lista de tablas con el número amount indicando el nuevo plato añadido

        val tablesFragment = supportFragmentManager.findFragmentById(R.id.list_tables_fragment)
        if (tablesFragment != null) {
            tablesFragment.recyclerView_tableList.adapter.notifyDataSetChanged()
        }
    }

}
