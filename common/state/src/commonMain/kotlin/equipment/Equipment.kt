package equipment

import IncludedStatusEnum
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
public data class Equipment(
    val id: String,
    val name: String,
    val loading: Boolean,
    val image: ImageVector,
    val status: IncludedStatusEnum?
)
