plugins {
    java
    kotlin("jvm")
    application
}

application {
    mainClassName = "com.github.qiuzhanghua.learn.KtorServerKt"
}

val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-html-builder:$ktorVersion")
    implementation("io.ktor:ktor-server-host-common:$ktorVersion")
    implementation("io.ktor:ktor-locations:$ktorVersion")
    implementation("io.ktor:ktor-metrics:$ktorVersion")
    implementation("io.ktor:ktor-server-sessions:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")
    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")

}
repositories {
    jcenter()
}
