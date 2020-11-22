plugins {
    java        
    application 
}

application {
    mainClassName = "com.github.qiuzhanghua.greeter.Greeter"
}

dependencies {
    implementation(project(":greeting-java"))
    implementation(project(":greeting-kotlin"))
}

repositories {
    jcenter()
}