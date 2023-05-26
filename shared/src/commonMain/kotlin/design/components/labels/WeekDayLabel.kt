package design.components.labels

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import design.Design
import design.controls.TextFieldBody1
import utils.recomposeHighlighter

@Composable
internal fun WeekDayLabel(
    modifier: Modifier = Modifier,
    weekDayEnglish: () -> String?,
) {
    val c0 = Design.colors.accent_primary
    val c1 = Design.colors.unique.color1
    val c2 = Design.colors.unique.color2
    val c3 = Design.colors.unique.color3
    val c4 = Design.colors.unique.color4
    val c5 = Design.colors.unique.color5
    val c6 = Design.colors.unique.color6
    val c7 = Design.colors.unique.color7

    val txt = remember(weekDayEnglish) { weekDayEnglish()?.uppercase() }

    val backgroundColor = remember(weekDayEnglish) {
        when (weekDayEnglish()?.uppercase()) {
            "MONDAY" -> c1
            "TUESDAY" -> c2
            "WEDNESDAY" -> c3
            "THURSDAY" -> c4
            "FRIDAY" -> c5
            "SATURDAY" -> c6
            "SUNDAY" -> c7
            else -> c0
        }
    }

    TextFieldBody1(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = Design.shape.circleShape
            )
            .padding(horizontal = 8.dp, vertical = 2.dp)
            .recomposeHighlighter(),
        provideText = { txt },
        fontWeight = FontWeight.Bold
    )
}