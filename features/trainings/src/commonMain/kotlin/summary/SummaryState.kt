//package presentation.summary
//
//import androidx.compose.runtime.Immutable
//import dev.icerock.moko.parcelize.Parcelable
//import dev.icerock.moko.parcelize.Parcelize
//import presentation.training.Exercise
//import presentation.training.Training
//import utils.DateTimeKtx
//
//@Parcelize
//@Immutable
//internal data class SummaryState(
//    val query: String = "",
//    val autoScrollIndex: Int = -1,
//
//    val exercises: Map<ExerciseInfo, List<Exercise>> = mapOf(),
//    val trainings: List<Training> = emptyList(),
//    val exerciseNameOptions: List<String> = emptyList(),
//
//    val selectedDay: Int = DateTimeKtx.currentRealMonthDay(),
//    val selectedMonth: Int = DateTimeKtx.currentRealMonth(),
//    val selectedYear: Int = DateTimeKtx.currentYear(),
//
//    val error: String? = null,
//    val loading: Boolean = false,
//
//    val listOfTonnage: List<Float> = emptyList(),
//    val listOfIntensity: List<Float> = emptyList(),
//    val currentMonthTrainings: List<Int> = emptyList()
//) : Parcelable
//
//@Parcelize
//@Immutable
//data class ExerciseInfo(
//    val trainingId: String? = null,
//    val date: String,
//) : Parcelable {
//    val weekDay: String
//        get() = DateTimeKtx.formattedWeekDay(date) ?: ""
//    val dateTime: String
//        get() = DateTimeKtx.formattedDateTime(date) ?: ""
//    val day: Int
//        get() = DateTimeKtx.formattedRealMonthDay(date) ?: -1
//    val month: Int
//        get() = DateTimeKtx.formattedRealMonth(date) ?: -1
//    val year: Int
//        get() = DateTimeKtx.formattedYear(date) ?: -1
//}