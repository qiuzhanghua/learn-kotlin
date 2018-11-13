package com.github.qiuzhanghua.learn

import java.io.File

fun main(args: Array<String>) {
    val fruits = mutableListOf<String>("apple", "orange", "banana")
    println(fruits.first())
    println(fruits.last())
    println(fruits[0])
    println(fruits.getOrElse(5) {"No fruit"})

    println(fruits.contains("apple"))
    println(fruits.containsAll(listOf("apple", "peach")))
    fruits.add("peach")  // +=
    fruits.add(0, "pear")
    fruits.remove("banana")
    fruits[0] = "pears"
    println(fruits)

    for (f in fruits) {
        println(f)
    }
    fruits.forEach { f -> println(f) }  // println(it)
    fruits.forEachIndexed{index, s ->
        println("$index -> $s")
    }

    val list = File("build.gradle.kts").readText().split("\n")
    list.forEachIndexed{index, s ->
        println("$index: $s")
    }


    val planets = mutableSetOf<String>("earth", "venus")
    planets.add("mercury")
    planets.add("mercury")
    planets += "mars"
    planets.contains("moon")
    // remove removeAll clean -=

    fruits.toSet().toList()
    planets.distinct()


    val map = mutableMapOf<Int, String>(1 to "Jan", 2 to "Feb")
    map += 3 to "March"
    map += 3 to "Mar"
    map[1]
    map.getOrElse(5) {"Unknown"}
    map.getOrDefault(5, "Unknown")

    map.forEach {
        println("month = ${it.key}, value = ${it.value}")
    }
    map.forEach { key, value ->
        println("month = $key, value = $value")
    }

    // put putAll getOrPut remove - -= clear

}

/**
Collection type 	Ordered? 	Unique? 	Stores 	            Supports destructuring?
List                Yes         No          Elements 	        Yes
Set                 No          Yes         Elements 	        No
Map                 No          Keys        Key-value pairs 	No
 **/