package mapping

import dto.Training
import state.TrainingState

fun List<Training?>.toTrainingStateList() = this.mapNotNull { it?.toTrainingState() }

fun Training.toTrainingState() = TrainingState(
    id = id.toString(),
    exercises = exercises.map {
        TrainingState.Exercise(
            id = it.id.toString(),
            name = it.name.toString(),
            iterations = it.iterations.map {
                TrainingState.Exercise.Iteration(
                    weight = it.weight.toString(),
                    repeat = it.repeat.toString()
                )
            },
        )
    },
    duration = duration.toString(),
    dateTime = date.toString(),
)