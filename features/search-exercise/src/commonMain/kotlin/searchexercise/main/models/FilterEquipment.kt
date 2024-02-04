package searchexercise.main.models

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
internal data class FilterEquipment(
    val id: String,
    val name: String,
    val image: ImageVector,
    val status: StatusEnum
)