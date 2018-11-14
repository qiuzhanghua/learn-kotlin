package com.github.qiuzhanghua.learn

fun main(args: Array<String>) {
    println("Hello".addDot(3))
    3.printMe()
    "Danie".printMe().addDot(3).printMe()

    // see definition
    "Hello".let {
        print(it)
    }


    println("Daniel".numVowels)

    val nullString: String? = null
    nullString.printWithDefault("I am null")
    // null printWithDefault "Default string"

    println((0..9).random())
}

fun String.addDot(times: Int = 1) = this + ".".repeat(times)

// fun Any.printMe() = println(this)

fun <T> T.printMe(): T {
    println(this)
    return this
}


val String.numVowels
    get() = count { "aeiouy".contains(it) }


infix fun String?.printWithDefault(default: String) = println(this ?: default)


private fun <T> Iterable<T>.random(): T = this.shuffled().first()