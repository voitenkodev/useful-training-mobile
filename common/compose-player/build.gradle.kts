plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "../../config/gradle/build-scripts/kotlin.gradle")
apply(from = "../../config/gradle/build-scripts/android.gradle")

android { namespace = "com.voitenko.usefultraining.common.composeplayer" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.common.platformApi)
                implementation(projects.common.resources)

                // Compose
                implementation(compose.ui)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.media3.exoplayer)
                implementation(libs.media3.exoplayer.dash)
                implementation(libs.media3.exoplayer.ui)
            }
        }
        val iosMain by getting {
            dependencies {}
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
    }
}
