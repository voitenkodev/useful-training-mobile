package bottommenu.state

import Time
import androidx.compose.ui.graphics.vector.ImageVector
import atomic.icons.Weight

internal enum class Menu(
    val text: String,
    val icon: ImageVector
) {
    Statistics(
        text = "Statistics",
        icon = Time
    ),
    Trainings(
        text = "Trainings",
        icon = Weight
    )
}