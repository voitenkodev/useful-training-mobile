package trainingbuilder.training_builder.pages.set_iteration

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import trainingbuilder.training_builder.models.Iteration
import trainingbuilder.training_builder.models.IterationTargetFocus

internal class SetIterationStateHolder(
    iterationIndex: Int,
    selectedIteration: Iteration?,
    targetFocus: IterationTargetFocus
) {

    private val _state = MutableStateFlow(
        SetIterationState(
            iteration = selectedIteration ?: Iteration(),
            targetFocus = targetFocus,
            iterationIndex = iterationIndex
        )
    )
    val state: StateFlow<SetIterationState> = _state.asStateFlow()

    fun updateRepeat(value: String) {
        _state.update {
            it.copy(iteration = it.iteration.copy(repetitions = value))
        }

    }

    fun updateWeight(value: String) {
        _state.update {
            it.copy(iteration = it.iteration.copy(weight = value))
        }
    }
}