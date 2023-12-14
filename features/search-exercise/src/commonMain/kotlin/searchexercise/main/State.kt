package searchexercise.main

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import searchexercise.main.models.ExerciseExample

@Immutable
internal data class State(
    val exerciseExamples: ImmutableList<ExerciseExample> = persistentListOf(),
    val query: String = "",
    val error: String? = null,
    val loading: Boolean = false
)
