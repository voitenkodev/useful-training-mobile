package presentation.state

import utils.DateTimeKtx
import kotlin.math.round

fun TrainingState.validate(): TrainingState? {
    val exercises = exercises.mapNotNull {

        val isNameValid = it.name.isNotBlank()

        val iterations = it.iterations.filter {
            val repeat = it.repeat.toIntOrNull()
            val weight = it.weight.toDoubleOrNull()
            val isRepeatValid = repeat != null && repeat > 0.0
            val isWeightValid = weight != null && weight > 0
            isRepeatValid && isWeightValid
        }
        if (isNameValid && iterations.isNotEmpty()) it.copy(iterations = iterations)
        else null
    }

    return if (exercises.isNotEmpty()) this.copy(exercises = exercises)
    else null
}

fun TrainingState.calculateValues(): TrainingState {
    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }

    val calculatedExercises = exercises.map {
        val exTonnage = it.iterations.sumOf { it.tonnage }
        val exCountOfLifting = it.iterations.sumOf { it.countOfLifting }
        val exIntensity = (exTonnage / exCountOfLifting)
        it.copy(
            tonnage = exTonnage.round(2),
            countOfLifting = exCountOfLifting,
            intensity = exIntensity.round(1)
        )
    }

    val trainTonnage = calculatedExercises.sumOf { it.tonnage }
    val trainCountOfLifting = calculatedExercises.sumOf { it.countOfLifting }
    val trainIntensity = trainTonnage / trainCountOfLifting

    return this.copy(
        exercises = calculatedExercises,
        tonnage = trainTonnage.round(2),
        countOfLifting = trainCountOfLifting,
        intensity = trainIntensity.round(1)
    )
}

fun TrainingState.calculateDuration(): TrainingState {
    return if (duration == null)
        this.copy(duration = DateTimeKtx().durationFrom(this.startDateTime))
    else
        this
}

fun TrainingState.pushEmptyIterations(): TrainingState {
    return this.copy(
        exercises = exercises.map {
            it.copy(iterations = it.iterations.addEmptyIteration())
        }
    )
}

fun List<TrainingState.Exercise.Iteration>.addEmptyIteration(): List<TrainingState.Exercise.Iteration> {
    val lastIsNotEmpty = this.lastOrNull()?.weight != "" || this.lastOrNull()?.repeat != ""
    return if (lastIsNotEmpty) this + TrainingState.Exercise.Iteration()
    else this
}

fun List<TrainingState.Exercise.Iteration>.changeIterationByIndex(
    weight: String? = null, repeat: String? = null, index: Int
): List<TrainingState.Exercise.Iteration> {
    return this.mapIndexedNotNull { i, old ->
        val newWeight = if (i == index && weight != null) weight else old.weight
        val newRepeat = if (i == index && repeat != null) repeat else old.repeat
        val result = TrainingState.Exercise.Iteration(weight = newWeight, repeat = newRepeat)
        if (result != TrainingState.Exercise.Iteration()) result else null
    }
}

fun TrainingState.removeExercise(exercise: TrainingState.Exercise): TrainingState {
    val newList = this.exercises.mapNotNull { old -> if (old.id == exercise.id) null else old }
    return this.copy(exercises = newList)
}

fun TrainingState.updateExercise(exercise: TrainingState.Exercise): TrainingState {
    val newList = this.exercises.map { old -> if (old.id == exercise.id) exercise else old }
    return this.copy(exercises = newList)
}

fun TrainingState.addExercise(): TrainingState {
    val newExercises = this.exercises + TrainingState.Exercise()
    return this.copy(exercises = newExercises)
}