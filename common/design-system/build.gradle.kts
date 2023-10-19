plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "../../config/gradle/build-scripts/kotlin.gradle")
apply(from = "../../config/gradle/build-scripts/android.gradle")

android { namespace = "com.voitenko.usefultraining.common.designsystem" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {

                implementation(projects.common.instruments)
                implementation(projects.common.resources)
                implementation(projects.common.composePlayer)
                implementation(projects.common.platformApi)

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
