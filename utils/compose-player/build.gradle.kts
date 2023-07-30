plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

apply(from = "../../config/gradle/build-scripts/kotlin.gradle")
apply(from = "../../config/gradle/build-scripts/android.gradle")

android { namespace = "com.voitenko.usefultraining.utils.composeplayer" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.utils.nativeContext)

                //compose
                implementation(compose.ui)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.media3:media3-exoplayer:1.1.0")
                implementation("androidx.media3:media3-exoplayer-dash:1.1.0")
                implementation("androidx.media3:media3-ui:1.1.0")
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
