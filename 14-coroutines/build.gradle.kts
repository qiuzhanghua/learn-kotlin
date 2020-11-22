plugins {
    java
    kotlin("jvm")
    application
}

application {
    mainClassName = "com.github.qiuzhanghua.learn.CoroutinesKt"
}

dependencies {
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core", "${Deps.coroutinesVersion}")
}

repositories {
    jcenter()
}