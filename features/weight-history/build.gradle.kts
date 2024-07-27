plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.core)
    alias(libs.plugins.kotlin.serialization)
}

apply(from = "$rootDir/gradle/configs/kotlin.gradle")
apply(from = "$rootDir/gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.features.weighthistory" }

kotlin {
    composeCompiler {
        // Enable 'strong skipping'
        // https://medium.com/androiddevelopers/jetpack-compose-strong-skipping-mode-explained-cbdb2aa4b900
        enableStrongSkippingMode.set(true)
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.domain.user)

                implementation(projects.composeLibs.charts)
                implementation(projects.composeLibs.weightPicker)

                implementation(projects.common.utils)
                implementation(projects.common.architectureComponent)

                implementation(projects.designSystem.atom)
                implementation(projects.designSystem.molecule)
                implementation(projects.designSystem.components)
                implementation(projects.designSystem.resources)

                implementation(compose.ui)
                implementation(compose.foundation)

                implementation(libs.immutable.collections)
                implementation(libs.koin.core)
                implementation(libs.serialization)
            }
        }
    }
}
