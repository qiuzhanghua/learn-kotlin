package com.github.qiuzhanghua.learn

import java.io.File

fun main(args: Array<String>) {
    val file = File("build.gradle.kts").apply {
        setReadable(true)
        setExecutable(false) // file.setExecutable
    }


    val sixteen = listOf<Int>(1, 2, 3, 4).last().let { it * it }
    println(sixteen)
    // see 06-null-safety line 20 also

    //run
    println("Daniel".run(::nameStartWithD))
    println("Daniel".run { this.startsWith("E") })
    // chain call
    "Daniel".run { this.startsWith("Q") }.run(::println)

    val boolean1 = with("Daniel") {
        this.startsWith("D")
    }
    //.run(::println)
    println(boolean1)


    var fileContents: List<String>
    File("build.gradle.kts")
            .also {
                println(it.name)
            }.also {
                fileContents = it.readLines()
            }
//    fileContents.forEach(::println)


    val content = File("build.gradle.kts")
            .takeIf { it.canRead() && it.canWrite() }
            ?.readText()
//    println(content)

}

fun nameStartWithD(name: String) = name.startsWith("D")

/**
Function 	Passes receiver to lambda as argument? 	Provides relative scoping? 	Returns
let 	    Yes 	                                No 	                        Lambda result
apply 	    No 	                                    Yes 	                    Receiver
run       	No 	                                    Yes 	                    Lambda result
with      	No                                  	Yes                         Lambda result
also        Yes                                     No                          Receiver
takeIf      Yes                                     No                          Nullable version of receiver
takeUnless  Yes                                     No                          Nullable version of receiver
 **/