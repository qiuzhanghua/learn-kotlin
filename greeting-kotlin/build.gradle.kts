plugins {
    java
    kotlin("jvm")
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "4.12")
}

repositories {
    jcenter()
}