plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

apply(from = "../../config/gradle/build-scripts/android.gradle")
apply(from = "../../config/gradle/build-scripts/kotlin.gradle")

android { namespace = "com.voitenko.usefultraining.utils.charts" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Compose
                implementation(compose.ui)
                implementation(compose.foundation)
            }
        }
    }
}
