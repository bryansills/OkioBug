plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")

    implementation("androidx.compose.ui:ui:1.1.0-SNAPSHOT")
    implementation("androidx.compose.material:material:1.1.0-SNAPSHOT")
    implementation("androidx.compose.ui:ui-tooling-preview:1.1.0-SNAPSHOT")
    implementation("androidx.activity:activity-compose:1.4.0-SNAPSHOT")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-SNAPSHOT")
    debugImplementation("androidx.compose.ui:ui-tooling:1.1.0-SNAPSHOT")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "ninja.bryansills.okiobug.android"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0-SNAPSHOT"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
