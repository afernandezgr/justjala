package net.primarycode.justjala.activity

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_list_commands.*
import kotlinx.android.synthetic.main.fragment_list_tables.*
import net.primarycode.justjala.R
import net.primarycode.justjala.fragment.ButtonCommandsFragment
import net.primarycode.justjala.fragment.ListCommandFragment
import net.primarycode.justjala.fragment.ListTablesFragment
import net.primarycode.justjala.model.Tables


class ListTablesActivity : AppCompatActivity(), ListTablesFragment.OnTableClickedListener, ButtonCommandsFragment.OnButtonsCommandListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tables)

        //añadirmos lista de mesas
        if (findViewById<ViewGroup>(R.id.list_tables_fragment)!=null){
            if (supportFragmentManager.findFragmentById(R.id.list_tables_fragment)== null) {
                val fragment = ListTablesFragment.newInstance()
                supportFragmentManager.beginTransaction()
                        .add(R.id.list_tables_fragment, fragment)
                        .commit()
            }
        }

        //añadimos lista de comandas ya registradas
        if (findViewById<ViewGroup>(R.id.list_commands_fragment)!=null){
            if (supportFragmentManager.findFragmentById(R.id.list_commands_fragment) == null) {
                val fragment = ListCommandFragment.newInstance(0)
                supportFragmentManager.beginTransaction()
                        .add(R.id.list_commands_fragment, fragment, "tagComandas")
                        .commit()
            }
        }

        //añadimos botonera
        if (findViewById<ViewGroup>(R.id.buttons_commands_fragment)!=null){
            if (supportFragmentManager.findFragmentById(R.id.buttons_commands_fragment) == null) {
                val fragment = ButtonCommandsFragment.newInstance(0)
                supportFragmentManager.beginTransaction()
                        .add(R.id.buttons_commands_fragment, fragment)
                        .commit()
            }
        }


    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        if (newConfig?.orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.popBackStack()
        }
    }

    override fun onRestart() {
        super.onRestart()

        recyclerView_tableList.adapter.notifyDataSetChanged()

        val commandsfragment = supportFragmentManager.findFragmentById(R.id.list_commands_fragment) as?  ListCommandFragment
        if (commandsfragment != null) {
            commandsfragment.recyclerView_commandList.adapter.notifyDataSetChanged()
        }

        val buttonsfragment = supportFragmentManager.findFragmentById(R.id.buttons_commands_fragment) as? ButtonCommandsFragment
        if (buttonsfragment != null) {
            buttonsfragment.updateActivityCommands(buttonsfragment.arguments?.getInt(ButtonCommandsFragment.ARG_TABLE_INDEX,0)!!)
        }


    }

    override fun onTableClicked(indexTableClicked: Int) {

        val commandsFragment = supportFragmentManager.findFragmentById(R.id.list_commands_fragment) as? ListCommandFragment

        if (commandsFragment != null && (getResources().configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)){
            commandsFragment.moveToTable(indexTableClicked)
            val buttonsfragment = supportFragmentManager.findFragmentById(R.id.buttons_commands_fragment) as? ButtonCommandsFragment
            if (buttonsfragment != null) {
                buttonsfragment.updateActivityCommands(indexTableClicked)
                //buttonsfragment.setValueIndexTable(indexTableClicked)

            }
        }
        else{
            startActivity(ListCommadsActivity.intent(this, indexTableClicked))
        }

    }

    override fun onAddDishClicked(indexTable : Int){

        startActivity(ListDishesActivity.intent(this, indexTable))

    }

    override fun onGenerateBillClicked(indexTable : Int){
        AlertDialog.Builder(this)
                .setTitle("Generate bill")
                .setMessage("Please confirm if you want the bill for the table: \n" + Tables[indexTable].name + "\nAmount: "+ Tables[indexTable].getBill().toString() + "€")
                .setPositiveButton(android.R.string.ok, { _, _ ->

                    Tables[indexTable!!].commands.clear()
                    Toast.makeText(this, "Bill generated for table " + Tables[indexTable].name, Toast.LENGTH_LONG).show()

                    val commandsfragment = supportFragmentManager.findFragmentById(R.id.list_commands_fragment)
                    if (commandsfragment != null) {
                        commandsfragment.recyclerView_commandList.adapter.notifyDataSetChanged()
                    }

                    val tablesfragment = supportFragmentManager.findFragmentById(R.id.list_tables_fragment)
                    if (tablesfragment != null) {
                        tablesfragment.recyclerView_tableList.adapter.notifyDataSetChanged()
                    }

                    val buttonsfragment = supportFragmentManager.findFragmentById(R.id.buttons_commands_fragment) as? ButtonCommandsFragment
                    if (buttonsfragment != null) {
                        buttonsfragment.updateActivityCommands(indexTable)
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show()
    }

}
