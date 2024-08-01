package authentication.success

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
internal data class State(
    val name: String = "",
    val height: String = "",
    val weight: String = "",
    val email: String = "",
    val experienceIcon: ImageVector? = null,
    val error: String? = null
)