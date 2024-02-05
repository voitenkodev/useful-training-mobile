package trainingbuilder.training_builder.pages.set_exercise

import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import trainingbuilder.training_builder.models.Exercise
import trainingbuilder.training_builder.models.ExerciseExample
import trainingbuilder.training_builder.models.Iteration
import trainingbuilder.training_builder.models.IterationTargetFocus

internal class SetExerciseStateHolder(selectedExercise: Exercise? = null, exerciseExample: ExerciseExample?) {

    private val _state = MutableStateFlow(
        SetExerciseState(
            exercise = selectedExercise ?: Exercise(
                name = exerciseExample?.name ?: "",
                exerciseExample = exerciseExample ?: selectedExercise?.exerciseExample
            )
        )
    )
    val state: StateFlow<SetExerciseState> = _state.asStateFlow()

    fun saveIteration(index: Int, iteration: Iteration) {
        _state.update {
            val iterations = if (index in 0..it.exercise.iterations.lastIndex)
                it.exercise.iterations.set(index, iteration)
            else buildList {
                addAll(it.exercise.iterations)
                add(iteration)
            }.toPersistentList()

            it.copy(
                exercise = it.exercise.copy(iterations = iterations.toPersistentList()),
                focusTarget = -1 to IterationTargetFocus.Weight
            )
        }
    }

    fun updateName(value: String) {
        _state.update {
            it.copy(exercise = it.exercise.copy(name = value))
        }
    }

    fun removeSelectedIteration() {
        _state.update {
            val list = it.exercise.iterations
                .mapIndexedNotNull { index, iteration ->
                    if (index == it.focusTarget.first) return@mapIndexedNotNull null
                    iteration
                }

            it.copy(
                exercise = it.exercise.copy(iterations = list.toPersistentList()),
                focusTarget = -1 to IterationTargetFocus.Weight
            )
        }
    }

    fun selectIterationTargetWeight(index: Int) {
        _state.update {
            it.copy(focusTarget = index to IterationTargetFocus.Weight)
        }
    }

    fun selectIterationTargetRepetition(index: Int) {
        _state.update {
            it.copy(focusTarget = index to IterationTargetFocus.Repetition)
        }
    }

    fun addIteration() {
        _state.update {
            it.copy(focusTarget = it.exercise.iterations.lastIndex + 1 to IterationTargetFocus.Weight)
        }
    }

    fun clearSelectedIteration() {
        _state.update {
            it.copy(focusTarget = -1 to IterationTargetFocus.Weight)
        }
    }
}