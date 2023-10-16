plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.app)
}

apply(from = "../config/gradle/build-scripts/android.gradle")

android.defaultConfig { applicationId = "com.voitenko.usefultraining" }

kotlin {
    androidTarget()

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