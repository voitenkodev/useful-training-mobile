package bottommenu.main.state

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import resources.Icons

@Immutable
internal enum class Menu(val icon: ImageVector) {
    Trainings(icon = Icons.trainings),
    Statistics(icon = Icons.statistics),
    Person(icon = Icons.profile)
}