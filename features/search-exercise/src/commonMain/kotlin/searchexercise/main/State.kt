package searchexercise.main

import androidx.compose.runtime.Immutable
import exercise.ExerciseExample
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import searchexercise.main.popups.ExerciseExampleFiltersState

@Immutable
internal data class State(
    val exerciseExamples: ImmutableList<ExerciseExample> = persistentListOf(),

    // Filters
    val filtersPopupIsVisible: Boolean = false,
    val query: String = "",
    val filtersState: ExerciseExampleFiltersState = ExerciseExampleFiltersState(),

    val error: String? = null,
    val loading: Boolean = false
)
