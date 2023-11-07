plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "../../gradle/configs/kotlin.gradle")
apply(from = "../../gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.features.registration" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.domain.authentication)
                implementation(projects.domain.user)
                implementation(projects.common.architectureComponent)
                implementation(projects.common.platformApi)
                implementation(projects.common.utils)

                implementation(projects.designSystem.atom)
                implementation(projects.designSystem.molecule)
                implementation(projects.designSystem.components)

                implementation(projects.composeLibs.weightPicker)
                implementation(projects.composeLibs.heightPicker)

                implementation(compose.ui)
                implementation(compose.foundation)

                implementation(libs.koin.core)
            }
        }
    }
}
