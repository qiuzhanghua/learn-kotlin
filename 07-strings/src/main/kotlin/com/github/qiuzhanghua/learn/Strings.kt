package com.github.qiuzhanghua.learn

const val FILM_NAME: String = "Donald's farm"

fun main(args: Array<String>) {
    val indexOfApostrophe = FILM_NAME.indexOf('\'')
    val name = FILM_NAME.substring(0 until indexOfApostrophe)
    println(name)

    val prices = "Watch, Apple 4 with Cellular, 3999"
    // val data: List<String> = prices.split(',').map { it.trim() }

    // destructuring
    val (type, brand, price) = prices.split(',')
    println("$type of $brand is $price")


    val phase = FILM_NAME.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "5"
            "e" -> "4"
            "i" -> "3"
            "o" -> "2"
            "u" -> "1"
            else -> it.value
        }
    }
    println(phase)

    for (c in "你好") {
        println(c)
    }
    "世界".forEach { println(it) }
    for ((i, c) in "你好，世界".withIndex()) {
        println("$i -> $c")
    }

}