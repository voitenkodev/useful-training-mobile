package designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.controls.TextFieldBody1
import kotlinx.datetime.DayOfWeek

@Composable
fun WeekDayLabel(
    modifier: Modifier = Modifier,
    weekDay: String?,
) {
    val backgroundColor = when (weekDay) {
        DayOfWeek.MONDAY.name -> DesignComponent.colors.unique.color1
        DayOfWeek.TUESDAY.name -> DesignComponent.colors.unique.color2
        DayOfWeek.WEDNESDAY.name -> DesignComponent.colors.unique.color3
        DayOfWeek.THURSDAY.name -> DesignComponent.colors.unique.color4
        DayOfWeek.FRIDAY.name -> DesignComponent.colors.unique.color5
        DayOfWeek.SATURDAY.name -> DesignComponent.colors.unique.color6
        DayOfWeek.SUNDAY.name -> DesignComponent.colors.unique.color7
        else -> DesignComponent.colors.accent_primary
    }

    TextFieldBody1(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = DesignComponent.shape.circleShape
            ).padding(horizontal = 8.dp, vertical = 2.dp),
        text = weekDay,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun AccentLabel(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color = DesignComponent.colors.accent_primary
) = TextFieldBody1(
    modifier = modifier
        .background(
            color = backgroundColor,
            shape = DesignComponent.shape.circleShape
        ).padding(horizontal = 8.dp, vertical = 2.dp),
    text = text,
    fontWeight = FontWeight.Bold
)

@Composable
fun InputLabel(modifier: Modifier = Modifier, text: String) = TextFieldBody1(
    modifier = modifier.width(64.dp),
    text = text,
    color = DesignComponent.colors.caption,
    maxLines = 1,
    overflow = TextOverflow.Ellipsis
)
