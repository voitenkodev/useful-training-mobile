package exerciseexample.main.mapping

import models.ExerciseExampleAchievements

internal fun ExerciseExampleAchievements.toState(): exerciseexample.main.models.ExerciseExampleAchievements {
    return exerciseexample.main.models.ExerciseExampleAchievements(
        lastVolumes = lastVolumes.toState(),
        maxRepetition = maxRepetition.toState(),
        maxVolume = maxVolume.toState(),
        maxWeight = maxWeight.toState()
    )
}