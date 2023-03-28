package presentation.review

import androidx.compose.runtime.Stable
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import presentation.training.Training

@Serializable
@Parcelize
@Stable
internal data class ReviewState(
    val reviewTraining: Training = Training(),
    val compareTraining: Training? = null,
    val otherTrainings: List<Training> = emptyList(),
    val error: String? = null,
    val loading: Boolean = false,
    val removeTrainingId: String? = null,
) : Parcelable