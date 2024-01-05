package exerciseexample.main.models

import androidx.compose.runtime.Immutable

@Immutable
internal data class ExerciseVolume(
    val createdAt: String,
    val exerciseExampleId: String,
    val id: String,
    val volume: Double
)