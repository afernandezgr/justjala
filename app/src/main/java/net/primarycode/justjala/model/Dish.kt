package net.primarycode.justjala.model


enum class Allergens {
    CEREALES,
    CRUSTACEOS,
    HUEVOS,
    LECHE,
    PESCADO,
    FRUTOS_CASCARA,
    SOJA,
    ALTRAMUCES,
    APIO,
    CACAHUETES,
    MOLUSCOS,
    MOSTAZA,
    SESAMO
}

data class Dish (var name: String, var shortDescription: String, var longDescription: String, var photo: Int, var prize: Float, var listAllergens: Array<Allergens>) {
}
