package com.github.qiuzhanghua.learn

import javafx.application.Application.launch
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

fun main() {
    val job = GlobalScope.launch {
        // launch new coroutine in background and continue
        delay(1000L)
        println("World!")
    }
    println("Hello,") // main thread continues here immediately
    runBlocking {
        // could move to main
//        delay(2000L)

        //light-weight
//        repeat(100_000) {
//            // launch a lot of coroutines
//            launch {
//                delay(1000L)
//                print(".")
//            }
//        }
        job.join()
//        job.cancel()
//        job.cancelAndJoin()

        withTimeoutOrNull(1300L) {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }
    }


    val channel = Channel<Int>()
    GlobalScope.launch {
        // this might be heavy CPU-consuming computation or async logic, we'll just send five squares
        for (x in 1..5) channel.send(x * x)
        // channel.close()
    }

    // here we print five received integers:
    runBlocking {
        repeat(5) { println(channel.receive()) }
    }
    println("Done!")

    // select not include here
}