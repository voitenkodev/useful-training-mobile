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
) : Parcelable {

    val weekDay: String
        get() = DateTimeKtx().formattedWeekDay(startDateTime) ?: ""
    val startTime: String
        get() = DateTimeKtx().formattedTime(startDateTime) ?: ""
    val startDate: String
        get() = DateTimeKtx().formattedDate(startDateTime) ?: ""
    val durationTime: String
        get() = duration?.let { DateTimeKtx().getFormattedDuration(it) } ?: ""

    val tonnage: Double
        get() = exercises.sumOf { it.tonnage }
    val countOfLifting: Int
        get() = exercises.sumOf { it.countOfLifting }
    val intensity: Double
        get() = tonnage / countOfLifting

    @Serializable
    @Parcelize
    data class Exercise(
        val id: String = uuid4().toString(),
        val name: String = "",
        val iterations: List<Iteration> = listOf(Iteration()),
    ) : Parcelable {

        val tonnage
            get() = iterations.sumOf { it.tonnage }
        val countOfLifting: Int
            get() = iterations.sumOf { it.countOfLifting }
        val intensity
            get() = tonnage / countOfLifting

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