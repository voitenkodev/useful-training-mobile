plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

apply(from = "../../gradle/configs/kotlin.gradle")
apply(from = "../../gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.domain.authentication" }

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
