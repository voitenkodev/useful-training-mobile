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
    // Compose KMM
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")

    // Navigation Decompose
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

rootProject.name = "AlienWorkout"

include(
    ":androidApp",
    ":shared",

    ":data",

    ":domain:trainings",
    ":domain:authentication",
    ":domain:exercise-examples",
    ":domain:muscles",
    ":domain:equipments",
    ":domain:user",
    ":domain:statistics",
    ":domain:common-models",

    ":services:network",
    ":services:database",
    ":services:preferences",
    ":services:image-core",

    "common:architecture-component",
    "common:utils",
    "common:platform-api",

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
    "compose-libs:muscles",
    "compose-libs:equipments",

    "features:authentication",
    "features:bottom-menu",
    "features:trainings",
    "features:statistics",
    "features:profile",
    "features:training-builder",
    "features:exercise-example",
    "features:search-exercise",
    "features:weight-history",
    "features:user-muscles",
    "features:user-equipments"
)
