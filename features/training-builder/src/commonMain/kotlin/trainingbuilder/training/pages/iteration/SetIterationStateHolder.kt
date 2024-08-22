package trainingbuilder.training.pages.iteration

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import trainingbuilder.training.models.BuildIteration
import trainingbuilder.training.models.IterationTargetFocus

internal class SetIterationStateHolder(
    iterationIndex: Int,
    selectedBuildIteration: BuildIteration?,
    targetFocus: IterationTargetFocus
) {

    private val _state = MutableStateFlow(
        SetIterationState(
            buildIteration = selectedBuildIteration ?: BuildIteration(),
            targetFocus = targetFocus,
            iterationIndex = iterationIndex
        )
    )
    val state: StateFlow<SetIterationState> = _state.asStateFlow()

    fun updateRepeat(value: String) {
        _state.update {
            it.copy(buildIteration = it.buildIteration.copy(repetitions = value))
        }

    }

    fun updateWeight(value: String) {
        _state.update {
            it.copy(buildIteration = it.buildIteration.copy(weight = value))
        }
    }
}