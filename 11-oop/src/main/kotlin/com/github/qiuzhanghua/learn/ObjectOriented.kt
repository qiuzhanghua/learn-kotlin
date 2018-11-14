package com.github.qiuzhanghua.learn

import java.util.*

fun main(args: Array<String>) {
    val p = Person()
    val student = Student()
    student.name = " eason "
    student.sayHi()

    val birth = Date(70, 9, 7)
    val teacher = Teacher("Me", birth)
    teacher.sayHi()
//    val anotherTeacher = Teacher("You", 13)
    println(teacher.brand)
    println(teacher.brand)
    println("no school print")
    teacher.printSchool()
    teacher.determinSchool()
    println("school print")
    teacher.printSchool()


    // inherited
    val apple  = Fruit("Apple", "earth")

    println(apple.x)

    println(apple is Fruit)
    println(apple is Food)
    println(apple is Any)
    println(apple is Nothing)
    println(apple.javaClass.name)

    var className = when (apple) {
        is Fruit -> "My Fruit"
        else -> "Any"
    }
    println(className)

//    println((apple as Food).javaClass.name)

    //object
    Manager.sayHi()
    Manager.sayHi()

    // for companion object , see greeting-kotlin

    val orange = object: Fruit("orange", "moon") {
        fun sayHi() {
            println("I'am orange")
        }
    }
    orange.sayHi()
    orange.sayHi()

    val obj = object {
        val name: String = "define object here"
    }
    println(obj)



    // data class
    val rect = Rectangle(3, 4)
    println(rect)
    rect.component1()
    rect.component2()

    val (x, y) = rect
    println("x = $x, y = $y")
    println(rect.copy(x = 8))
    println(rect == Rectangle(3, 4))


    //enum
    val direction = Direction.EAST
    direction.update(Direction.EAST)
    println(direction)

    // operator func
    val myInt = MyInt(9)
    println(myInt + 6)

    // interface

    val r = Rect(1,1, 10,20)
    println(r.area())

    // abstract will not show here
}

class Person

class Student {
    // public protected private internal
    fun sayHi() {
        println("Hi from $name, I'am $length")
    }

    var name = "student"
        get() = field.capitalize()
        // try add private to set,
        set(value) {
            field = value.trim()
        }
    val length
        get() = name.length
}

class Teacher(val name: String, var age: Int = 36) {
    init {
        require(age > 20) { "Age should greater than 20" }
        require(name.isNotBlank()) { "Name should be provided." }
    }

    fun sayHi() {
        println("I'am $name, and $age years old.")
    }

    constructor(name: String, birth: Date) : this(name) {
        this.age = 2018 - Calendar.getInstance().apply { time = birth }.get(Calendar.YEAR)
    }


    // one time change only
    val brand: Int by lazy {
        println("by lazy value of brand")
        9
    }

    // can be changed or Inject many times
    lateinit var school : String

    fun determinSchool() {
        school = "My school"
    }

    fun printSchool() {
        if (::school.isInitialized) println(school)
    }
}


open class Food(val name: String) {
    init {
        println("init Food")
    }

    open val x: Int get() = 1
}

open class Fruit(name: String, val from: String): Food(name) {
    init {
        println("init Fruit")
    }

    override val x:Int get() = super.x + 1

}

object Manager {
    init {
        println("object Manager is initialized")
    }
    fun sayHi() {
        println("I am Manager")
    }
}


data class Rectangle(val x: Int, val y: Int) {
    val isPositive = x > 0 && y > 0
    fun area() = x * y
}



//enum class Direction {
//    NORTH,
//    EAST,
//    SOUTH,
//    WEST
//}

enum class Direction(var x: Int, var y: Int) {
    NORTH(0,1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    fun update(direction: Direction) {
        this.x += direction.x
        this.y += direction.y
    }

    override fun toString(): String {
        return "(x = $x, y = $y)"
    }

}

class MyInt(var int: Int) {

    operator fun plus(i : Int) = MyInt(this.int + i)
    operator fun minus(i : Int) = MyInt(this.int - i)

    override fun toString(): String = int.toString()
}


interface Fingure {
    val x: Int
    val y: Int
    fun area() : Int = 0
}

class Point(override val x: Int, override val y: Int): Fingure {
    override fun area(): Int = 0
}

class Rect(override val x: Int, override  val y: Int, val w: Int, val h: Int):Fingure {
    override fun area(): Int = w * h
}