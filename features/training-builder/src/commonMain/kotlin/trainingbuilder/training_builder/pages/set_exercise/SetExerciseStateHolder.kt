package trainingbuilder.training_builder.pages.set_exercise

import exercise.ExerciseExample
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import trainingbuilder.training_builder.models.BuildExercise
import trainingbuilder.training_builder.models.BuildIteration
import trainingbuilder.training_builder.models.IterationTargetFocus

internal class SetExerciseStateHolder(
    selectedBuildExercise: BuildExercise? = null,
    exerciseExample: ExerciseExample?
) {

    private val _state = MutableStateFlow(
        SetExerciseState(
            buildExercise = selectedBuildExercise ?: BuildExercise(
                name = exerciseExample?.name ?: "",
                exerciseExample = exerciseExample ?: selectedBuildExercise?.exerciseExample
            )
        )
    )
    val state: StateFlow<SetExerciseState> = _state.asStateFlow()

    fun saveIteration(index: Int, buildIteration: BuildIteration) {
        _state.update {
            val iterations = if (index in 0..it.buildExercise.buildIterations.lastIndex)
                it.buildExercise.buildIterations.set(index, buildIteration)
            else buildList {
                addAll(it.buildExercise.buildIterations)
                add(buildIteration)
            }.toPersistentList()

            it.copy(
                buildExercise = it.buildExercise.copy(buildIterations = iterations.toPersistentList()),
                focusTarget = -1 to IterationTargetFocus.Weight
            )
        }
    }

    fun updateName(value: String) {
        _state.update {
            it.copy(buildExercise = it.buildExercise.copy(name = value))
        }
    }

    fun removeSelectedIteration() {
        _state.update {
            val list = it.buildExercise.buildIterations
                .mapIndexedNotNull { index, iteration ->
                    if (index == it.focusTarget.first) return@mapIndexedNotNull null
                    iteration
                }

            it.copy(
                buildExercise = it.buildExercise.copy(buildIterations = list.toPersistentList()),
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
            it.copy(focusTarget = it.buildExercise.buildIterations.lastIndex + 1 to IterationTargetFocus.Weight)
        }
    }

    fun clearSelectedIteration() {
        _state.update {
            it.copy(focusTarget = -1 to IterationTargetFocus.Weight)
        }
    }
}