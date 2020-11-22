plugins {
    java
    kotlin("jvm")
    application
}

application {
    mainClassName = "com.github.qiuzhanghua.learn.DslKt"
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform { }
}

dependencies {
     testImplementation(group = "io.kotlintest", name = "kotlintest-runner-junit5", version = "3.1.10")
}

repositories {
    jcenter()
}