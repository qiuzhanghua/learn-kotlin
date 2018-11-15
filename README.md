# Learn Kotlin step by step

1. Be sure JDK 8/11 installed.
2. Be sure gradle 5.x(at lease 4.10.2) installed.
3. Be sure IntelliJ IDEA (CE) installed.
4. Be sure Kotlin Plugins of IDEA updated to the latest version(at least 1.3.10)
5. Create a file named _init.gradle.kts_ under dir of $HOME/.gradle/, as

```kotlin
allprojects {
    repositories {
        maven {
            url = uri("http://**replace-me-with-your-nexus-server**:8081/repository/maven-public")
        }
        mavenCentral()
    }
}
```

