package presentation.training

import Action
import GlobalState
import ReduxGroups
import androidx.compose.runtime.Stable
import com.benasher44.uuid.uuid4
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import utils.DateTimeKtx

@Stable
internal data class TrainingState(
    val training: Training = Training(),
    val error: String? = null,
    val loading: Boolean = false,
    val exitWarningVisibility: Boolean = false,
    val removeExerciseId: String? = null
)

@Serializable
@Parcelize
@Stable
internal data class Training(
    val id: String? = null,
    val exercises: List<Exercise> = listOf(Exercise()),
    val startDateTime: String = DateTimeKtx.currentDateTime(),
    val duration: String? = null,
    val tonnage: Double? = null,
    val countOfLifting: Int? = null,
    val intensity: Double? = null
) : Parcelable {

    // UI date internal.presentation
    val weekDay: String
        get() = DateTimeKtx.formattedWeekDay(startDateTime) ?: ""
    val startTime: String
        get() = DateTimeKtx.formattedTime(startDateTime) ?: ""
    val shortStartDate: String
        get() = DateTimeKtx.formattedShortDate(startDateTime) ?: ""
    val shortStartDateTime: String
        get() = DateTimeKtx.formattedDateTime(startDateTime) ?: ""
    val startLongDate: String
        get() = DateTimeKtx.formattedLongDate(startDateTime) ?: ""
    val durationTime: String
        get() = duration?.let { DateTimeKtx.formattedDuration(it) } ?: ""
    val endOfWeek: String
        get() = DateTimeKtx.formattedEndOfWeekLongDate(startDateTime, false) ?: ""
    val startOfWeek: String
        get() = DateTimeKtx.formattedStartOfWeekLongDate(startDateTime, false) ?: ""


    @Serializable
    @Parcelize
    @Stable
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
        @Stable
        data class Iteration(
            val weight: String = "",
            val repeat: String = ""
        ) : Parcelable
    }
}

internal sealed class TrainingAction : Action(ReduxGroups.TRAINING) {

    data class PutTrainingAction(val training: Training) : TrainingAction()

    data class SetNameExerciseAction(val exerciseId: String, val value: String) : TrainingAction()

    data class SetWeightExerciseIterationAction(val exerciseId: String, val number: Int, val value: String) : TrainingAction()

    data class SetRepeatExerciseIterationAction(val exerciseId: String, val number: Int, val value: String) : TrainingAction()

    object AddExerciseAction : TrainingAction()

    data class RemoveExerciseAction(val exerciseId: String) : TrainingAction()

    object ValidateExercises : TrainingAction()

    object CalculateValues : TrainingAction()

    object CalculateDuration : TrainingAction()

    object ProvideEmptyIterations : TrainingAction()

    data class ProvideEmptyIteration(val exerciseId: String) : TrainingAction()

    data class Error(val message: String? = null) : TrainingAction()

    data class Loading(val value: Boolean) : TrainingAction()

    data class AskExitFromTraining(val value: Boolean) : TrainingAction()

    data class AskRemoveExercise(val exerciseId: String? = null) : TrainingAction()
}

//internal val trainingReducer: ReducerForActionType<TrainingState, GlobalState, TrainingAction> = { state, _, action ->
//    when (action) {
//        is TrainingAction.PutTrainingAction ->
//            state.copy(training = action.training)
//
//        is TrainingAction.AddExerciseAction ->
//            state.copy(training = state.training.addExercise())
//
//        is TrainingAction.RemoveExerciseAction ->
//            state.copy(training = state.training.removeExercise(action.exerciseId))
//
//        is TrainingAction.SetNameExerciseAction ->
//            state.copy(training = state.training.setNameOfExercise(action.exerciseId, action.value))
//
//        is TrainingAction.SetRepeatExerciseIterationAction ->
//            state.copy(training = state.training.setRepeatOfIteration(action.exerciseId, action.number, action.value))
//
//        is TrainingAction.SetWeightExerciseIterationAction ->
//            state.copy(training = state.training.setWeightOfIteration(action.exerciseId, action.number, action.value))
//
//        is TrainingAction.ProvideEmptyIterations ->
//            state.copy(training = state.training.provideEmptyIterations())
//
//        is TrainingAction.ProvideEmptyIteration ->
//            state.copy(training = state.training.provideEmptyIteration(action.exerciseId))
//
//        is TrainingAction.ValidateExercises ->
//            state.copy(training = state.training.validate())
//
//        is TrainingAction.CalculateValues ->
//            state.copy(training = state.training.calculateValues())
//
//        is TrainingAction.CalculateDuration ->
//            state.copy(training = state.training.calculateDuration())
//
//        is TrainingAction.Error ->
//            state.copy(error = action.message)
//
//        is TrainingAction.Loading ->
//            state.copy(loading = action.value)
//
//        is TrainingAction.AskExitFromTraining ->
//            state.copy(exitWarningVisibility = action.value)
//
//        is TrainingAction.AskRemoveExercise ->
//            state.copy(removeExerciseId = action.exerciseId)
//    }
//}

internal fun Training.setNameOfExercise(id: String, name: String): Training {
    return this.copy(exercises = this.exercises.map {
        if (it.id == id) {
            it.copy(name = name)
        } else it
    })
}

internal fun Training.setRepeatOfIteration(exerciseId: String, numberOfIteration: Int, repeat: String): Training {
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

internal fun Training.setWeightOfIteration(exerciseId: String, numberOfIteration: Int, weight: String): Training {
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

internal fun Training.removeExercise(id: String): Training {
    val newList = this.exercises.mapNotNull { old -> if (old.id == id) null else old }
    return this.copy(exercises = newList)
}

internal fun Training.addExercise(): Training {
    val newExercises = this.exercises + Training.Exercise()
    return this.copy(exercises = newExercises)
}

internal fun Training.validate(): Training {
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

internal fun Training.calculateValues(): Training {
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

internal fun Training.calculateDuration(): Training {
    return if (duration == null) this.copy(duration = DateTimeKtx.durationFrom(this.startDateTime))
    else this
}

internal fun Training.provideEmptyIterations(): Training {
    return this.copy(
        exercises = exercises.map {
            val lastIsNotEmpty = it.iterations.lastOrNull()?.weight != "" || it.iterations.lastOrNull()?.repeat != ""
            if (lastIsNotEmpty) it.copy(iterations = it.iterations + Training.Exercise.Iteration())
            else it
        }
    )
}

internal fun Training.provideEmptyIteration(exerciseId: String): Training {
    val exercise = this.exercises.find { it.id == exerciseId } ?: return this
    val lastIsNotEmpty = exercise.iterations.lastOrNull()?.weight != "" || exercise.iterations.lastOrNull()?.repeat != ""
    if (lastIsNotEmpty.not()) return this
    val newExercise = exercise.copy(iterations = exercise.iterations + Training.Exercise.Iteration())
    val newExercises = this.exercises.map { if (it.id == exerciseId) newExercise else it }
    return this.copy(exercises = newExercises)
}