package exerciseexample.main.mapping

import DateTimeKtx
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import models.ExerciseVolume

internal fun List<ExerciseVolume>.toState(): ImmutableList<exerciseexample.main.models.ExerciseVolume> {
    return this.map {
        it.toState()
    }.toPersistentList()
}

internal fun ExerciseVolume.toState(): exerciseexample.main.models.ExerciseVolume {
    return exerciseexample.main.models.ExerciseVolume(
        createdAt = DateTimeKtx.formattedDate1(createdAt) ?: "-",
        exerciseExampleId = exerciseExampleId,
        id = id,
        volume = volume
    )
}