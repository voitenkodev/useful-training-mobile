package design.components.items

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import design.Design
import design.controls.TextFieldBody2
import presentation.trainings.WeekInfo

@Composable
internal fun WeekSummary(
    modifier: Modifier = Modifier,
    info: WeekInfo,
    onClick: () -> Unit
) = Column(
    modifier = modifier
        .background(color = Design.colors.primary, shape = Design.shape.default)
        .border(2.dp, Design.colors.tertiary, shape = Design.shape.default)
        .fillMaxWidth()
        .padding(Design.dp.padding)
        .clickable(onClick = onClick::invoke)
) {

    Row(
        modifier = modifier.requiredHeight(44.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Column(
            modifier = Modifier.height(44.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {

            TextFieldBody2(
                text = info.startWeekDate + " →",
                fontWeight = FontWeight.Bold,
            )

            TextFieldBody2(
                modifier = modifier.padding(start = Design.dp.padding),
                text = "← " + info.endWeekDate,
                fontWeight = FontWeight.Bold,
            )
        }

        WeekDayStatusLine(
            modifier = Modifier.width(180.dp).height(44.dp),
            listOfWeekDaysEnglish = listOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"),
            availableList = info.trainingWeekDays
        )
    }
}

@Composable
private fun WeekDayStatusLine(
    modifier: Modifier = Modifier,
    listOfWeekDaysEnglish: List<String>,
    availableList: List<String>
) = Column(
    modifier = modifier,
    verticalArrangement = Arrangement.SpaceAround
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        listOfWeekDaysEnglish.forEach {
            val weekShort by remember(it) { mutableStateOf(toShortWeek(it)) }
            TextFieldBody2(text = weekShort)
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        listOfWeekDaysEnglish.forEach {
            Spacer(
                modifier = Modifier
                    .size(14.dp)
                    .background(
                        color = if (availableList.contains(it)) Design.colors.accent_secondary else Design.colors.caption,
                        shape = CircleShape
                    )
            )
        }
    }
}

private fun toShortWeek(weekDayEnglish: String) = when (weekDayEnglish.uppercase()) {
    "MONDAY" -> "Mon"
    "TUESDAY" -> "Tue"
    "WEDNESDAY" -> "Wed"
    "THURSDAY" -> "Thu"
    "FRIDAY" -> "Fri"
    "SATURDAY" -> "Sat"
    "SUNDAY" -> "Sun"
    else -> ""
}