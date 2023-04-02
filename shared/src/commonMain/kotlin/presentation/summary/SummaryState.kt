package presentation.summary

import androidx.compose.runtime.Stable
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import presentation.training.Exercise
import utils.DateTimeKtx

@Serializable
@Parcelize
@Stable
internal data class SummaryState(
    val query: String = "",
    val exercises: Map<ExerciseInfo, List<Exercise>> = mapOf(),
    val error: String? = null,
    val loading: Boolean = false,
) : Parcelable {
    val listOfTonnage: List<Float>
        get() = exercises.flatMap { it.value }.map { it.tonnage.toFloat() }

    val listOfSelectedDays: List<Int>
        get() = exercises.map { it.key.day }
}

@Serializable
@Parcelize
@Stable
data class ExerciseInfo(
    val trainingId: String? = null,
    val date: String,
) : Parcelable {
    val weekDay: String
        get() = DateTimeKtx.formattedWeekDay(date) ?: ""

    val dateTime: String
        get() = DateTimeKtx.formattedDateTime(date) ?: ""
    val day: Int
        get() = DateTimeKtx.formattedMonthDay(date) ?: -1
}