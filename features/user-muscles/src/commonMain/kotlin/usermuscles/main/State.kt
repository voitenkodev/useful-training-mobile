package usermuscles.main

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import usermuscles.main.models.MuscleGroup

@Immutable
internal data class State(
    val muscleGroups: ImmutableList<MuscleGroup> = persistentListOf(),
    val error: String? = null,
    val loading: Boolean = false
)