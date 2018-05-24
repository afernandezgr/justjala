package net.primarycode.justjala.model


data class Order (var table: Table, var commands: Array<Command>) {

    val count get() =commands.size
}