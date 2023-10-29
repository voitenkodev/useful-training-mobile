package trainings.mapping

import DateTimeKtx
import kotlinx.collections.immutable.toPersistentList
import toDoubleOrIntString
import toShortString
import trainings.state.Training

internal fun models.Training.toState() = Training(
    id = id.toString(),
    exercises = exercises.toState(),
    duration = duration ?: 0,
    dateIso = date ?: "",
    startDate = date?.let { DateTimeKtx.formattedTime(it) } ?: "",
    tonnage = tonnage?.toShortString() ?: "-",
    intensity = intensity?.toDoubleOrIntString() ?: "-",
    tonnageExerciseList = exercises.mapNotNull { it.tonnage?.toFloat() }.toPersistentList()
)