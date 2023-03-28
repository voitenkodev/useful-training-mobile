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
    val exercises: List<ExerciseDate> = listOf(),
    val error: String? = null,
    val loading: Boolean = false,
) : Parcelable

@Serializable
@Parcelize
@Stable
data class ExerciseDate(
    val trainingId: String? = null,
    val exercise: Exercise? = null,
    val date: String,
) : Parcelable