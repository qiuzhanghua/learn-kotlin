plugins {
    java
    kotlin("jvm")
    application
}

application {
    mainClassName = "com.github.qiuzhanghua.learn.StdFunctionsKt"
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "${Deps.junitVersion}")
}

repositories {
    jcenter()
}