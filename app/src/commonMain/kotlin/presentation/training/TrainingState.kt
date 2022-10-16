package presentation.training

import Action
import DateTimeKtx
import GlobalState
import ReducerForActionType
import ReduxGroups
import com.benasher44.uuid.uuid4
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import presentation.review.ReviewAction

data class TrainingState(
    val training: Training = Training(),
    val error: String? = null,
    val loading: Boolean = false
)

@Serializable
@Parcelize
data class Training(
    val id: String? = null,
    val exercises: List<Exercise> = listOf(Exercise()),
    val startDateTime: String = DateTimeKtx().currentTime(),
    val duration: String? = null,
    val tonnage: Double? = null,
    val countOfLifting: Int? = null,
    val intensity: Double? = null
) : Parcelable {

    // UI date internal.presentation
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
        val training: Training
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

    data class ProvideEmptyIteration(val exerciseId: String) : TrainingAction("PROVIDE_EMPTY_ITERATION_ACTION")

    data class Error(val message: String? = null) : TrainingAction("ERROR_ACTION")

    data class Loading(val value: Boolean) : TrainingAction("LOADING_ACTION")
}

val trainingReducer: ReducerForActionType<TrainingState, GlobalState, TrainingAction> = { state, _, action ->
    when (action) {
        is TrainingAction.PutTrainingAction -> state.copy(training = action.training)
        is TrainingAction.AddExerciseAction -> state.copy(training = state.training.addExercise())
        is TrainingAction.RemoveExerciseAction -> state.copy(training = state.training.removeExercise(action.exerciseId))
        is TrainingAction.SetNameExerciseAction -> state.copy(training = state.training.setNameOfExercise(action.exerciseId, action.value))
        is TrainingAction.SetRepeatExerciseIterationAction -> state.copy(training = state.training.setRepeatOfIteration(action.exerciseId, action.number, action.value))
        is TrainingAction.SetWeightExerciseIterationAction -> state.copy(training = state.training.setWeightOfIteration(action.exerciseId, action.number, action.value))
        is TrainingAction.ProvideEmptyIterations -> state.copy(training = state.training.provideEmptyIterations())
        is TrainingAction.ProvideEmptyIteration -> state.copy(training = state.training.provideEmptyIteration(action.exerciseId))
        is TrainingAction.ValidateExercises -> state.copy(training = state.training.validate())
        is TrainingAction.CalculateValues -> state.copy(training = state.training.calculateValues())
        is TrainingAction.CalculateDuration -> state.copy(training = state.training.calculateDuration())
        is TrainingAction.Error -> state.copy(error = action.message)
        is TrainingAction.Loading -> state.copy(loading = action.value)
    }
}

fun Training.setNameOfExercise(id: String, name: String): Training {
    return this.copy(exercises = this.exercises.map {
        if (it.id == id) {
            it.copy(name = name)
        } else it
    })
}

fun Training.setRepeatOfIteration(exerciseId: String, numberOfIteration: Int, repeat: String): Training {
    val exercises = this.exercises.map {
        if (it.id != exerciseId) {
            it
        } else {
            val iterations = it.iterations.mapIndexedNotNull { index, iteration ->
                val newRepeat = if (numberOfIteration == index) repeat else iteration.repeat
                if (newRepeat == "" && iteration.weight == "") null
                else Training.Exercise.Iteration(weight = iteration.weight, repeat = newRepeat)
            }
            it.copy(iterations = iterations)
        }
    }
    return copy(exercises = exercises)
}

fun Training.setWeightOfIteration(exerciseId: String, numberOfIteration: Int, weight: String): Training {
    val exercises = this.exercises.map {
        if (it.id != exerciseId) {
            it
        } else {
            val iterations = it.iterations.mapIndexedNotNull { index, iteration ->
                val newWeight = if (numberOfIteration == index) weight else iteration.weight
                if (newWeight == "" && iteration.repeat == "") null
                else Training.Exercise.Iteration(weight = newWeight, repeat = iteration.repeat)
            }
            it.copy(iterations = iterations)
        }
    }
    return copy(exercises = exercises)
}

fun Training.removeExercise(id: String): Training {
    val newList = this.exercises.mapNotNull { old -> if (old.id == id) null else old }
    return this.copy(exercises = newList)
}

fun Training.addExercise(): Training {
    val newExercises = this.exercises + Training.Exercise()
    return this.copy(exercises = newExercises)
}

fun Training.validate(): Training {
    val exercises = exercises.mapNotNull {
        val isNameValid = it.name.isNotBlank()
        val iterations = it.iterations.filter { iteration ->
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

fun Training.calculateValues(): Training {
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

fun Training.calculateDuration(): Training {
    return if (duration == null) this.copy(duration = DateTimeKtx().durationFrom(this.startDateTime))
    else this
}

fun Training.provideEmptyIterations(): Training {
    return this.copy(
        exercises = exercises.map {
            val lastIsNotEmpty = it.iterations.lastOrNull()?.weight != "" || it.iterations.lastOrNull()?.repeat != ""
            if (lastIsNotEmpty) it.copy(iterations = it.iterations + Training.Exercise.Iteration())
            else it
        }
    )
}

fun Training.provideEmptyIteration(exerciseId: String): Training {
    val exercise = this.exercises.find { it.id == exerciseId } ?: return this
    val lastIsNotEmpty = exercise.iterations.lastOrNull()?.weight != "" || exercise.iterations.lastOrNull()?.repeat != ""
    if (lastIsNotEmpty.not()) return this
    val newExercise = exercise.copy(iterations = exercise.iterations + Training.Exercise.Iteration())
    val newExercises = this.exercises.map { if (it.id == exerciseId) newExercise else it }
    return this.copy(exercises = newExercises)
}