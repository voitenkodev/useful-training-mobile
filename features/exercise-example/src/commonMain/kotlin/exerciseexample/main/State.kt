package exerciseexample.main

import androidx.compose.runtime.Immutable
import exerciseexample.main.models.ExerciseExample
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class State(
    val exerciseExamples: ImmutableList<ExerciseExample> = persistentListOf(),
    val query: String = "",
    val error: String? = null,
    val loading: Boolean = false
)
