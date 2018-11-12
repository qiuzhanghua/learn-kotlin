package com.github.qiuzhanghua.learn

import kotlin.math.roundToInt

fun main(args: Array<String>) {
    // string to numbers
    val f1 = "3.14".toFloat()
    val f2 = "4.5.6".toFloatOrNull()
    "3".toIntOrNull()
    "998".toUIntOrNull(16)
    "3.1532452354236256".toBigDecimal()

    "3.15f".toIntOrNull() ?: 0


    println(5.toDouble())
    println(5.3.toInt())
    println(5.7.roundToInt())

    println("%.2f".format(3.1415926))
    println("pi = ${"%.2f".format(3.1415926)}")
    println(Integer.toBinaryString(37))
    println(Integer.toBinaryString(37.shl(2)))
    println(Integer.toBinaryString(37.shr(2)))
    println(Integer.toBinaryString(37.inv()))
    println(Integer.toBinaryString(37.xor(64)))
    println(Integer.toBinaryString(37.and(17)))
}