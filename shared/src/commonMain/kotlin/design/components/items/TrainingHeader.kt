package design.components.items

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
import design.Design
import design.atomic.icons.BarChart
import design.components.labels.WeekDayLabel
import design.controls.IconPrimary
import design.controls.TextFieldBody2

@Composable
internal fun TrainingHeader(
    modifier: Modifier = Modifier,
    weekDay: String,
    date: String,
    review: (() -> Unit)? = null,
    edit: (() -> Unit)? = null
) = Row(
    modifier = modifier.requiredHeight(44.dp),
    horizontalArrangement = Arrangement.spacedBy(4.dp),
    verticalAlignment = Alignment.CenterVertically,
) {

    WeekDayLabel(
        modifier = Modifier.padding(end = 4.dp),
        weekDayEnglish = weekDay,
    )

    TextFieldBody2(
        provideText = { date },
        color = Design.colors.caption,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.weight(1f))

    review?.let {
        IconPrimary(
            modifier = Modifier.height(20.dp),
            imageVector = BarChart,
            color = Design.colors.caption,
            onClick = it
        )
    }
    Spacer(modifier = Modifier.size(12.dp))

    edit?.let {
        IconPrimary(
            modifier = Modifier.height(20.dp),
            imageVector = Icons.Default.Edit,
            color = Design.colors.caption,
            onClick = it
        )
    }
}
