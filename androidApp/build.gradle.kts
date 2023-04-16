plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
}

apply(from = "../config/gradle/build-scripts/android.gradle")

kotlin {
    android()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))
                implementation(libs.appcompat)
                implementation(libs.activity.compose)
                implementation(libs.koin.android)
            }
        }
    }
}

android.defaultConfig {
    applicationId = "com.voitenko.usefultraining"
}