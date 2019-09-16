plugins {
    java        
    application 
}

application {
    mainClassName = "com.github.qiuzhanghua.greeter.Greeter"
}

dependencies {
    compile(project(":greeting-java"))
    compile(project(":greeting-kotlin"))
}

repositories {
    jcenter()
}