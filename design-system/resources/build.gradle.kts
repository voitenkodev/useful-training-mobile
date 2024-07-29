plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.cocoapods)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.core)
}

apply(from = "$rootDir/gradle/configs/android.gradle")
apply(from = "$rootDir/gradle/configs/ios.gradle")
apply(from = "$rootDir/gradle/configs/kotlin.gradle")

android { namespace = "com.voitenko.alienworkout.designsystem.resources" }

kotlin.cocoapods { podfile = project.file("../../iosApp/Podfile") }

compose.resources {
    publicResClass = true
    packageOfResClass = "com.voitenko.alienworkout.designsystem.resources"
    generateResClass = always
}

kotlin {
    composeCompiler {
        // Enable 'strong skipping'
        // https://medium.com/androiddevelopers/jetpack-compose-strong-skipping-mode-explained-cbdb2aa4b900
        enableStrongSkippingMode.set(true)
    }

    sourceSets {
        commonMain.dependencies {
            // Compose
            implementation(compose.ui)
            implementation(compose.material)
            implementation(compose.components.resources)
        }
    }
}
