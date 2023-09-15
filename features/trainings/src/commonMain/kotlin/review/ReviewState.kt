package review

import androidx.compose.runtime.Immutable
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import training.Training

@Parcelize
@Immutable
data class ReviewState(
    val reviewTraining: Training = Training(),
    val compareTraining: Training? = null,
    val otherTrainings: List<Training> = emptyList(),
    val error: String? = null,
    val loading: Boolean = false,
    val removeTrainingId: String? = null,
) : Parcelable