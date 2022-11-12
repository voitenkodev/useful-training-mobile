package items

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import components.labels.AccentLabel
import controls.DividerPrimary
import controls.TextFieldBody2
import controls.secondaryBackground
import presentation.trainings.WeekInfo
import kotlin.math.roundToInt

@Composable
fun WeekSummary(
    modifier: Modifier = Modifier,
    info: WeekInfo
) = Column(
    modifier = modifier
        .secondaryBackground()
        .fillMaxWidth()
        .padding(horizontal = Design.dp.padding),
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

        TextFieldBody2(
            text = "${info.trainingWeekDays.size} Trainings",
            color = Design.colors.caption,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(Design.dp.padding),
    ) {

        DividerPrimary()

        Section(label = "start of week", value = info.startWeekDate)

        Section(label = "end of week", value = info.endWeekDate)

        Section(label = "Tonnage", value = "${info.tonnage}kg")

        Section(label = "Intensity", value = "${info.intensity.roundToInt()}%")

        WeekDayStatusLine(
            availableList = listOf()
        )
    }

    Spacer(Modifier.size(Design.dp.padding))
}

@Composable
private fun WeekDayStatusLine(
    listOfWeekDaysEnglish: List<String> = listOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"),
    availableList: List<String>
) {

    val weekShort = remember {
        listOfWeekDaysEnglish.map { weekDayEnglish ->
            when (weekDayEnglish.uppercase()) {
                "MONDAY" -> "Mon"
                "TUESDAY" -> "Tue"
                "WEDNESDAY" -> "Wed"
                "THURSDAY" -> "Thu"
                "FRIDAY" -> "Fri"
                "SATURDAY" -> "SAT"
                "SUNDAY" -> "SUN"
                else -> ""
            }
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(Design.dp.padding)
    ) {
        Row {
            weekShort.forEach {
                TextFieldBody2(
                    modifier = Modifier.weight(1f),
                    text = it,
                    textAlign = TextAlign.Center
                )

            }
        }
        Row {
            weekShort.forEach {
                Spacer(
                    modifier = Modifier
                        .height(14.dp)
                        .background(
                            color = if (availableList.contains(it)) Design.colors.accent_secondary else Design.colors.tertiary,
                            shape = CircleShape
                        )
                        .weight(1f)
                )
            }
        }
    }
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