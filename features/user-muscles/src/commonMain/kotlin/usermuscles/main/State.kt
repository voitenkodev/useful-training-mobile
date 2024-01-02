package usermuscles.main

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import usermuscles.main.models.MuscleType

@Immutable
internal data class State(
    val muscleTypes: ImmutableList<MuscleType> = persistentListOf(),
    val error: String? = null,
    val loading: Boolean = false
)