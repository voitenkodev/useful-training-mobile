package presentation.summary

import androidx.compose.runtime.Stable
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import presentation.training.Exercise
import presentation.training.Training
import utils.DateTimeKtx

@Serializable
@Parcelize
@Stable
internal data class SummaryState(
    val query: String = "",
    val autoScrollIndex: Int = -1,

    val exercises: Map<ExerciseInfo, List<Exercise>> = mapOf(),
    val trainings: List<Training> = emptyList(),

    val selectedDay: Int = DateTimeKtx.currentRealMonthDay(),
    val selectedMonth: Int = DateTimeKtx.currentRealMonth(),
    val selectedYear: Int = DateTimeKtx.currentYear(),

    val error: String? = null,
    val loading: Boolean = false,
) : Parcelable {

    val listOfTonnage: List<Float>
        get() = exercises
            .flatMap { it.value }
            .map { it.tonnage.toFloat() }
            .takeIf { it.isNotEmpty() } ?: trainings
            .mapNotNull { it.tonnage?.toFloat() }

    val currentMonthTrainings
        get() = exercises
            .flatMap { flat -> flat.value.map { flat.key to flat.value } }
            .filter { it.first.month == selectedMonth && it.first.year == selectedYear }
            .map { it.first.day }
            .takeIf { exercises.isNotEmpty() }
            ?: trainings
                .filter { it.month == selectedMonth && it.year == selectedYear }
                .map { it.day }
                .takeIf { query.isEmpty() }
            ?: emptyList()
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
        get() = DateTimeKtx.formattedRealMonthDay(date) ?: -1
    val month: Int
        get() = DateTimeKtx.formattedRealMonth(date) ?: -1
    val year: Int
        get() = DateTimeKtx.formattedYear(date) ?: -1
}