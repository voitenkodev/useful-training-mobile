plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "../../gradle/configs/android.gradle")
apply(from = "../../gradle/configs/kotlin.gradle")

android { namespace = "com.voitenko.usefultraining.composelibs.weightpicker" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Compose
                implementation(compose.ui)
                implementation(compose.foundation)
            }
        }
    }
}
