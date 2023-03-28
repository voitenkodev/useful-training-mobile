package presentation.summary

import androidx.compose.runtime.Stable
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import presentation.training.Exercise

@Serializable
@Parcelize
@Stable
internal data class SummaryState(
    val query: String = "",
    val exercises: List<Exercise> = listOf(Exercise()),
    val error: String? = null,
    val loading: Boolean = false,
) : Parcelable