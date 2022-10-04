package redux

import com.benasher44.uuid.uuid4
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import org.reduxkotlin.ReducerForActionType
import utils.DateTimeKtx

@Serializable
@Parcelize
data class TrainingState(
    val id: String? = null,
    val exercises: List<Exercise> = listOf(Exercise()),
    val startDateTime: String = DateTimeKtx().currentTime(),
    val duration: String? = null,
    val tonnage: Double? = null,
    val countOfLifting: Int? = null,
    val intensity: Double? = null
) : Parcelable {

    // UI date presentation
    val weekDay: String
        get() = DateTimeKtx().formattedWeekDay(startDateTime) ?: ""
    val startTime: String
        get() = DateTimeKtx().formattedTime(startDateTime) ?: ""
    val shortStartDate: String
        get() = DateTimeKtx().formattedShortDate(startDateTime) ?: ""
    val startLongDate: String
        get() = DateTimeKtx().formattedLongDate(startDateTime) ?: ""
    val durationTime: String
        get() = duration?.let { DateTimeKtx().formattedDuration(it) } ?: ""
    val endOfWeek: String
        get() = DateTimeKtx().formattedEndOfWeek(startDateTime) ?: ""

    @Serializable
    @Parcelize
    data class Exercise(
        val id: String = uuid4().toString(),
        val name: String = "",
        val iterations: List<Iteration> = listOf(Iteration()),
        val tonnage: Double = 0.0,
        val countOfLifting: Int = 0,
        val intensity: Double = 0.0
    ) : Parcelable {

        @Serializable
        @Parcelize
        data class Iteration(
            val weight: String = "",
            val repeat: String = ""
        ) : Parcelable
    }
}

sealed class TrainingAction(action: String) : Action(ReduxGroups.TRAINING, action) {
    data class PutTrainingAction(
        val training: TrainingState
    ) : TrainingAction("PUT_TRAINING_ACTION")

    data class SetNameExerciseAction(
        val exerciseId: String, val value: String
    ) : TrainingAction("SET_NAME_EXERCISE_ACTION")

    data class SetWeightExerciseIterationAction(
        val exerciseId: String, val number: Int, val value: String
    ) : TrainingAction("SET_WEIGHT_EXERCISE_ITERATION_ACTION")

    data class SetRepeatExerciseIterationAction(
        val exerciseId: String, val number: Int, val value: String
    ) : TrainingAction("SET_REPEAT_EXERCISE_ITERATION_ACTION")

    object AddExerciseAction : TrainingAction("ADD_EXERCISE_ACTION")

    data class RemoveExerciseAction(
        val exerciseId: String,
    ) : TrainingAction("REMOVE_EXERCISE_ACTION")

    object ValidateExercises : TrainingAction("VALIDATE_EXERCISES_ACTION")

    object CalculateValues : TrainingAction("CALCULATE_VALUES_ACTION")

    object CalculateDuration : TrainingAction("CALCULATE_DURATION_ACTION")

    object ProvideEmptyIterations : TrainingAction("PROVIDE_EMPTY_ITERATIONS_ACTION")

    data class ProvideEmptyIteration(
        val exerciseId: String,
    ) : TrainingAction("PROVIDE_EMPTY_ITERATION_ACTION")
}

val trainingReducer: ReducerForActionType<TrainingState, TrainingAction> = { state, action ->
    when (action) {
        is TrainingAction.PutTrainingAction -> action.training
        is TrainingAction.AddExerciseAction -> state.addExercise()
        is TrainingAction.RemoveExerciseAction -> state.removeExercise(action.exerciseId)
        is TrainingAction.SetNameExerciseAction -> state.setNameOfExercise(action.exerciseId, action.value)
        is TrainingAction.SetRepeatExerciseIterationAction -> state.setRepeatOfIteration(action.exerciseId, action.number, action.value)
        is TrainingAction.SetWeightExerciseIterationAction -> state.setWeightOfIteration(action.exerciseId, action.number, action.value)
        is TrainingAction.ProvideEmptyIterations -> state.provideEmptyIterations()
        is TrainingAction.ProvideEmptyIteration -> state.provideEmptyIteration(action.exerciseId)
        is TrainingAction.ValidateExercises -> state.validate()
        is TrainingAction.CalculateValues -> state.calculateValues()
        is TrainingAction.CalculateDuration -> state.calculateDuration()
    }
}

