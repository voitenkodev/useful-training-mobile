plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "$rootDir/gradle/configs/android.gradle")
apply(from = "$rootDir/gradle/configs/kotlin.gradle")

android { namespace = "com.voitenko.alienworkout.composelibs.percentagepicker" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.designSystem.atom)

                implementation(compose.ui)
                implementation(compose.foundation)
            }
        }
    }
}
