package net.primarycode.justjala.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_commands.*
import kotlinx.android.synthetic.main.fragment_list_commands.*
import net.primarycode.justjala.R
import net.primarycode.justjala.fragment.ListCommandFragment
import net.primarycode.justjala.model.Dishes
import net.primarycode.justjala.model.Tables

class ListCommadsActivity : AppCompatActivity() {

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


        if (supportFragmentManager.findFragmentById(R.id.list_commands_fragment)== null) {
            val fragment = ListCommandFragment.newInstance(indexTable)
            supportFragmentManager.beginTransaction()
                    .add(R.id.list_commands_fragment, fragment)
                    .commit()
        }

        //Actualizamos la interfaz
        updateActivityCommands()

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
                    .setMessage("Do you want the bill for the table " + Tables[indexTable].name + " amount: "+ Tables[indexTable].getBill().toString() + "€")
                    .setPositiveButton(android.R.string.ok, { _, _ ->

                        Tables[indexTable].commands.clear()
                        Toast.makeText(this, "Bill generated for table " + Tables[indexTable].name, Toast.LENGTH_LONG).show()

                        val commandsfragment = supportFragmentManager.findFragmentById(R.id.list_commands_fragment)
                        if (commandsfragment != null) {
                            commandsfragment.recyclerView_commandList.adapter.notifyDataSetChanged()
                        }

                        updateActivityCommands()
                       // Snackbar.make(findViewById(android.R.id.content), edit?.text.toString(), Snackbar.LENGTH_LONG)
                       //         .show()
                    })
                    .setNegativeButton(android.R.string.cancel, null)
                    .show()
        }
    }

    override fun onRestart() {
        super.onRestart()
        val commandsfragment = supportFragmentManager.findFragmentById(R.id.list_commands_fragment)
        if (commandsfragment != null) {
                   commandsfragment.recyclerView_commandList.adapter.notifyDataSetChanged()
        }

        updateActivityCommands()

    }

    fun updateActivityCommands(){

        //Actualizamos la interfaz
        tableName.text = Tables[indexTable].name
        tableBill.text = Tables[indexTable].getBill().toString()
    }



}
