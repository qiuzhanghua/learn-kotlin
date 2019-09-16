plugins {
    java
    kotlin("jvm")
    application
}

application {
    mainClassName = "com.github.qiuzhanghua.learn.FunctionsKt"
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "${Deps.junitVersion}")
}

repositories {
    jcenter()
}