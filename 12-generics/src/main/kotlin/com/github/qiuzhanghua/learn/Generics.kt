package com.github.qiuzhanghua.learn

import java.util.*

fun main(args: Array<String>) {
    val listOfInt: List<Int> = listOf(1, 2, 3)
    val listOfChar: List<Char> = listOf('A', 'B', 'C')
    val listOfString: List<String> = listOf("Hello", "World")

    val box = Box<Int>(3)
    println(box.item)
    println(box.fetch { (it + 5).toString() + ",,," })

    println(listOfChar is List<Char>)
    println(listOfInt is List<Number>)
    println(listOfString is List<Any>)
    // list is out, produce only
    // Consumer in, Producer out!


    // Covariant
    val shop1: Shop<Goods> = NormalShop()
    val shop2: Shop<Goods> = FruitShop()
    val shop3: Shop<Goods> = AppleShop()

    // Contravariant
    val buyer1 : Consumer<Apple> = NormalOne()
    val buyer2 : Consumer<Apple> = FruitLover()
    val buyer3 : Consumer<Apple> = AppleLover()

    // for java, ? super T = in    and ? extends T = out
    val list1 = mutableListOf<Goods>(Goods())
    val list2 = listOf<Apple>(Apple())
    Collections.copy(list1, list2)
    println(list1)

}

class Box<T>(var item: T) {
    fun <R> fetch(f: (T)-> R) : R {
        return f(item)
    }
}


open class Goods
open class Fruit: Goods()
class Apple: Fruit()



interface Shop<out T> {
    fun provide() : T
}

class NormalShop: Shop<Goods> {
    override fun provide(): Goods {
        return Goods()
    }
}


class FruitShop: Shop<Fruit> {
    override fun provide(): Fruit {
        return Fruit()
    }
}


class AppleShop: Shop<Apple> {
    override fun provide(): Apple {
        return Apple()
    }
}


interface Consumer<in T> {
    fun buy(item : T)
}

class NormalOne : Consumer<Goods> {
    override fun buy(item: Goods) {
        println(item)
    }
}

class FruitLover: Consumer<Fruit> {
    override fun buy(item: Fruit) {
        println(item)
   }
}

class AppleLover: Consumer<Apple> {
    override fun buy(item: Apple) {
        println(item)
    }
}