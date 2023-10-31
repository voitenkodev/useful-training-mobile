package trainings.mapping

import DateTimeKtx
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toPersistentList
import toDoubleOrIntString
import toShortString
import trainings.state.Training

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
        tonnage = tonnage.toShortString(),
        intensity = intensity.toDoubleOrIntString(),
        tonnageExerciseList = exercises.map { it.tonnage.toFloat() }.toPersistentList()
    )
}