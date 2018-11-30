import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar


buildscript {

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${Deps.springBootVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Deps.kotlinVersion}")
        classpath("org.jetbrains.kotlin:kotlin-allopen:${Deps.kotlinVersion}")
        classpath("org.jetbrains.kotlin:kotlin-noarg:${Deps.kotlinVersion}")
    }
}
plugins {
    java
    kotlin("jvm")
 }

// apply(plugin = "kotlin")
apply(plugin = "kotlin-spring")
apply(plugin = "kotlin-jpa")
// apply(plugin = "eclipse")
apply(plugin= "org.springframework.boot")
apply(plugin = "io.spring.dependency-management")

the<DependencyManagementExtension>().apply {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
}

//tasks.getByName<BootJar>("bootJar") {
//    mainClassName = "com.github.qiuzhanghua.springboot.ApplicationKt"
//    manifest {
//        attributes("Start-Class" to "com.github.qiuzhanghua.springboot.ApplicationKt")
//    }
//}
//
//springBoot {
//    mainClassName = "com.github.qiuzhanghua.springboot.ApplicationKt"
//}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}


val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}