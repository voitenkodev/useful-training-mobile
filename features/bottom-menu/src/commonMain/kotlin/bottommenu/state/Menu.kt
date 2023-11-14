package bottommenu.state

import Icons
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
internal enum class Menu(val icon: ImageVector) {
    Trainings(icon = Icons.dumbbell),
    Statistics(icon = Icons.chart),
    Person(icon = Icons.person)
}