package data.statistics.mapping

import models.ExerciseExampleAchievements
import network.models.ExerciseExampleAchievementsDto

internal fun ExerciseExampleAchievementsDto.dtoToDomain(): ExerciseExampleAchievements? {
    return ExerciseExampleAchievements(
        lastVolumes = lastVolumes?.dtoToDomain() ?: return null,
        maxVolume = maxVolume?.dtoToDomain() ?: return null,
        maxRepetition = maxRepetition?.dtoToDomain() ?: return null,
        maxWeight = maxWeight?.dtoToDomain() ?: return null
    )
}