package weighthistory.main

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import weighthistory.main.models.WeightHistory

@Immutable
internal data class State(
    val weightHistory: ImmutableList<WeightHistory> = persistentListOf(),
    val error: String? = null,
    val loading: Boolean = false
)
