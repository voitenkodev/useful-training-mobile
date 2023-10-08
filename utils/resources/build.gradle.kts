plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("dev.icerock.mobile.multiplatform-resources")
}

apply(from = "../../config/gradle/build-scripts/android.gradle")
apply(from = "../../config/gradle/build-scripts/ios.gradle")
apply(from = "../../config/gradle/build-scripts/kotlin.gradle")

android { namespace = "com.voitenko.usefultraining.utils.resources" }

kotlin.cocoapods { podfile = project.file("../../iosApp/Podfile") }

multiplatformResources {
    multiplatformResourcesPackage = "com.voitenko.usefultraining"
    multiplatformResourcesClassName = "SharedRes"
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.utils.platformApi)

                // Compose
                implementation(compose.ui)

                // Mokko
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
