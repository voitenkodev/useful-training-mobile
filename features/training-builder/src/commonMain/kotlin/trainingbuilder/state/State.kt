package trainingbuilder.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class State(
    val training: Training = Training(),
    val exerciseNameOptions: List<String> = emptyList(),
    val error: String? = null,
    val loading: Boolean = false,
    val exitWarningVisibility: Boolean = false,
    val removeExerciseIndex: Int? = null
)