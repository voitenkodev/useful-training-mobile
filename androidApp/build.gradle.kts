plugins {
    kotlin("multiplatform")
    id("com.android.application")
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
                implementation(libs.koin.android)
            }
        }
    }
}