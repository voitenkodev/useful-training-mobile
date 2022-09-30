package state

import com.benasher44.uuid.uuid4
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable
import utils.DateTimeKtx

@Serializable
@Parcelize
data class TrainingState(
    val id: String? = null,
    val exercises: List<Exercise> = listOf(Exercise()),
    val startDateTime: String = DateTimeKtx().currentTime(),
    val duration: String? = null,
    val tonnage: Double? = null,
    val countOfLifting: Int? = null,
    val intensity: Double? = null
) : Parcelable {

    // UI date presentation
    val weekDay: String
        get() = DateTimeKtx().formattedWeekDay(startDateTime) ?: ""
    val startTime: String
        get() = DateTimeKtx().formattedTime(startDateTime) ?: ""
    val shortStartDate: String
        get() = DateTimeKtx().formattedShortDate(startDateTime) ?: ""
    val longStartDate: String
        get() = DateTimeKtx().formattedLongDate(startDateTime) ?: ""
    val durationTime: String
        get() = duration?.let { DateTimeKtx().getFormattedDuration(it) } ?: ""

    @Serializable
    @Parcelize
    data class Exercise(
        val id: String = uuid4().toString(),
        val name: String = "",
        val iterations: List<Iteration> = listOf(Iteration()),
        val tonnage: Double = 0.0,
        val countOfLifting: Int = 0,
        val intensity: Double = 0.0
    ) : Parcelable {

        @Serializable
        @Parcelize
        data class Iteration(
            val weight: String = "",
            val repeat: String = ""
        ) : Parcelable {

            val tonnage
                get() = (repeat.toIntOrNull() ?: 0) * (weight.toDoubleOrNull() ?: 0.0)
            val countOfLifting: Int
                get() = repeat.toIntOrNull() ?: 0
        }
    }
}