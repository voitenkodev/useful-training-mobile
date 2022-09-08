package models

import dev.gitlive.firebase.firestore.FieldValue
import kotlinx.serialization.Serializable

@Serializable
data class Training(
    val id: String,
    val exercises: List<Exercise>,
    val duration: String,
//    val date: FieldValue.,

    val tonnage: Double,
    val countOfLifting: Int,
    val intensity: Double,
) {

    @Serializable
    data class Exercise(
        val id: String,
        val name: String,
        val iterations: List<Iteration>,
    ) {
        @Serializable
        data class Iteration(
            val weight: Double,
            val repeat: Int
        )
    }
}