import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.cli.common.arguments.mergeBeans
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.time.ZonedDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

plugins {
    java
    kotlin("jvm")
    kotlin("kapt")
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
    id("com.github.johnrengelman.shadow") version "${Deps.shadowVersion}"
    id("org.jetbrains.kotlin.plugin.allopen") version "${Deps.kotlinVersion}"
    application
}


the<DependencyManagementExtension>().apply {
    imports {
        mavenBom("io.micronaut:micronaut-bom:${Deps.micronautVersion}")
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
//    compile("org.jetbrains.kotlinx:atomicfu:0.11.12")
    compile("org.thymeleaf:thymeleaf:3.0.11.RELEASE")
    kapt("io.micronaut:micronaut-inject-java")
    kapt("io.micronaut:micronaut-validation")
    kaptTest("io.micronaut:micronaut-inject-java")
    runtime("ch.qos.logback:logback-classic:1.2.3")
    runtime("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
    testCompile("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testCompile("org.jetbrains.spek:spek-api:1.1.5")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.1.0")
    testRuntime("org.jetbrains.spek:spek-junit-platform-engine:1.1.5")
}


// Thanks you, https://github.com/x80486
// https://github.com/micronaut-projects/micronaut-examples/issues/27

tasks.withType<ShadowJar> {
        baseName = project.name
        classifier = "shadow" // fat, shadow
        manifest.attributes.apply {
            put("Application-Name", project.name)
            put("Build-Date", ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME))
            put("Created-By", System.getProperty("user.name"))
            put("Gradle-Version", gradle.gradleVersion)
            put("Implementation-Version", "${project.version}")
            put("JDK-Version", System.getProperty("java.version"))
        }
        mergeServiceFiles()
        version = "${project.version}"
}


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