plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
}

apply(from = "../../config/gradle/build-scripts/android.gradle")
apply(from = "../../config/gradle/build-scripts/ios.gradle")
apply(from = "../../config/gradle/build-scripts/kotlin.gradle")

android {
    namespace = "com.voitenko.usefultraining.utils.resourcesfont"
    sourceSets["main"].res.srcDirs("src/commonMain/resources")
}

kotlin.cocoapods {
    podfile = project.file("../../iosApp/Podfile")
    extraSpecAttributes["resources"] = "['src/commonMain/resources/**']"
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.ui)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
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
