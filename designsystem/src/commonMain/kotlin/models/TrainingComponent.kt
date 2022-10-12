package models

data class TrainingComponent(
    val exercises: List<ExerciseComponent>,
    val startDateTime: String,
    val duration: String? = null,
    val tonnage: String? = null,
    val countOfLifting: Int? = null,
    val intensity: String? = null,
    val weekDay: String,
    val startTime: String,
    val shortStartDate: String,
    val startLongDate: String,
    val durationTime: String?,
    val endOfWeek: String,
)

data class ExerciseComponent(
    val name: String,
    val iterations: List<IterationComponent>,
    val tonnage: String? = null,
    val countOfLifting: String? = null,
    val intensity: String? = null
)

data class IterationComponent(
    val weight: String,
    val repeat: String
)