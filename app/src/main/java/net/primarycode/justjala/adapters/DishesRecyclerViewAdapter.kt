package net.primarycode.justjala.adapters


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import net.primarycode.justjala.R
import net.primarycode.justjala.model.*


class DishesRecyclerViewAdapter(): RecyclerView.Adapter<DishesRecyclerViewAdapter.DishViewHolder>() {

    var onClickListener : View.OnClickListener? = null

    override fun getItemCount(): Int {
        return Dishes.count
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.dish_row, parent, false)

        cellForRow.setOnClickListener {
            onClickListener?.onClick(it)
        }
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

            val imParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            val layoutAlergens = itemView.findViewById<LinearLayout>(R.id.layoutalergens)
            var imAlergen: ImageView
            for (alergen in dish.listAllergens) {
                imAlergen = ImageView(itemView.context)

                when (alergen) {
                    Allergens.CEREALES -> imAlergen.setImageResource(R.drawable.alerg_gluten)
                    Allergens.HUEVOS -> imAlergen.setImageResource(R.drawable.alerg_huevos)
                    Allergens.FRUTOS_CASCARA -> imAlergen.setImageResource(R.drawable.alerg_frutoscascara)
                    Allergens.LECHE -> imAlergen.setImageResource(R.drawable.alerg_lacteos)
                    Allergens.PESCADO -> imAlergen.setImageResource(R.drawable.alerg_pescado)
                    Allergens.SOJA -> imAlergen.setImageResource(R.drawable.alerg_soja)
                    Allergens.ALTRAMUCES -> imAlergen.setImageResource(R.drawable.alerg_altramuces)
                    Allergens.APIO -> imAlergen.setImageResource(R.drawable.alerg_apio)
                    Allergens.CRUSTACEOS -> imAlergen.setImageResource(R.drawable.alerg_crustaceos)
                    Allergens.MOLUSCOS -> imAlergen.setImageResource(R.drawable.alerg_moluscos)
                    Allergens.MOSTAZA -> imAlergen.setImageResource(R.drawable.alerg_mostaza)
                    Allergens.SESAMO -> imAlergen.setImageResource(R.drawable.alerg_sesamo)
                    Allergens.CACAHUETES -> imAlergen.setImageResource(R.drawable.alerg_cacahuetes)
                 //   else -> imAlergen.setImageResource(R.drawable.blank)
                }


                imAlergen.setMaxHeight(100)
                imAlergen.setMaxWidth(100)
                imAlergen.setScaleType(ImageView.ScaleType.FIT_XY)
                imAlergen.setAdjustViewBounds(true)

                if (layoutAlergens != null) {
                    layoutAlergens.addView(imAlergen, imParams)
                }
            }

        }
    }
}

