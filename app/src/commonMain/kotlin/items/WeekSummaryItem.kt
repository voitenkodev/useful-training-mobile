package items

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import components.labels.AccentLabel
import controls.DividerPrimary
import controls.TextFieldBody2
import presentation.trainings.WeekInfo
import kotlin.math.roundToInt

@Composable
fun WeekSummary(
    modifier: Modifier = Modifier,
    info: WeekInfo
) = Column(
    modifier = modifier
        .background(color = Design.colors.primary)
        .fillMaxWidth()
) {

    Row(
        modifier = modifier.requiredHeight(44.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        AccentLabel(
            modifier = Modifier.padding(end = 4.dp),
            text = "week summary"
        )

        WeekDayStatusLine(availableList = listOf("MONDAY", "WEDNESDAY"))

//        TextFieldBody2(
//            text = "${info.startWeekDate} - ${info.endWeekDate}",
//            color = Design.colors.caption,
//            fontWeight = FontWeight.Bold
//        )
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(Design.dp.padding),
    ) {

//        DividerPrimary()

//        Section(label = "Tonnage", value = "${info.tonnage}kg")

//        Section(label = "Intensity", value = "${info.intensity.roundToInt()}%")

    }

    Spacer(Modifier.size(Design.dp.padding))
}

@Composable
private fun WeekDayStatusLine(
    listOfWeekDaysEnglish: List<String> = listOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"),
    availableList: List<String>
) {

    Column(
        verticalArrangement = Arrangement.spacedBy(Design.dp.padding)
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

@Composable
private fun Section(label: String, value: String) = Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween
) {
    TextFieldBody2(
        text = label,
        color = Design.colors.caption,
    )
    TextFieldBody2(
        text = value,
        fontWeight = FontWeight.Bold,
    )
}