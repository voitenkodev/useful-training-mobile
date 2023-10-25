package configurations.state

import androidx.compose.runtime.Immutable
import createId

@Immutable
internal data class Muscle(
    val id: String = createId(),
    val name: String = "",
)