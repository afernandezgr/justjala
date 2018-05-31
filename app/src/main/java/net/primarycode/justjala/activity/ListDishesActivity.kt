package net.primarycode.justjala.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_commands.*
import net.primarycode.justjala.R
import net.primarycode.justjala.fragment.ListDishesFragment
import net.primarycode.justjala.model.Tables


class ListDishesActivity : AppCompatActivity() {


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


        val indexTable = intent.getIntExtra(ListDishesActivity.EXTRA_INDEX_TABLE, 0)

        if (supportFragmentManager.findFragmentById(R.id.list_dishes_fragment)== null) {
            val fragment = ListDishesFragment.newInstance(indexTable)
            supportFragmentManager.beginTransaction()
                    .add(R.id.list_dishes_fragment, fragment)
                    .commit()
        }

    }




}
