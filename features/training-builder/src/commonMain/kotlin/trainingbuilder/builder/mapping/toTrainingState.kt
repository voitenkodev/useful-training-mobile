package trainingbuilder.builder.mapping

import trainingbuilder.builder.state.Training

internal fun models.Training.toState() = Training(
    id = id.toString(),
    exercises = exercises.toState(),
    duration = duration,
    startDateTime = createdAt ?: "",
    volume = volume,
    repetitions = repetitions,
    intensity = intensity
)