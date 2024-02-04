package searchexercise.main.models

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.collections.immutable.ImmutableList

@Immutable
internal data class FilterMuscleGroup(
    val id: String,
    val name: String = "",
    val muscles: ImmutableList<FilterMuscle>,
    val type: MuscleGroupEnum,
    val bodyImageVector: ImageVector
)