package net.primarycode.justjala.model

import net.primarycode.justjala.R



object Tables { //Singleton

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
            arrayOf(Allergens.CEREALES,Allergens.MOLUSCOS,Allergens.CRUSTACEOS)
    )

    val dish3 =  Dish("Tortilla española",
            "Típica comida españoal a base de patatas, huevos y cebolla",
            "La tortilla de patata, tortilla de patatas o tortilla española —también llamada tortilla de papas en Hispanoamérica, Canarias y Andalucía— es una tortilla (es decir, huevo batido, cuajado con aceite en la sartén)1 con patatas y, generalmente, también con cebolla. Se trata de uno de los platos más conocidos y emblemáticos de la cocina española, siendo un producto muy popular que se puede encontrar en casi cualquier bar o restaurante de España.",
             R.drawable.dish_tortilla,
            20f,
             arrayOf(Allergens.HUEVOS)
    )

    val dish4 =  Dish("Salpicon de marisco",
            "Receta típica de la cocina mediterránea a base de distintos tipos de marisco",
            "El salpicón era un plato generalmente hecho de diferentes carnes picadas al que se le añadía pimienta, sal, vinagre y diversas verduras. Se servía caliente aderezado con una vinagreta. Hoy en día es un plato propio de la costa andaluza que se sirve mucho en los bares de España",
            R.drawable.dish_salpicon,
            30f,
            arrayOf(Allergens.MOLUSCOS, Allergens.CRUSTACEOS)
    )

    val dish5 =  Dish("Wok de verdudas",
            "Plato asiatico tipo consiste en distintos tipos de verduras troceados salteados con aceite y soja",
            "Cocinar con un wok es una forma de preparar platos muy saludables, ya que apenas empleamos un chorrito de aceite para cocinar los ingredientes de la receta, y estos se cocinan a gran temperatura, lo que hace que en poco tiempo estén listos para comer. Podemos cocinar muchos tipos de ingredientes, aunque los más conocidos son las verduras, de casi cualquier tipo, la carne de pollo, el arroz, las gambas o langostinos, los fideos… pero es importante que los que se trocean estén cortados en tiras que no sean gruesas, en forma de bastoncito",
            R.drawable.dish_wok,
            18f,
            arrayOf(Allergens.CEREALES)
    )

    var command1 = Command(dish1, "Sin cambios")
    var command2 = Command(dish2, "Quitar gamas")
    var table1 = Table("Mesa 1", arrayListOf(command1,command2))



    var command3 = Command(dish1, "Quitar la sopa")
    var table2 = Table("Mesa 2", arrayListOf(command3))

    var table3 = Table("Mesa 3", arrayListOf())

    var command4= Command(dish4, "Sin cebolla")
    var table4 = Table ("Mesa 4", arrayListOf(command4))

    var command5= Command(dish5, "Sin cebolla")
    var table5 = Table ("Mesa 5", arrayListOf(command5))


    private val tables : List<Table> = arrayListOf(
            table1,table2, table3, table4, table5
    )

    operator fun get(index: Int) = tables[index]

    val count get() =tables.size


}