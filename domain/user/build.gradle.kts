plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

apply(from = "$rootDir/gradle/configs/kotlin.gradle")
apply(from = "$rootDir/gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.domain.user" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.domain.commonModels)

                implementation(libs.coroutines)
            }
        }
    }
}
