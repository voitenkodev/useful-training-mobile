package models

import kotlinx.serialization.Serializable

@Serializable
data class Exercise(
    val id: String,
    val name: String,
    val iterations: List<Pair<String, String>>,
) {

    companion object {
        fun empty(id: String) = Exercise(
            id = id,
            name = "",
            listOf("" to "")
        )
    }
}