plugins {
    java
    kotlin("jvm")
    application
}

application {
    mainClassName = "com.github.qiuzhanghua.learn.CoroutinesKt"
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.jetbrains.kotlinx", "kotlinx-coroutines-core", "${Deps.coroutinesVersion}")
    testCompile("junit", "junit", "${Deps.junitVersion}")
}

repositories {
    jcenter()
}