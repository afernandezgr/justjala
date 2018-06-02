package net.primarycode.justjala.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_list_tables.*
import net.primarycode.justjala.R
import net.primarycode.justjala.fragment.ListCommandFragment
import net.primarycode.justjala.fragment.ListTablesFragment


class ListTablesActivity : AppCompatActivity(), ListTablesFragment.OnTableClickedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tables)

        if (findViewById<ViewGroup>(R.id.list_tables_fragment)!=null){
            if (supportFragmentManager.findFragmentById(R.id.list_tables_fragment)== null) {
                val fragment = ListTablesFragment.newInstance()
                supportFragmentManager.beginTransaction()
                        .add(R.id.list_tables_fragment, fragment)
                        .commit()
            }
        }

        if (findViewById<ViewGroup>(R.id.list_commands_fragment)!=null){
            if (supportFragmentManager.findFragmentById(R.id.list_commands_fragment) == null) {
                supportFragmentManager.beginTransaction()
                        .add(R.id.list_commands_fragment, ListCommandFragment.newInstance(0))
                        .commit()
            }
        }

    }

    override fun onRestart() {
        super.onRestart()

        recyclerView_tableList.adapter.notifyDataSetChanged()

        val commandsfragment = supportFragmentManager.findFragmentById(R.id.list_tables_fragment)
        if (commandsfragment != null) {
            commandsfragment.recyclerView_tableList.adapter.notifyDataSetChanged()
        }

    }

    override fun onTableClicked(indexTable: Int) {

        val commandsFragment = supportFragmentManager.findFragmentById(R.id.list_commands_fragment) as? ListCommandFragment

        if (commandsFragment != null){
            commandsFragment.moveToTable(indexTable)
        }
        else{
            startActivity(ListCommadsActivity.intent(this, indexTable))
        }


    }

}
