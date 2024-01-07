plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

apply(from = "../gradle/configs/kotlin.gradle")
apply(from = "../gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.data" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.domain.authentication)
                implementation(projects.domain.user)
                implementation(projects.domain.trainings)
                implementation(projects.domain.exerciseExamples)
                implementation(projects.domain.muscles)
                implementation(projects.domain.statistics)
                implementation(projects.domain.equipments)

                implementation(projects.services.network)
                implementation(projects.services.database)
                implementation(projects.services.preferences)

                implementation(libs.coroutines)
                implementation(libs.koin.core)
            }
        }
    }
}
