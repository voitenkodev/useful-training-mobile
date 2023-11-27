package trainings.list.mapping

import DateTimeKtx
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toPersistentList
import toDoubleOrIntString
import toShortString
import trainings.list.state.Training

internal fun List<models.Training>.toState(): ImmutableList<Training> {
    return mapNotNull { it.toState() }
        .toImmutableList()
}

internal fun models.Training.toState(): Training? {
    return Training(
        id = id ?: return null,
        exercises = exercises.toState(),
        duration = duration,
        dateIso = createdAt ?: "",
        startDate = createdAt?.let { DateTimeKtx.formattedTime(it) } ?: "",
        volume = volume.toShortString(),
        intensity = intensity.toDoubleOrIntString(),
        volumeExerciseList = exercises.map { it.volume.toFloat() }.toPersistentList()
    )
}