package bottommenu.state

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
internal enum class Menu(val icon: ImageVector) {
    Trainings(icon = icons.Dumbbell),
    Statistics(icon = icons.Chart),
    Person(icon = icons.Person)
}