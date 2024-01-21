plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "$rootDir/gradle/configs/kotlin.gradle")
apply(from = "$rootDir/gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.designsystem.molecule" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.designSystem.atom)
                implementation(projects.designSystem.resources)

                implementation(compose.ui)
                implementation(compose.material)
                implementation(compose.material3)
            }
        }
    }
}
