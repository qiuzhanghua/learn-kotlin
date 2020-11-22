import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm")
    kotlin("kapt")
    id("com.github.johnrengelman.shadow") version Deps.shadowVersion
    id("io.micronaut.application") version "1.2.0"
    application
}

micronaut {
    version(Deps.micronautVersion)
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
}


dependencies {
    implementation("io.micronaut:micronaut-validation")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Deps.kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${Deps.kotlinVersion}")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut:micronaut-runtime")
    implementation("javax.annotation:javax.annotation-api")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa")
    implementation("io.micronaut.kotlin:micronaut-kotlin-extension-functions")
    implementation("io.micronaut.views:micronaut-views-thymeleaf")
    implementation("io.micronaut.xml:micronaut-jackson-xml")
    implementation("org.apache.logging.log4j:log4j-core:2.12.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testImplementation("org.jetbrains.spek:spek-api:1.1.5")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.1.0")
    testImplementation("org.jetbrains.spek:spek-junit-platform-engine:1.1.5")
}


application {
    mainClassName = "com.github.qiuzhanghua.naut.Application"
//  mainClass.set("com.github.qiuzhanghua.naut.Application")
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform { }
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "11"
    javaParameters = true
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "11"
    javaParameters = true
}

repositories {
    jcenter()
}