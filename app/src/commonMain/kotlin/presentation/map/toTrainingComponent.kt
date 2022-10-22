package presentation.map

import models.ExerciseComponent
import models.IterationComponent
import models.TrainingComponent
import presentation.training.Training

fun Training.toTrainingComponent() = TrainingComponent(
    exercises = exercises.map { it.toExerciseComponent() },
    startDateTime = startDateTime,
    duration = duration,
    tonnage = tonnage?.toString(),
    countOfLifting = countOfLifting,
    intensity = intensity?.toString(),
    weekDay = weekDay,
    startTime = startTime,
    shortStartDateTime = shortStartDateTime,
    shortStartDate = shortStartDate,
    startLongDate = startLongDate,
    durationTime = durationTime,
    endOfWeek = endOfWeek,
)

fun Training.Exercise.toExerciseComponent() = ExerciseComponent(
    name = name,
    iterations = iterations.map { it.toIterationComponent() },
    tonnage = tonnage.toString(),
    countOfLifting = countOfLifting.toString(),
    intensity = intensity.toString()
)

fun Training.Exercise.Iteration.toIterationComponent() = IterationComponent(
    weight = weight,
    repeat = repeat
)