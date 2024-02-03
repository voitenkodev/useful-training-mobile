package exerciseexamplebuilder.main.models

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
internal data class Equipment(
    val id: String,
    val name: String,
    val image: ImageVector,
    val status: StatusEnum
)

