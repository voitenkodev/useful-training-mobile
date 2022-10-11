package presentation.map

import models.ExerciseComponent
import models.IterationComponent
import models.TrainingComponent
import redux.TrainingState

fun TrainingState.toTrainingComponent() = TrainingComponent(
    exercises = exercises.map { it.toExerciseComponent() },
    startDateTime = startDateTime,
    duration = duration,
    tonnage = tonnage?.toString(),
    countOfLifting = countOfLifting,
    intensity = intensity?.toString(),
    weekDay = weekDay,
    startTime = startTime,
    shortStartDate = shortStartDate,
    startLongDate = startLongDate,
    durationTime = durationTime,
    endOfWeek = endOfWeek,
)

fun TrainingState.Exercise.toExerciseComponent() = ExerciseComponent(
    name = name,
    iterations = iterations.map { it.toIterationComponent() },
    tonnage = tonnage.toString(),
    countOfLifting = countOfLifting.toString(),
    intensity = intensity.toString()
)

fun TrainingState.Exercise.Iteration.toIterationComponent() = IterationComponent(
    weight = weight,
    repeat = repeat
)