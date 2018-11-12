package com.github.qiuzhanghua.learn

fun main(args: Array<String>) {
    // throw Exception("Exception")
    toUpper("hello")


    // throw MyException("Customized Exception")

    try {
        toUpper(null)
    } catch (e: Exception) {
        println(e)
    } finally {
        println("call toUpper end.")
    }

    println(half(10))
    println(half(11))

}


fun toUpper(s: String?) {
    s?.capitalize() ?: throw IllegalStateException("should not be null")
}

class MyException(reason: String) : Exception("My Exception is $reason")



// precondition functions
// checkNotNull, require, requireNotNull, error, assert
fun anotherToUpper(s: String?): String {
    checkNotNull(s) {"s should not be null"}
    return s.capitalize()
}

fun half(int: Int): Int {
//    requireNotNull(int)
//    assert(3 > 2) {}
    require(int % 2 == 0) {"int should be even"}
    return int / 2
}
