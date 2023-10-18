package trainings.state

import androidx.compose.runtime.Immutable
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize

@Parcelize
@Immutable
internal data class Exercise(
    val id: String,
    val name: String = "",
    val iterations: List<Iteration> = emptyList(),
    val tonnage: Double = 0.0,
) : Parcelable