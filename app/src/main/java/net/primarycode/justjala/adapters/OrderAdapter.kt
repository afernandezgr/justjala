package net.primarycode.justjala.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.order_row.view.*


import net.primarycode.justjala.R
import net.primarycode.justjala.model.*


class OrderAdapter: RecyclerView.Adapter<CustomViewHolderOrder>() {

    val dish1 =  Dish("Cocido madrileño",
            "Típica comida madrileña a base de garbanzos",
            "Se trata de un plato único, habitual en los meses fríos de invierno. La forma más clásica de servirlo a los comensales es separando sus ingredientes, ya cocidos, en tres servicios claramente separados. Estos servicios se denominan tradicionalmente como vuelcos: el primero contiene el caldo resultante de la cocción de todos los ingredientes, el segundo le corresponde a los garbanzos junto con las verduras y patatas y el tercero, denominado el de las viandas, se trata del que contiene las carnes.1 Se come en este orden. En la actualidad es un plato frecuente en los restaurantes madrileños y se resume en dos vuelcos (primer plato: sopa y segundo plato: garbanzos y carne)",
            R.drawable.dish_cocido,
            25f,
            arrayOf(Allergens.CEREALES, Allergens.HUEVOS)
    )

    val dish2 =  Dish("Paella",
            "Típica comida valenciana a base de arroz",
            "Plato cuyo ingrediente principal es el arroz que se cocina con otros ingredientes como pescado, marisco, ave, carne, verduras, legumbres, etc.; es un plato típico de todas las regiones españolas, sobre todo de Valencia, variando en cada una el tipo y cantidad de ingredientes.",
            R.drawable.dish_paella,
            20f,
            arrayOf(Allergens.CEREALES,Allergens.MARISCO)
    )

    val table = Table("Mesa 1", 10f)

    val command1 = Command(dish1, "Sin cambios")
    val command2 = Command(dish2, "Quitar gamas")

    val order = Order(table, arrayOf(command1,command2))


    override fun getItemCount(): Int {
        return order.count
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolderOrder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.order_row, parent, false)
        return CustomViewHolderOrder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolderOrder, position: Int) {
        holder?.view?.idImgDish.setImageResource(order.commands[position].dish.photo)
        holder?.view?.idDishName?.text = order.commands[position].dish.name
        holder?.view?.idDishComment?.text = order.commands[position].comment


    }
}

class CustomViewHolderOrder(val view: View): RecyclerView.ViewHolder(view) {

}