package trainingbuilder.mapping

import trainingbuilder.state.Training

internal fun models.Training.toTrainingState() = Training(
    id = id.toString(),
    exercises = exercises.toExerciseStateList(),
    duration = duration ?: 0,
    startDateTime = createdAt ?: "",
    volume = volume,
    repetitions = repetitions,
    intensity = intensity
)