plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

apply(from = "../../config/gradle/build-scripts/kotlin.gradle")
apply(from = "../../config/gradle/build-scripts/android.gradle")

android { namespace = "com.voitenko.usefultraining.utils.designsystem" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.utils.instruments)
                implementation(projects.utils.resources)
                implementation(projects.utils.composePlayer)
                implementation(projects.utils.platformApi)

                // Compose
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
            }
        }

        val androidMain by getting {
            dependencies {}
        }

        val iosMain by getting {
            dependencies {}
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
    }
}
