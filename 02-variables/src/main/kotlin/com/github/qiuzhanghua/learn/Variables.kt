package com.github.qiuzhanghua.learn

fun main(args: Array<String>) {
    var count : Int = 5
    // count  = "abc"   // not allowed to change type
    count += 5
    println(count)


    var name: String = "daniel"
    var ready: Boolean = true // false
    var i : Int = 36
    var long: Long = 1234324564L
    var pi: Double = 3.1415926
    var list: List<Int> = mutableListOf<Int>(1,2,3)
    // list += 5
    var set: Set<Double> = mutableSetOf<Double>(2.718, 3.14)
    var map: Map<String, Int> = mutableMapOf<String, Int>("Jan" to 1, "Feb" to 2)

    println("name = ${name.capitalize()}, pi = ${pi}, set = $set, map = ${map}")

    val yourName = "Hero" // read only, Type Inference
    val int = 6
    //  int += 6    // not allowed

    val anotherList = listOf(1,2,3) // Type Inference
    // anotherList += 7 not allowed
    val anotherSet = setOf(2.7, 3.14) // Type Inference
    val anotherMap = mapOf<String, Int>("Mar" to 3, "April" to 4) // Type Inference
    println("anotherSet = $anotherSet, anotherMap = $anotherMap")






}

// Compile Time Constant
// String, Int, Double, Float, Long, Short, Byte, Char, Boolean
const val NOTE_CHAR :Char = 'X'
const val MY_PIE: Float = 3.14f