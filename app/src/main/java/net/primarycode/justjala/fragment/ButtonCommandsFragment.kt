package net.primarycode.justjala.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_buttons_commands.*
import net.primarycode.justjala.R
import net.primarycode.justjala.model.Tables

class ButtonCommandsFragment : Fragment(){

    private var onButtonsCommandListener: ButtonCommandsFragment.OnButtonsCommandListener? = null

    companion object {
        val ARG_TABLE_INDEX = "ARG_TABLE_INDEX"

        fun newInstance(tableIndex: Int): ButtonCommandsFragment {
            val arguments = Bundle()
            arguments.putInt(ARG_TABLE_INDEX, tableIndex)
            val fragment = ButtonCommandsFragment()
            fragment.arguments = arguments

            return fragment
        }
    }


    val indexTable by lazy {
        arguments?.getInt(ARG_TABLE_INDEX,0)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val root=inflater?.inflate(R.layout.fragment_buttons_commands, container, false)

        return root!!
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateActivityCommands(indexTable!!)

        buttonAddDish.setOnClickListener{

            onButtonsCommandListener?.onAddDishClicked(indexTable!!)

        }


        buttonCheckTable.setOnClickListener {

            onButtonsCommandListener?.onGenerateBillClicked(indexTable!!)

        }

    }
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        commonAttach(context as? Activity)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        commonAttach(activity)
    }

    fun commonAttach(activity: Activity?) {
        if (activity is ButtonCommandsFragment.OnButtonsCommandListener) {
            onButtonsCommandListener = activity
        }
        else {
            onButtonsCommandListener = null
        }
    }

    override fun onDetach() {
        super.onDetach()
        onButtonsCommandListener = null
    }


    public fun updateActivityCommands(indexTable: Int){

        //Actualizamos la interfaz
        tableName.text = Tables[indexTable!!].name
        tableBill.text = Tables[indexTable!!].getBill().toString()
    }

    interface OnButtonsCommandListener {
        fun onAddDishClicked(indexTable: Int)
        fun onGenerateBillClicked(indexTable: Int)
    }
}