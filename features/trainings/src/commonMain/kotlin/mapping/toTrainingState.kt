package mapping

import dto.backend.TrainingDTO
import training.Training

internal fun List<TrainingDTO>.toTrainingStateList() = this.map { it.toTrainingState() }

internal fun TrainingDTO.toTrainingState() = Training(
    id = id.toString(),
    exercises = exercises.toExerciseStateList(),
    duration = duration ?: "",
    startDateTime = date ?: "",
    tonnage = tonnage,
    countOfLifting = countOfLifting,
    intensity = intensity
)