plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

apply(from = "$rootDir/gradle/configs/kotlin.gradle")
apply(from = "$rootDir/gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.domain.commonmodels" }

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.coroutines)
        }
    }
}
