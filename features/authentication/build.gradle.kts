plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.parcelize)
}

apply(from = "../../gradle/configs/kotlin.gradle")
apply(from = "../../gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.features.authentication" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.domain.authentication)
                implementation(projects.domain.user)
                implementation(projects.domain.muscles)

                implementation(projects.common.utils)
                implementation(projects.common.architectureComponent)

                implementation(projects.designSystem.atom)
                implementation(projects.designSystem.molecule)
                implementation(projects.designSystem.components)
                implementation(projects.designSystem.resources)

                implementation(compose.ui)
                implementation(compose.foundation)

                implementation(projects.composeLibs.musclePicker)
                implementation(projects.composeLibs.weightPicker)
                implementation(projects.composeLibs.heightPicker)

                implementation(libs.immutable.collections)
                implementation(libs.koin.core)
            }
        }
    }
}
