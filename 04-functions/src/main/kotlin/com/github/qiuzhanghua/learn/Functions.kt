package com.github.qiuzhanghua.learn

fun main(args: Array<String>) {
    sayHello("Tiger")
    println(sayHelloTo("Charlie"))
    println(sayHelloWithDefault())
    println(calculateArea(3.0, 4.0))
    println(calculateArea(height = 3.0, width = 4.0)) // Named Function Arguments


    // Anonymous Functions
    val numberOfA = "Eason is a good boy".count({ letter -> letter == 'a' })
    println(numberOfA)

    val copyrightFunc = { "Copy right of 2018" }  //without return
    println(copyrightFunc)
    println(copyrightFunc())
    val copyrightOf = { year: Int -> "Copy right of $year" }
    println(copyrightOf)
    println(copyrightOf(2017))
    val anotherCopyrightOf: (Int) -> String = { it -> "Copy right of $it" }  // it
    // val anotherCopyrightOf: (Int) -> String = {"Copy right of $it" }  // it
    println(anotherCopyrightOf)
    println(anotherCopyrightOf(2019))

    val messageOf: (String, Int) -> String = { name, age -> "$name is $age years old" }

    println(messageOf("Eason", 5))

    // Function That Accepts a Function
    guessMessage("Eason", messageOf)

    // Shorthand syntax
    "Eason is a good boy".count { it == 'a' }
    guessMessage("Eason") {
        name, age -> "$name is 6 years old!"  // age can be replaced with _(underscore)
    }

    // function reference
    println(callCalArea(4.0, 5.0, ::calculateArea))


    // Function Type as Return Type

    val triple = nTimes(3)
    println(triple(100))
}


private fun sayHello(name: String): Unit {
    println("Hello, $name")
}

private fun sayHelloTo(name: String): String {
    return "Hello, $name"
}

private fun sayHelloWithDefault(name: String = "Dear"): String {
    return "Hello, $name"
}


fun calculateArea(width: Double, height: Double): Double {
    println("width = $width, height = $height")
    return width * height
}

// you can add inline before this function, and kotlin compile will "copy and paste" it to where it called
fun guessMessage(name: String, msg: (String, Int) -> String) {
    val random = java.util.Random()
    random.nextInt(10)
    println(msg(name, random.nextInt(10)) + ". Is that right?")
}

fun callCalArea(w: Double, h: Double, f: (Double, Double)-> Double): Double {
    return f(w, h)
}

fun nTimes(n: Int): (Int) -> Int {
    return {
        it * n
    }
}