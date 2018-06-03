package net.primarycode.justjala.model

import net.primarycode.justjala.R

object Dishes {

    private val dishes : List<Dish> = listOf(
            Dish("Cocido madrileño",
                    "Típica comida madrileña a base de garbanzos",
                    "Se trata de un plato único, habitual en los meses fríos de invierno. La forma más clásica de servirlo a los comensales es separando sus ingredientes, ya cocidos, en tres servicios claramente separados. Estos servicios se denominan tradicionalmente como vuelcos: el primero contiene el caldo resultante de la cocción de todos los ingredientes, el segundo le corresponde a los garbanzos junto con las verduras y patatas y el tercero, denominado el de las viandas, se trata del que contiene las carnes.1 Se come en este orden.",
                     R.drawable.dish_cocido,
                     25f,
                      arrayOf()
                    ),
            Dish("Paella",
                    "Típica comida valenciana a base de arroz",
                    "Plato cuyo ingrediente principal es el arroz que se cocina con otros ingredientes como pescado, marisco, ave, carne, verduras, legumbres, etc.; es un plato típico de todas las regiones españolas, sobre todo de Valencia, variando en cada una el tipo y cantidad de ingredientes.",
                    R.drawable.dish_paella,
                    20f,
                    arrayOf(Allergens.CEREALES,Allergens.MOLUSCOS)
                    ),
            Dish("Tortilla española",
                    "Típica comida españoal a base de patatas, huevos y cebolla",
                    "La tortilla de patata, tortilla de patatas o tortilla española —también llamada tortilla de papas en Hispanoamérica, Canarias y Andalucía— es una tortilla (es decir, huevo batido, cuajado con aceite en la sartén)1 con patatas y, generalmente, también con cebolla. Se trata de uno de los platos más conocidos y emblemáticos de la cocina española, siendo un producto muy popular que se puede encontrar en casi cualquier bar o restaurante de España.",
                    R.drawable.dish_tortilla,
                    15f,
                    arrayOf(Allergens.HUEVOS)
                    ),
            Dish("Salpicon de marisco",
                    "Receta típica de la cocina mediterránea a base de distintos tipos de marisco",
                    "El salpicón era un plato generalmente hecho de diferentes carnes picadas al que se le añadía pimienta, sal, vinagre y diversas verduras. Se servía caliente aderezado con una vinagreta. Hoy en día es un plato propio de la costa andaluza que se sirve mucho en los bares de España",
                    R.drawable.dish_salpicon,
                    30f,
                    arrayOf(Allergens.MOLUSCOS, Allergens.CRUSTACEOS)
                    ),
            Dish("Wok de verdudas",
                    "Plato asiatico tipo consiste en distintos tipos de verduras troceados salteados con aceite y soja",
                    "Cocinar con un wok es una forma de preparar platos muy saludables, ya que apenas empleamos un chorrito de aceite para cocinar los ingredientes de la receta, y estos se cocinan a gran temperatura, lo que hace que en poco tiempo estén listos para comer. Podemos cocinar muchos tipos de ingredientes, aunque los más conocidos son las verduras, de casi cualquier tipo, la carne de pollo, el arroz, las gambas o langostinos, los fideos… pero es importante que los que se trocean estén cortados en tiras que no sean gruesas, en forma de bastoncito",
                    R.drawable.dish_wok,
                    18f,
                    arrayOf(Allergens.CEREALES)
                    )
    )

    operator fun get(index: Int) = dishes[index]

    val count get() =dishes.size


}