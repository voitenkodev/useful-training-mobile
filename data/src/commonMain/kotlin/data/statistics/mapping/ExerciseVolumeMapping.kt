package data.statistics.mapping

import models.ExerciseVolume
import network.models.ExerciseVolumeDto

internal fun List<ExerciseVolumeDto>.dtoToDomain(): List<ExerciseVolume> {
    return this.mapNotNull {
        it.dtoToDomain()
    }
}

internal fun ExerciseVolumeDto.dtoToDomain(): ExerciseVolume? {
    return ExerciseVolume(
        createdAt = createdAt ?: return null,
        exerciseExampleId = exerciseExampleId ?: return null,
        volume = volume ?: return null,
        id = id ?: return null
    )
}