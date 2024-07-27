plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.core)
}

apply(from = "$rootDir/gradle/configs/android.gradle")
apply(from = "$rootDir/gradle/configs/kotlin.gradle")

android { namespace = "com.voitenko.alienworkout.services.imagecore" }

kotlin {
    composeCompiler {
        // Enable 'strong skipping'
        // https://medium.com/androiddevelopers/jetpack-compose-strong-skipping-mode-explained-cbdb2aa4b900
        enableStrongSkippingMode.set(true)
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.ktor.core)
            implementation(libs.coil3)
            implementation(libs.coil3.network)
            api("io.coil-kt.coil3:coil-compose:3.0.0-alpha01") // todo get from versioncontrol
        }

        androidMain.dependencies {
            implementation(libs.ktor.okhttp)
            implementation(libs.coil3.gif)
            implementation(libs.coil3.svg)
            implementation(libs.coil3.video)
        }

        iosMain.dependencies {
            implementation(libs.ktor.darwin)
        }
    }
}
