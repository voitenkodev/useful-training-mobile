plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("dev.icerock.mobile.multiplatform-resources")
}

apply(from = "../../config/gradle/build-scripts/android.gradle")
apply(from = "../../config/gradle/build-scripts/ios.gradle")
apply(from = "../../config/gradle/build-scripts/kotlin.gradle")

android { namespace = "com.voitenko.usefultraining.utils.resources" }

kotlin.cocoapods{ podfile = project.file("../../iosApp/Podfile") }

multiplatformResources {
    multiplatformResourcesPackage = "com.voitenko.usefultraining"
    multiplatformResourcesClassName = "SharedRes"
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.utils.nativeWrap)
                implementation(libs.moko.resources)
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
