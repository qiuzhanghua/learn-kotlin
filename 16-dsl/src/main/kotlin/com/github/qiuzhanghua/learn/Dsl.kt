package com.github.qiuzhanghua.learn

import java.time.LocalDate
import java.time.Period


// 1. kotlinx-html, kotlintest, ktor, anko, exposed, gradle, spring fu      ... use dsl
// see unit test first
//
// 2. simple demo if html

fun main(args: Array<String>) {
    val page = html {
        body {
            "My Body"
        }
    }
    println(page)


    // 3. demo others
    println(1.days.ago)
    println(2.days.after)

    // just for joke, don't use chinese word
    println(3 天 前)
    println(4 天 后)

}

fun html(func: Html.() -> Html): Html {
    return Html(func)
}

interface Node

class Html(func: Html.() -> Html) : Node {
    var nodes = mutableListOf<Node>()

    init {
        func()
    }

    fun body(f: () -> String): Html {
        val b = Body(f())
        nodes.add(b)
        return this
    }

    override fun toString(): String {
        return "<html>" + nodes.fold("") { acc, node -> acc + node.toString() } + "</html>"
    }


}

class Body(private val content: String) : Node {
    override fun toString(): String {
        return content
    }
}


val Int.days: Period
    get() = Period.ofDays(this)

val Period.ago: LocalDate
    get() = LocalDate.now() - this

val Period.after: LocalDate
    get() = LocalDate.now() + this

object 前

infix fun Int.天(ago: 前) = LocalDate.now() - Period.ofDays(this)

object 后

infix fun Int.天(after: 后) = LocalDate.now() + Period.ofDays(this)
