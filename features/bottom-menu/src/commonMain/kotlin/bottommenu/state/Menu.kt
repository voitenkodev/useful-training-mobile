package bottommenu.state

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import icons.Dumbbell
import icons.Time
import icons.Weight

@Immutable
internal enum class Menu(
    val icon: ImageVector
) {
    Trainings(
        icon = Dumbbell
    ),
    Statistics(
        icon = Time
    ),
    Wiki(
        icon = icons.Wiki
    )
}