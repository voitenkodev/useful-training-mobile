plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.core)
}

apply(from = "$rootDir/gradle/configs/kotlin.gradle")
apply(from = "$rootDir/gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.designsystem.components" }

kotlin {
    composeCompiler {
        // Enable 'strong skipping'
        // https://medium.com/androiddevelopers/jetpack-compose-strong-skipping-mode-explained-cbdb2aa4b900
        enableStrongSkippingMode.set(true)
    }

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
