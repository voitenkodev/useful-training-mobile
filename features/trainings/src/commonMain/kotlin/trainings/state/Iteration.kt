package trainings.state

import androidx.compose.runtime.Immutable
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize

@Parcelize
@Immutable
internal data class Iteration(
    val weightAndRepeat: String = "",
) : Parcelable