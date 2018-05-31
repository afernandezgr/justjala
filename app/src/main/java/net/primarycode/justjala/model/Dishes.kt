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
                    )
            )

    operator fun get(index: Int) = dishes[index]

    val count get() =dishes.size


}