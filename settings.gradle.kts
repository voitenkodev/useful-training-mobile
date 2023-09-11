pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }

    plugins {
        val kotlinVersion = extra["kotlin.version"] as String
        val agpVersion = extra["agp.version"] as String
        val composeVersion = extra["compose.version"] as String
        val sqldelightVersion = extra["sqldelight.version"] as String
        val mokoResources = extra["moko-resources"] as String

        kotlin("jvm").version(kotlinVersion)
        kotlin("multiplatform").version(kotlinVersion)
        kotlin("android").version(kotlinVersion)
        kotlin("plugin.serialization").version(kotlinVersion)
        kotlin("plugin.parcelize").version(kotlinVersion)
        id("com.android.base").version(agpVersion)
        id("com.android.application").version(agpVersion)
        id("com.android.library").version(agpVersion)
        id("org.jetbrains.compose").version(composeVersion)
        id("app.cash.sqldelight").version(sqldelightVersion)
        id("dev.icerock.mobile.multiplatform-resources").version(mokoResources)
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("gradle/wrapper/libs.versions.toml"))
        }
    }
}

rootProject.name = "UsefulTraining"

include(
    ":androidApp",
    ":shared",
    ":data",

    "utils:design-system",
    "utils:navigator",
    "utils:instruments",
    "utils:native-api",
    "utils:compose-player",
    "utils:resources",
    "utils:charts",

    "features:authentication",
    "features:trainings",
)
