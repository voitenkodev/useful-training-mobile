package trainingbuilder.mapping

import trainingbuilder.state.Training

internal fun models.Training.toState() = Training(
    id = id.toString(),
    exercises = exercises.toState(),
    duration = duration,
    startDateTime = createdAt ?: "",
    volume = volume,
    repetitions = repetitions,
    intensity = intensity
)