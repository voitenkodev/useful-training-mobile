package trainings

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
public data class Exercise(
    val id: String,
    val name: String = "",
    val iterations: ImmutableList<Iteration> = persistentListOf(),
    val volume: Double = 0.0
)