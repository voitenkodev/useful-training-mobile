plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "$rootDir/gradle/configs/android.gradle")
apply(from = "$rootDir/gradle/configs/kotlin.gradle")

android { namespace = "com.voitenko.alienworkout.composelibs.charts" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.designSystem.atom)
                implementation(projects.common.utils)

                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(libs.immutable.collections)
            }
        }
    }
}
