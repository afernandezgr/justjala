package net.primarycode.justjala.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView



import net.primarycode.justjala.R
import net.primarycode.justjala.model.*


class CommandsRecyclerViewAdapter(private val commands: List<Command>): RecyclerView.Adapter<CommandsRecyclerViewAdapter.CommandViewHolder>() {



    override fun getItemCount(): Int {
        return commands.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommandViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.order_row, parent, false)
        return CommandViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CommandViewHolder, position: Int) {
         holder.bindCommand(commands[position])
    }


    inner class CommandViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val dishImage = itemView.findViewById<ImageView?>(R.id.idImgDish)
        val dishName = itemView.findViewById< TextView?>(R.id.idDishName)
        val dishComment = itemView.findViewById<TextView?>(R.id.idDishComment)
        val dishPrize = itemView.findViewById<TextView?>(R.id.idDishPrize)
        fun bindCommand(command: Command) {

            dishImage?.setImageResource(command.dish.photo)
            dishName?.text = command.dish.name
            dishComment?.text = command.comment
            dishPrize?.text = command.dish.prize.toString() + "€"

        }
    }
}

