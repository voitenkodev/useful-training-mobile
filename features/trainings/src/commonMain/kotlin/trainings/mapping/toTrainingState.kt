package trainings.mapping

import DateTimeKtx
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toPersistentList
import toDoubleOrIntString
import toShortString
import trainings.state.Training

internal fun List<models.Training>.toState() = this
    .mapNotNull { it.toState() }
    .toImmutableList()

internal fun models.Training.toState(): Training? {
    return Training(
        id = id ?: return null,
        exercises = exercises.toState(),
        duration = duration ?: 0,
        dateIso = createdAt ?: "",
        startDate = createdAt?.let { DateTimeKtx.formattedTime(it) } ?: "",
        tonnage = tonnage?.toShortString() ?: "-",
        intensity = intensity?.toDoubleOrIntString() ?: "-",
        tonnageExerciseList = exercises.mapNotNull { it.tonnage?.toFloat() }.toPersistentList()
    )
}