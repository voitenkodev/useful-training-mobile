plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

apply(from = "../../gradle/configs/kotlin.gradle")
apply(from = "../../gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.data.user" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.domain.user)
                implementation(projects.services.network)
                implementation(projects.services.database)

                implementation(libs.coroutines)
                implementation(libs.koin.core)
            }
        }
    }
}
