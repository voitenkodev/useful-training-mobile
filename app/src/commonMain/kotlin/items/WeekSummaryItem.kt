package items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import components.labels.AccentLabel
import controls.DividerPrimary
import controls.TextFieldBody2
import controls.secondaryBackground
import presentation.trainings.WeekInfo

@Composable
fun WeekSummary(
    modifier: Modifier = Modifier,
    info: WeekInfo
) = Column(
    modifier = modifier
        .secondaryBackground()
        .fillMaxWidth()
        .padding(DesignComponent.size.space),
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space),
) {

    AccentLabel(text = "Week Summary")

    DividerPrimary(modifier = Modifier.padding(bottom = 4.dp, top = 0.dp))

    Section(label = "date", value = "${info.startWeekDate} to ${info.endWeekDate}")

    Section(label = "Tonnage", value = "${info.tonnage}kg")

    Section(label = "Intensity", value = info.intensity.toString())
}

@Composable
private fun Section(label: String, value: String) = Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween
) {
    TextFieldBody2(
        text = label,
        color = DesignComponent.colors.caption,
    )
    TextFieldBody2(
        text = value,
        fontWeight = FontWeight.Bold,
    )
}