import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.time.ZonedDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

plugins {
    java
    kotlin("jvm")
    kotlin("kapt")
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
    id("com.github.johnrengelman.shadow") version Deps.shadowVersion
    id("org.jetbrains.kotlin.plugin.allopen") version Deps.kotlinVersion
    application
}


the<DependencyManagementExtension>().apply {
    imports {
        mavenBom("io.micronaut:micronaut-bom:${Deps.micronautVersion}")
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.views:micronaut-views-thymeleaf")
    implementation("io.micronaut:micronaut-runtime")
    implementation("javax.annotation:javax.annotation-api")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-http-server-netty")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    kapt("io.micronaut:micronaut-inject-java")
    kapt("io.micronaut:micronaut-validation")
    kaptTest("io.micronaut:micronaut-inject-java")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testImplementation("org.jetbrains.spek:spek-api:1.1.5")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.1.0")
    testImplementation("org.jetbrains.spek:spek-junit-platform-engine:1.1.5")
}


// Thanks you, https://github.com/x80486
// https://github.com/micronaut-projects/micronaut-examples/issues/27

tasks.withType<ShadowJar> {
    archiveBaseName.set(project.name)
    archiveClassifier.set("shadow") // fat, shadow
    manifest.attributes.apply {
        put("Application-Name", project.name)
        put("Build-Date", ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME))
        put("Created-By", System.getProperty("user.name"))
        put("Gradle-Version", gradle.gradleVersion)
        put("Implementation-Version", "${project.version}")
        put("JDK-Version", System.getProperty("java.version"))
//        put("Main-Class", "com.github.qiuzhanghua.naut.Application")
    }
    mergeServiceFiles()
    archiveVersion.set("${project.version}")
}

val run by tasks.getting(JavaExec::class)
run.jvmArgs("-noverify", "-XX:TieredStopAtLevel=1")


application {
    mainClassName = "com.github.qiuzhanghua.naut.Application"
//  mainClass.set("com.github.qiuzhanghua.naut.Application")
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

repositories {
    jcenter()
}