plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

apply(from = "$rootDir/gradle/configs/kotlin.gradle")
apply(from = "$rootDir/gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.services.preferences" }

kotlin {
    sourceSets {
        commonMain.dependencies {
            // NativeContext
            implementation(projects.common.platformApi)

            implementation(libs.datastore)
        }
    }
}
