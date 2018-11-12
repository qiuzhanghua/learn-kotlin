package com.github.qiuzhanghua.learn

fun main(args: Array<String>) {

    var s: String?

    s = null
    println(s?.capitalize()?.length)

    s = "world"
    println(s.capitalize().length)

    s = readLine()
    println(s?.capitalize()?.length)

    s = readLine()
//    println(s!!.capitalize().length)  // caution, don't use it if you can not be sure s is not null
//  show static compile
//     s = null
    val name: String? = s?.let {
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "null value"
        }
    }
    println(name)

//  use if to check null
    var another: String
    if (s != null) another = s else another = "another"


    // null coalescing operator

    val content = readLine() ?: "empty"


    var balabala = readLine()
    balabala?.let { balabala.capitalize() } ?: println("empty")

}