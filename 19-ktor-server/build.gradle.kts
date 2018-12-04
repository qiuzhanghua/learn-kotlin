plugins {
    java
    kotlin("jvm")
    application
}

application {
    mainClassName = "com.github.qiuzhanghua.learn.KtorServerKt"
}

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("io.ktor:ktor-server-netty:$ktor_version")
    compile("ch.qos.logback:logback-classic:$logback_version")
    compile("io.ktor:ktor-server-core:$ktor_version")
    compile("io.ktor:ktor-html-builder:$ktor_version")
    compile("io.ktor:ktor-server-host-common:$ktor_version")
    compile("io.ktor:ktor-locations:$ktor_version")
    compile("io.ktor:ktor-metrics:$ktor_version")
    compile("io.ktor:ktor-server-sessions:$ktor_version")
    compile("io.ktor:ktor-jackson:$ktor_version")
    testCompile("io.ktor:ktor-server-tests:$ktor_version")

}