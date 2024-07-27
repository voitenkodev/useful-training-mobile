plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.core)
    alias(libs.plugins.kotlin.serialization)
}

apply(from = "$rootDir/gradle/configs/kotlin.gradle")
apply(from = "$rootDir/gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.common.architecturecomponent" }

kotlin {
    composeCompiler {
        // Enable 'strong skipping'
        // https://medium.com/androiddevelopers/jetpack-compose-strong-skipping-mode-explained-cbdb2aa4b900
        enableStrongSkippingMode.set(true)
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.foundation)

                // Decompose
                api(libs.decompose)
                api(libs.decompose.extensions)
                api(libs.decompose.router)

                // Koin
                implementation(libs.koin.core)
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