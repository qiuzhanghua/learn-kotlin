package com.github.qiuzhanghua.learn

fun main(args: Array<String>) {
    val name = "Eason"
    val score = 90
    if (score >= 90) {
        println("Eason, Great!")
    } else if (score >= 80) {  // score >= 80 && name.startsWith("E")      || ! etc
        println("Eason, Very good!")
    } else {
        println("Keep trying, Eason!")
    }

    // == and ===
    var anotherName = "Eason"
    println("name === anotherName -> ${name===anotherName}")
    println("name === eason -> ${name==="eason".capitalize()}")
    println("name === eason -> ${name=="eason".capitalize()}")
    val long = 90L
    println("score == long -> ${score==long.toInt()}")
    println("score === long -> ${score===long.toInt()}") // Don't use === from confusing

    // conditional expression
    val isGreat = if (score >= 90) true else false
    // isGreat = score >=90
    val greatString = if (score >= 90) "Great" else "OK"

    if  (score in 90..100) {
        println("Great Range!")
    }
    // score in 100 downTo 80
    // score in 60 until 90 step 7
    // 'x' in 'a'..'z'

    val label =
    when (score) {
        in Int.MIN_VALUE..0 -> "Error"
        in 1..9 -> "ten"
        in 10..59 -> "failed"
        in 60.. 100-> "OK"
        else -> "overflow"
    }
    println(label)
}