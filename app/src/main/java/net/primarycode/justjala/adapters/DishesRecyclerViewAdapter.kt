package net.primarycode.justjala.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import net.primarycode.justjala.R
import net.primarycode.justjala.model.*


class DishesRecyclerViewAdapter(): RecyclerView.Adapter<DishesRecyclerViewAdapter.DishViewHolder>() {


    override fun getItemCount(): Int {
        return Dishes.count
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.dish_row, parent, false)
        return DishViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
         holder.bindCommand(Dishes[position])
    }


    inner class DishViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val dishImage = itemView.findViewById<ImageView?>(R.id.idImgDish)
        val dishName = itemView.findViewById< TextView?>(R.id.idDishName)
        val dishShortDescription = itemView.findViewById<TextView?>(R.id.idShortDescription)

        fun bindCommand(dish : Dish) {

            dishImage?.setImageResource(dish.photo)
            dishName?.text = dish.name
            dishShortDescription?.text = dish.shortDescription

        }
    }
}

