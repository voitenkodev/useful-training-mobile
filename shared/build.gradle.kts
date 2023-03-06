plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("io.github.skeptick.libres")
    id("org.jetbrains.kotlin.plugin.parcelize")
}

version = "1.0-SNAPSHOT"

kotlin {
    android()

    ios()

    iosSimulatorArm64()

    cocoapods {
        summary = "Shared Code"
        homepage = "https://github.com/voitenkodev/Useful-Training"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")

        framework {
            baseName = "shared"
            isStatic = true
        }
        extraSpecAttributes["resources"] = "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)

                // app
                implementation(libs.uuid)
                implementation(libs.parcelize)
                implementation(libs.serialization)
                implementation(libs.koin.core)

                //utils
                implementation(libs.datetime)
                implementation(libs.logger)

                implementation("dev.gitlive:firebase-auth:1.6.2")
                implementation("dev.gitlive:firebase-firestore:1.6.2")
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.koin.android)
                implementation("com.google.android.material:material:1.8.0")
            }
        }
        val iosMain by getting { dependencies {} }
//        val iosSimulatorArm64Main by getting { dependsOn(iosMain) } todo redux doesnt work
    }

    kotlin.sourceSets.all {
        languageSettings.optIn("androidx.compose.ui.text.ExperimentalTextApi")
        languageSettings.optIn("androidx.compose.foundation.ExperimentalFoundationApi")
        languageSettings.optIn("androidx.compose.ui.ExperimentalComposeUiApi")
        languageSettings.optIn("androidx.compose.material.ExperimentalMaterialApi")
        languageSettings.optIn("androidx.compose.ui.unit.ExperimentalMaterialApi")
        languageSettings.optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
        languageSettings.optIn("androidx.compose.ui.unit.ExperimentalUnitApi")
        languageSettings.optIn("androidx.compose.animation.ExperimentalAnimationApi")
        languageSettings.optIn("kotlin.time.ExperimentalTime")
    }
}

libres {
    generatedClassName = "AppRes"
    generateNamedArguments = true
    baseLocaleLanguageCode = "en"
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    namespace = "com.voitenko.usefultraining"

    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}