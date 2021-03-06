buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("com.android.tools.build:gradle:7.1.0-alpha05")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://androidx.dev/snapshots/builds/7599071/artifacts/repository")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
