package trainingbuilder.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class State(
    val training: Training = Training(),

    val selectedStep: TrainingBuilderSteps = TrainingBuilderSteps.Configurations,
    val steps: List<TrainingBuilderSteps> = TrainingBuilderSteps.entries,

    val editExercisePopupIsShowed: Boolean = false,

    val error: String? = null,
    val loading: Boolean = false
)