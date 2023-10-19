package trainings.mapping

import DateTimeKtx
import trainings.state.Training

internal fun models.Training.toTrainingState() = Training(
    id = id.toString(),
    exercises = exercises.toExerciseStateList(),
    duration = duration?.let { DateTimeKtx.formattedDuration(it) } ?: "",
    dateIso = date ?: "",
    startDate = date?.let { DateTimeKtx.formattedTime(it) } ?: "",
    tonnage = tonnage,
    intensity = intensity
)