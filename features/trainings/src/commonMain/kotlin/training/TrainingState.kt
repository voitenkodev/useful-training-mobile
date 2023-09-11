package training

import androidx.compose.runtime.Immutable
import com.benasher44.uuid.uuid4
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import utils.DateTimeKtx

@Immutable
data class TrainingState(
    val training: Training = Training(),
    val exerciseNameOptions: List<String> = emptyList(),
    val error: String? = null,
    val loading: Boolean = false,
    val exitWarningVisibility: Boolean = false,
    val removeExerciseId: String? = null
)

@Parcelize
@Immutable
data class Training(
    val id: String? = null,
    val exercises: List<Exercise> = listOf(Exercise()),
    val startDateTime: String = DateTimeKtx.currentDateTime(),
    val duration: String? = null,
    val tonnage: Double? = null,
    val countOfLifting: Int? = null,
    val intensity: Double? = null
) : Parcelable {

    // UI date internal.presentation

    val weekDay: String
        get() = DateTimeKtx.formattedWeekDay(startDateTime) ?: ""
    val startTime: String
        get() = DateTimeKtx.formattedTime(startDateTime) ?: ""
    val shortStartDate: String
        get() = DateTimeKtx.formattedShortDate(startDateTime) ?: ""
    val shortStartDateTime: String
        get() = DateTimeKtx.formattedDateTime(startDateTime) ?: ""
    val startLongDate: String
        get() = DateTimeKtx.formattedLongDate(startDateTime) ?: ""
    val durationTime: String
        get() = duration?.let { DateTimeKtx.formattedDuration(it) } ?: ""
    val endOfWeek: String
        get() = DateTimeKtx.formattedEndOfWeekLongDate(startDateTime, true) ?: ""
    val startOfWeek: String
        get() = DateTimeKtx.formattedStartOfWeekLongDate(startDateTime, false) ?: ""
    val day: Int
        get() = DateTimeKtx.formattedRealMonthDay(startDateTime) ?: -1
    val month: Int
        get() = DateTimeKtx.formattedRealMonth(startDateTime) ?: -1
    val year: Int
        get() = DateTimeKtx.formattedYear(startDateTime) ?: -1
}

@Parcelize
@Immutable
data class Exercise(
    val id: String = uuid4().toString(),
    val name: String = "",
    val iterations: List<Iteration> = listOf(Iteration()),
    val tonnage: Double = 0.0,
    val countOfLifting: Int = 0,
    val intensity: Double = 0.0
) : Parcelable

@Parcelize
@Immutable
data class Iteration(
    val weight: String = "",
    val repeat: String = ""
) : Parcelable