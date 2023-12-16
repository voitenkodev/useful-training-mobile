plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.parcelize)
}

apply(from = "../../gradle/configs/kotlin.gradle")
apply(from = "../../gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.features.exerciseexample" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.domain.exerciseExamplesMuscles)

                implementation(projects.common.architectureComponent)
                implementation(projects.common.utils)

                implementation(projects.designSystem.atom)
                implementation(projects.designSystem.molecule)
                implementation(projects.designSystem.components)
                implementation(projects.designSystem.resources)

                implementation(projects.composeLibs.musclePicker)
                implementation(projects.composeLibs.composeVideo)
                implementation(projects.composeLibs.composeImage)
                implementation(projects.composeLibs.charts)

                implementation(compose.ui)
                implementation(compose.foundation)

                implementation(libs.immutable.collections)
                implementation(libs.koin.core)
            }
        }
    }
}
