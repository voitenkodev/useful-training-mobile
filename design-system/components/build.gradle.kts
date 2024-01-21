plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "$rootDir/gradle/configs/kotlin.gradle")
apply(from = "$rootDir/gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.designsystem.components" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.designSystem.molecule)
                implementation(projects.designSystem.atom)
                implementation(projects.designSystem.resources)

                implementation(projects.common.utils)

                implementation(projects.composeLibs.composeImage)
                implementation(projects.composeLibs.charts)

                implementation(libs.immutable.collections)

                implementation(compose.ui)
                implementation(compose.material)
                implementation(compose.material3)
            }
        }
    }
}
