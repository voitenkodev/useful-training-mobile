package user

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import resources.Icons

@Immutable
public enum class ExperienceEnum(
    public val title: String,
    public val description: String,
    public val icon: ImageVector
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
        title = "Pro",
        description = "You've been working out for over 5 years, have excellent exercise form, and are noticeably muscular.",
        icon = Icons.pro
    )
}