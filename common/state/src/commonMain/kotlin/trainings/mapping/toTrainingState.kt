package trainings.mapping

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toPersistentList
import toDoubleOrIntString
import trainings.Training

public fun List<models.Training>.toState(): ImmutableList<Training> {
    return mapNotNull { it.toState() }
        .toImmutableList()
}

public fun models.Training.toState(): Training? {
    return Training(
        id = id ?: return null,
        exercises = exercises.toState(),
        duration = duration,
        createdAt = createdAt ?: "",
        volume = volume,
        intensity = intensity.toDoubleOrIntString(),
        volumeExerciseList = exercises.map { it.volume.toFloat() }.toPersistentList()
    )
}