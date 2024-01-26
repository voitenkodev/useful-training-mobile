package authentication.register.models

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import resources.Icons

@Immutable
internal enum class ExperienceEnum(
    val title: String,
    val description: String,
    val icon: ImageVector
) {
    BEGINNER(
        title = "Beginner",
        description = "You've been working out for less than 1 year and are currently getting familiar with the exercises.",
        icon = Icons.beginner
    ),
    INTERMEDIATE(
        title = "Intermediate",
        description = "You've been working out for over 1 year, are familiar with most exercises, and have built some muscle.",
        icon = Icons.intermediate
    ),
    ADVANCED(
        title = "Advanced",
        description = "You've been working out for over 2 years, have good exercise form, and have visibly built muscle.",
        icon = Icons.advanced
    ),
    PRO(
        title = "Intermediate",
        description = "You've been working out for over 5 years, have excellent exercise form, and are noticeably muscular.",
        icon = Icons.pro
    )
}