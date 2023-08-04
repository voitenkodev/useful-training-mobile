plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
}

apply(from = "../config/gradle/build-scripts/android.gradle")

android.defaultConfig { applicationId = "com.voitenko.usefultraining" }

kotlin {
    android()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(projects.shared)

                implementation(libs.appcompat)
                implementation(libs.activity.compose)
                implementation(libs.koin.android)
            }
        }
    }
}