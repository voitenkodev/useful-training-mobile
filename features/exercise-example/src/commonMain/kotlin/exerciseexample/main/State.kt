package exerciseexample.main

import androidx.compose.runtime.Immutable
import exerciseexample.main.models.ExerciseExample

@Immutable
internal data class State(
    val exerciseExample: ExerciseExample? = null,
    val error: String? = null,
    val loading: Boolean = false
)
