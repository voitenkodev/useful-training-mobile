package presentation.trainings

import androidx.compose.runtime.Stable
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import presentation.training.Training
import utils.DateTimeKtx

@Serializable
@Parcelize
@Stable
internal data class TrainingsState(
    val weekDay: String = DateTimeKtx.currentWeekDay(),
    val date: String = DateTimeKtx.currentDate() ?: "",
    val trainings: List<Training> = emptyList(),
    val weekTrainings: Map<WeekInfo, List<Training>> = emptyMap(),
    val error: String? = null,
    val loading: Boolean = false
) : Parcelable

@Serializable
@Parcelize
@Stable
internal data class WeekInfo(
    val startWeekDate: String,
    val endWeekDate: String,
    val tonnage: Double,
    val intensity: Double,
    val trainingWeekDays: List<String>,
) : Parcelable