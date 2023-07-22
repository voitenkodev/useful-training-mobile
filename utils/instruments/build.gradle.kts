plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

apply(from = "../../config/gradle/build-scripts/kotlin.gradle")
apply(from = "../../config/gradle/build-scripts/android.gradle")

android { namespace = "com.voitenko.usefultraining.utils.instruments" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                //compose
                implementation(compose.foundation)
                implementation(compose.material)

                //utils
                implementation(libs.datetime)
            }
        }
    }
}