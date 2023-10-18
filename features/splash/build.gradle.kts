plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

apply(from = "../../config/gradle/build-scripts/kotlin.gradle")
apply(from = "../../config/gradle/build-scripts/android.gradle")

android { namespace = "com.voitenko.usefultraining.features.splash" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.domain.authentication)

                implementation(projects.common.designSystem)
                implementation(projects.common.architectureComponent)

                // Compose
                implementation(compose.ui)
                implementation(compose.foundation)

                // Koin
                implementation(libs.koin.core)
            }
        }
    }
}
