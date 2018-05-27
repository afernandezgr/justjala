package net.primarycode.justjala.model

import net.primarycode.justjala.R



object Tables {

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

    var command1 = Command(dish1, "Sin cambios")
    var command2 = Command(dish2, "Quitar gamas")
    var table1 = Table("Mesa 1", arrayOf(command1,command2))



    var command3 = Command(dish1, "Quitar la sopa")
    var table2 = Table("Mesa 2", arrayOf(command3))


    var table3 = Table("Mesa 3", arrayOf())

    private val tables : List<Table> = listOf(
            table1,table2, table3
    )

    operator fun get(index: Int) = tables[index]

    val count get() =tables.size


}