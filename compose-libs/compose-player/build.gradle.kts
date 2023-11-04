plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "../../gradle/configs/android.gradle")
apply(from = "../../gradle/configs/kotlin.gradle")

android { namespace = "com.voitenko.alienworkout.composelibs.composeplayer" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.common.platformApi)
                implementation(projects.designSystem.resources)

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
