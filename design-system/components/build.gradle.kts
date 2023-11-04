plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "../../gradle/configs/kotlin.gradle")
apply(from = "../../gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.designsystem.components" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.designSystem.molecule)
                implementation(projects.designSystem.atom)
                implementation(projects.designSystem.resources)
                implementation(projects.common.platformApi)

                implementation(compose.ui)
                implementation(compose.material)
            }
        }
    }
}
