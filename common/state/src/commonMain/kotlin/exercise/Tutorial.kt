package exercise

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
public data class Tutorial(
    val id: String,
    val title: String,
    val value: String,
    val language: String,
    val author: String?,
    val resourceType: ResourceTypeEnum,
    val icon: Pair<ImageVector, Color>
)
