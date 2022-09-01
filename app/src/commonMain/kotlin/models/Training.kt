package models

data class Training(
    val id: Long,
    val exercises: List<Exercise>,
    val duration: String,

    val tonnage: Double,
    val countOfLifting: Int,
    val coefficient: Double,
)