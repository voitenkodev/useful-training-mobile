plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

apply(from = "$rootDir/gradle/configs/kotlin.gradle")
apply(from = "$rootDir/gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.domain.equipments" }

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.domain.commonModels)

            implementation(libs.coroutines)
        }
    }
}
