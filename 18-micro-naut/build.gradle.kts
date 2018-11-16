import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.cli.common.arguments.mergeBeans
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm")
    kotlin("kapt")
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
    id("com.github.johnrengelman.shadow") version "4.0.2"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.3.10"
    application
}


the<DependencyManagementExtension>().apply {
    imports {
        mavenBom("io.micronaut:micronaut-bom:1.0.1")
    }
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))
//    implementation("io.micronaut:micronaut-inject")
//    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut:micronaut-runtime")
    implementation("javax.annotation:javax.annotation-api")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-http-server-netty")
    implementation("io.micronaut:micronaut-views")
    compile("org.thymeleaf:thymeleaf:3.0.10.RELEASE")
    kapt("io.micronaut:micronaut-inject-java")
    kapt("io.micronaut:micronaut-validation")
    kaptTest("io.micronaut:micronaut-inject-java")
    runtime("ch.qos.logback:logback-classic:1.2.3")
    runtime("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.4.1")
    testCompile("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testCompile("org.jetbrains.spek:spek-api:1.1.5")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.1.0")
    testRuntime("org.jetbrains.spek:spek-junit-platform-engine:1.1.5")
}


//TODO how to use shadowJar ?
//val shadowJar by tasks.getting(ShadowJar::class)   ???
//shadowJar {
//    mergeServiceFiles()
//}

val run by tasks.getting(JavaExec::class)
run.jvmArgs("-noverify", "-XX:TieredStopAtLevel=1")


application {
    mainClassName = "com.github.qiuzhanghua.naut.Application"
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform { }
}


val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
    javaParameters = true
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
    javaParameters = true
}