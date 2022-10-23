package components.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import atomic.icons.BarChart
import components.labels.WeekDayLabel
import controls.IconPrimary
import controls.TextFieldBody2

@Composable
fun TrainingHeader(
    modifier: Modifier = Modifier,
    weekDay: String,
    date: String,
    review: () -> Unit,
    edit: () -> Unit
) = Row(
    modifier = modifier.requiredHeight(44.dp),
    horizontalArrangement = Arrangement.spacedBy(2.dp),
    verticalAlignment = Alignment.CenterVertically,
) {

    WeekDayLabel(
        modifier = Modifier.padding(end = 4.dp),
        weekDayEnglish = weekDay,
    )

    TextFieldBody2(
        text = date,
        color = DesignComponent.colors.caption,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.weight(1f))

    IconPrimary(
        modifier = Modifier.height(20.dp),
        imageVector = BarChart,
        color = DesignComponent.colors.caption,
        onClick = { review.invoke() }
    )

    Spacer(modifier = Modifier.size(20.dp))

    IconPrimary(
        modifier = Modifier.height(20.dp),
        imageVector = Icons.Default.Edit,
        color = DesignComponent.colors.caption,
        onClick = { edit.invoke() }
    )
}
