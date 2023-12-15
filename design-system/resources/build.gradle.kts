plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.cocoapods)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
    alias(libs.plugins.moko.resources)
}

apply(from = "../../gradle/configs/android.gradle")
apply(from = "../../gradle/configs/ios.gradle")
apply(from = "../../gradle/configs/kotlin.gradle")

android { namespace = "com.voitenko.alienworkout.designsystem.resources" }

kotlin.cocoapods { podfile = project.file("../../iosApp/Podfile") }

multiplatformResources {
    multiplatformResourcesPackage = "com.voitenko.alienworkout"
    multiplatformResourcesClassName = "SharedRes"
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Compose
                implementation(compose.ui)
                implementation(compose.material)

                // Moko
                implementation(libs.moko.resources)
                implementation(libs.moko.resources.compose)
            }
        }
        val androidMain by getting {
            dependencies {
                dependsOn(commonMain)
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
