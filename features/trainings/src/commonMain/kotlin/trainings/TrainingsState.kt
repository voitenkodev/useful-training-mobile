package trainings

import androidx.compose.runtime.Immutable
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import training.Training
import utils.DateTimeKtx

@Parcelize
@Immutable
data class TrainingsState(
    val weekDay: String = DateTimeKtx.currentWeekDay(),
    val date: String = DateTimeKtx.currentDate(),
    val trainings: List<Training> = emptyList(),
    val weekTrainings: Map<WeekInfo, List<Training>> = emptyMap(),
    val error: String? = null,
    val loading: Boolean = false
) : Parcelable

@Parcelize
@Immutable
data class WeekInfo(
    val startWeekDate: String,
    val endWeekDate: String,
    val tonnage: Double,
    val intensity: Double,
    val trainingWeekDays: List<String>,
) : Parcelable