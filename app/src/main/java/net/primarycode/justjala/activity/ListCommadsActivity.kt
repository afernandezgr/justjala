package net.primarycode.justjala.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_commands.*
import kotlinx.android.synthetic.main.fragment_list_commands.*
import net.primarycode.justjala.R
import net.primarycode.justjala.fragment.ButtonCommandsFragment
import net.primarycode.justjala.fragment.ListCommandFragment
import net.primarycode.justjala.model.Dishes
import net.primarycode.justjala.model.Tables

class ListCommadsActivity : AppCompatActivity(), ButtonCommandsFragment.OnButtonsCommandListener {

    companion object {
        val EXTRA_TABLE_INDEX = "EXTRA_TABLE_INDEX"
        fun intent(context: Context, tableIndex: Int): Intent {
            val intent = Intent(context, ListCommadsActivity::class.java)
            intent.putExtra(EXTRA_TABLE_INDEX, tableIndex)
            return intent
        }
    }

    val indexTable by lazy {
        intent.getIntExtra(EXTRA_TABLE_INDEX, 0)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commands)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (supportFragmentManager.findFragmentById(R.id.buttons_commands_fragment) == null) {
            val fragment = ButtonCommandsFragment.newInstance(indexTable)
            supportFragmentManager.beginTransaction()
                    .add(R.id.buttons_commands_fragment, fragment)
                    .commit()
        }


        if (supportFragmentManager.findFragmentById(R.id.list_commands_fragment)== null) {
            val fragment = ListCommandFragment.newInstance(indexTable)
            supportFragmentManager.beginTransaction()
                    .add(R.id.list_commands_fragment, fragment)
                    .commit()
        }

        //Actualizamos la interfaz
    /*    updateActivityCommands()

        buttonAddDish.setOnClickListener{
            val intent = ListDishesActivity.intent(this,
                    indexTable)
            startActivity(intent)
        }


        buttonCheckTable.setOnClickListener {
           // val customView = layoutInflater.inflate(R.layout.view_cityinput, null)
           // val edit = customView.findViewById<EditText?>(R.id.city_name)
            AlertDialog.Builder(this)
                    .setTitle("Generate bill")
                    .setMessage("Please confirm if you want the bill for the table: \n" + Tables[indexTable].name + "\nAmount: "+ Tables[indexTable].getBill().toString() + "€")
                    .setPositiveButton(android.R.string.ok, { _, _ ->

                        Tables[indexTable].commands.clear()
                        Toast.makeText(this, "Bill generated for table " + Tables[indexTable].name, Toast.LENGTH_LONG).show()

                        val commandsfragment = supportFragmentManager.findFragmentById(R.id.list_commands_fragment)
                        if (commandsfragment != null) {
                            commandsfragment.recyclerView_commandList.adapter.notifyDataSetChanged()
                        }

                        updateActivityCommands()

                    })
                    .setNegativeButton(android.R.string.cancel, null)
                    .show()
        }*/
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun onRestart() {
        super.onRestart()
        val commandsfragment = supportFragmentManager.findFragmentById(R.id.list_commands_fragment) as? ListCommandFragment
        if (commandsfragment != null) {
            commandsfragment.recyclerView_commandList.adapter.notifyDataSetChanged()
        }

        val buttonsfragment = supportFragmentManager.findFragmentById(R.id.buttons_commands_fragment) as? ButtonCommandsFragment
        if (buttonsfragment != null) {
            buttonsfragment.updateActivityCommands(indexTable)
        }



    }

/*    fun updateActivityCommands(){

        //Actualizamos la interfaz
        tableName.text = Tables[indexTable].name
        tableBill.text = Tables[indexTable].getBill().toString()
    }*/

    override fun onAddDishClicked(indexTable: Int){

        startActivity(ListDishesActivity.intent(this, indexTable))

    }

    override fun onGenerateBillClicked(indexTable: Int){
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

                    val buttonsfragment = supportFragmentManager.findFragmentById(R.id.buttons_commands_fragment) as? ButtonCommandsFragment
                    if (buttonsfragment != null) {
                        buttonsfragment.updateActivityCommands(indexTable)
                    }


                })
                .setNegativeButton(android.R.string.cancel, null)
                .show()
    }

}
