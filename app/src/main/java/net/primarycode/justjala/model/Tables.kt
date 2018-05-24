package net.primarycode.justjala.model

import net.primarycode.justjala.R



object Tables {

    private val tables : List<Table> = listOf(
            Table("Mesa 1",
                    0f
            ),
            Table("Mesa 2",
                    0f),
            Table("Mesa 3",
                    0f)
    )

    operator fun get(index: Int) = tables[index]

    val count get() =tables.size


}