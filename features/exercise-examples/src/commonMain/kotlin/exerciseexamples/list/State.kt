package exerciseexamples.list

import androidx.compose.runtime.Immutable
import exerciseexamples.list.models.ExerciseExample
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class State(
    val exerciseExamples: ImmutableList<ExerciseExample> = persistentListOf(),
    val error: String? = null,
    val loading: Boolean = false
)
