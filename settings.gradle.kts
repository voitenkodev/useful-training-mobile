pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement.repositories {
    google()
    mavenCentral()
    mavenLocal()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    // Navigation Decompose
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

rootProject.name = "AlienWorkout"

include(
    ":androidApp",
    ":shared",

    ":data:trainings",
    ":data:exercise-examples",
    ":data:authentication",
    ":data:user",

    ":domain:trainings",
    ":domain:authentication",
    ":domain:exercise-examples-muscles",
    ":domain:user",

    ":services:network",
    ":services:database",
    ":services:preferences",

    "common:architecture-component",
    "common:utils",
    "common:platform-api",
    "common:image-loader",

    "design-system:atom",
    "design-system:molecule",
    "design-system:components",
    "design-system:resources",

    "compose-libs:charts",
    "compose-libs:compose-video",
    "compose-libs:compose-image",
    "compose-libs:weight-picker",
    "compose-libs:height-picker",
    "compose-libs:percentage-picker",
    "compose-libs:muscle-picker",

    "features:splash",
    "features:authentication",
    "features:registration",
    "features:bottom-menu",
    "features:trainings",
    "features:statistics",
    "features:profile",
    "features:training-builder",
    "features:exercise-example-builder",
    "features:muscle-picker"
)
