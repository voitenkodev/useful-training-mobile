package bottommenu.state

import Time
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import atomic.icons.Weight

@Immutable
internal enum class Menu(
    val text: String,
    val icon: ImageVector
) {
    Trainings(
        text = "Trainings",
        icon = Weight
    ),
    Statistics(
        text = "Statistics",
        icon = Time
    )
}