fun TrainingState.setNameOfExercise(id: String, name: String): TrainingState {
    return this.copy(exercises = this.exercises.map {
        if (it.id == id) {
            it.copy(name = name)
        } else it
    })
}

fun TrainingState.setRepeatOfIteration(exerciseId: String, numberOfIteration: Int, repeat: String): TrainingState {
    val exercises = this.exercises.map {
        if (it.id != exerciseId) {
            it
        } else {
            val iterations = it.iterations.mapIndexed { index, iteration ->
                val newRepeat = if (numberOfIteration == index) repeat else iteration.repeat
                TrainingState.Exercise.Iteration(weight = iteration.weight, repeat = newRepeat)
            }
            it.copy(iterations = iterations)
        }
    }
    return copy(exercises = exercises)
}

fun TrainingState.setWeightOfIteration(exerciseId: String, numberOfIteration: Int, weight: String): TrainingState {
    val exercises = this.exercises.map {
        if (it.id != exerciseId) {
            it
        } else {
            val iterations = it.iterations.mapIndexed { index, iteration ->
                val newWeight = if (numberOfIteration == index) weight else iteration.weight
                TrainingState.Exercise.Iteration(weight = newWeight, repeat = iteration.repeat)
            }
            it.copy(iterations = iterations)
        }
    }
    return copy(exercises = exercises)
}

fun TrainingState.removeExercise(id: String): TrainingState {
    val newList = this.exercises.mapNotNull { old -> if (old.id == id) null else old }
    return this.copy(exercises = newList)
}

fun TrainingState.addExercise(): TrainingState {
    val newExercises = this.exercises + TrainingState.Exercise()
    return this.copy(exercises = newExercises)
}

fun TrainingState.validate(): TrainingState {
    val exercises = exercises.mapNotNull {
        val isNameValid = it.name.isNotBlank()
        val iterations = it.iterations.filter {iteration ->
            val repeat = iteration.repeat.toIntOrNull()
            val weight = iteration.weight.toDoubleOrNull()
            val isRepeatValid = repeat != null && repeat > 0.0
            val isWeightValid = weight != null && weight > 0
            isRepeatValid && isWeightValid
        }
        if (isNameValid && iterations.isNotEmpty()) it.copy(iterations = iterations)
        else null
    }
    return this.copy(exercises = exercises)
}

fun TrainingState.calculateValues(): TrainingState {
    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return kotlin.math.round(this * multiplier) / multiplier
    }

    val calculatedExercises = exercises.map {
        val exTonnage = it.iterations.sumOf { iteration ->
            (iteration.repeat.toIntOrNull() ?: 0) * (iteration.weight.toDoubleOrNull() ?: 0.0)
        }
        val exCountOfLifting = it.iterations.sumOf { iteration ->
            iteration.repeat.toIntOrNull() ?: 0
        }
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
    return if (duration == null) this.copy(duration = DateTimeKtx().durationFrom(this.startDateTime))
    else this
}

fun TrainingState.provideEmptyIterations(): TrainingState {
    return this.copy(
        exercises = exercises.map {
            val lastIsNotEmpty = it.iterations.lastOrNull()?.weight != "" || it.iterations.lastOrNull()?.repeat != ""
            if (lastIsNotEmpty) it.copy(iterations = it.iterations + TrainingState.Exercise.Iteration())
            else it
        }
    )
}

fun TrainingState.provideEmptyIteration(exerciseId: String): TrainingState {
    val exercise = this.exercises.find { it.id == exerciseId } ?: return this
    val lastIsNotEmpty = exercise.iterations.lastOrNull()?.weight != "" || exercise.iterations.lastOrNull()?.repeat != ""
    if (lastIsNotEmpty.not()) return this
    val newExercise = exercise.copy(iterations = exercise.iterations + TrainingState.Exercise.Iteration())
    val newExercises = this.exercises.map { if (it.id == exerciseId) newExercise else it }
    return this.copy(exercises = newExercises)
}