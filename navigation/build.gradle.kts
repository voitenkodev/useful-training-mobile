@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.serialization)
}

kotlin {
    explicitApi()

    android()
    iosX64("uikitX64")
    iosArm64("uikitArm64")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(libs.logger)
            }
        }

        val androidMain by getting { dependencies {} }
        val uikitMain by creating { dependsOn(commonMain) }
        val uikitX64Main by getting { dependsOn(uikitMain) }
        val uikitArm64Main by getting { dependsOn(uikitMain) }
    }

    kotlin.sourceSets.all {
        languageSettings.optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
        languageSettings.optIn("androidx.compose.ui.unit.ExperimentalUnitApi")
        languageSettings.optIn("androidx.compose.ui.text.ExperimentalTextApi")
        languageSettings.optIn("androidx.compose.foundation.ExperimentalFoundationApi")
        languageSettings.optIn("androidx.compose.ui.ExperimentalComposeUiApi")
        languageSettings.optIn("androidx.compose.animation.ExperimentalAnimationApi")
        languageSettings.optIn("kotlin.time.ExperimentalTime")
    }
}

android {
    namespace = "dev.voitenko.usefultraining.navigation2"
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig { minSdk = 21 }
    buildTypes.getByName("release") { isMinifyEnabled = true }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        kotlinOptions.allWarningsAsErrors = true
    }
}