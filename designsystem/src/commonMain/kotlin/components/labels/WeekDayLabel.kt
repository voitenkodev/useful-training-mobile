package components.labels

import DesignComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import controls.TextFieldBody1

@Composable
fun WeekDayLabel(
    modifier: Modifier = Modifier,
    weekDayEnglish: String?,
) {
    val backgroundColor = when (weekDayEnglish?.uppercase()) {
        "MONDAY" -> DesignComponent.colors.unique.color1
        "TUESDAY" -> DesignComponent.colors.unique.color2
        "WEDNESDAY" -> DesignComponent.colors.unique.color3
        "THURSDAY" -> DesignComponent.colors.unique.color4
        "FRIDAY" -> DesignComponent.colors.unique.color5
        "SATURDAY" -> DesignComponent.colors.unique.color6
        "SUNDAY" -> DesignComponent.colors.unique.color7
        else -> DesignComponent.colors.accent_primary
    }

    TextFieldBody1(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = DesignComponent.shape.circleShape
            ).padding(horizontal = 8.dp, vertical = 2.dp),
        text = weekDayEnglish,
        fontWeight = FontWeight.Bold
    )
}