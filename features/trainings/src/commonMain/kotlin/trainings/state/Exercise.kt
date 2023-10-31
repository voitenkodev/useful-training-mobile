package trainings.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class Exercise(
    val id: String,
    val name: String = "",
    val iterations: ImmutableList<Iteration> = persistentListOf(),
    val tonnage: Double = 0.0
)