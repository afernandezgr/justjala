package net.primarycode.justjala.model

data class Table (var name: String, var commands: Array<Command>){
    public fun getBill(): Float {
        var  sum : Float = 0.0f
        for (command in commands){
            sum = sum + command.dish.prize
        }
        return sum
    }
}