plugins {
    java
    kotlin("jvm")
    application
}
application {
    mainClassName = "com.github.qiuzhanghua.learn.CollectionsKt"
}
dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.0")
    testCompile("junit:junit:4.12")
}