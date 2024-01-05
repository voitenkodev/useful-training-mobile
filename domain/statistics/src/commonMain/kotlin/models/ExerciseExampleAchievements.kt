package models

public data class ExerciseExampleAchievements(
    val lastVolumes: List<ExerciseVolume>,
    val maxRepetition: MaxRepetition,
    val maxVolume: ExerciseVolume,
    val maxWeight: MaxWeight
)