package components.items

import Design
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
import recomposeHighlighter

@Composable
fun TrainingHeader(
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
        modifier = Modifier
            .padding(end = 4.dp)
            .recomposeHighlighter(),
        weekDayEnglish = { weekDay },
    )

    TextFieldBody2(
        modifier = Modifier.recomposeHighlighter(),
        provideText = { date },
        color = Design.colors.caption,
        fontWeight = FontWeight.Bold
    )

    Spacer(
        modifier = Modifier
            .weight(1f)
            .recomposeHighlighter()
    )

    review?.let {
        IconPrimary(
            modifier = Modifier
                .height(20.dp)
                .recomposeHighlighter(),
            imageVector = BarChart,
            color = Design.colors.caption,
            onClick = it
        )
    }
    Spacer(
        modifier = Modifier
            .size(12.dp)
            .recomposeHighlighter()
    )

    edit?.let {
        IconPrimary(
            modifier = Modifier
                .height(20.dp)
                .recomposeHighlighter(),
            imageVector = Icons.Default.Edit,
            color = Design.colors.caption,
            onClick = it
        )
    }
}
