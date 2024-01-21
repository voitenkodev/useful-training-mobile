package userequipments.main.models

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
internal data class Equipment(
    val id: String,
    val name: String,
    val loading: Boolean,
    val image: ImageVector,
    val status: StatusEnum
)

