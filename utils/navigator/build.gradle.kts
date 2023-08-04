plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

apply(from = "../../config/gradle/build-scripts/kotlin.gradle")
apply(from = "../../config/gradle/build-scripts/android.gradle")

android { namespace = "com.voitenko.usefultraining.utils.navigator" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.foundation)
            }
        }
    }
}