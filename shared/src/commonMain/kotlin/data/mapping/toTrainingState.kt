package data.mapping

import data.dto.TrainingDTO
import presentation.training.Training

internal fun List<TrainingDTO?>.toTrainingStateList() = this.mapNotNull { it?.toTrainingState() }

internal fun TrainingDTO.toTrainingState() = Training(
    id = id.toString(),
    exercises = exercises.toExerciseStateList(),
    duration = duration ?: "",
    startDateTime = date ?: "",
    tonnage = tonnage,
    countOfLifting = countOfLifting,
    intensity = intensity
)