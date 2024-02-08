package exerciseexample.main.models

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
internal data class Tutorial(
    val id: String,
    val title: String,
    val value: String,
    val language: String,
    val resource: String,
    val resourceType: ResourceTypeEnum,
    val imageVector: ImageVector
)
