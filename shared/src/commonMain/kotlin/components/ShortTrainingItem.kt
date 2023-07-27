package components

import Design
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import components.labels.WeekDayLabel
import controls.DividerPrimary
import controls.TextFieldBody2
import controls.secondaryBackground
import presentation.training.Training
import utils.recomposeHighlighter

@Composable
internal fun ShortTrainingItem(
    modifier: Modifier = Modifier,
    training: Training,
    highlight: Boolean = false,
    onClick: () -> Unit
) = Column(
    modifier = modifier
        .width(Design.dp.fixedWidth)
        .height(150.dp)
        .secondaryBackground()
        .border(
            width = 2.dp,
            color = if (highlight) Design.colors.accent_secondary else Color.Transparent,
            shape = Design.shape.default
        )
        .padding(horizontal = Design.dp.padding)
        .clickable(onClick = onClick)
        .recomposeHighlighter(),
) {
    Row(
        modifier = Modifier.requiredHeight(44.dp).recomposeHighlighter(),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        WeekDayLabel(
            modifier = Modifier.padding(end = 4.dp).recomposeHighlighter(),
            weekDayEnglish = { training.weekDay },
        )

        TextFieldBody2(
            modifier = Modifier.recomposeHighlighter(),
            provideText = { training.startLongDate },
            color = Design.colors.caption,
            fontWeight = FontWeight.Bold
        )
    }

    DividerPrimary(modifier = Modifier.padding(bottom = 4.dp).recomposeHighlighter())

    training.exercises.take(4).map { it.name }.forEachIndexed { index, item ->
        TextFieldBody2(
            modifier = Modifier.recomposeHighlighter(),
            provideText = { "${index + 1}.  $item" },
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
    if (training.exercises.size > 4) TextFieldBody2(
        modifier = Modifier.recomposeHighlighter(),
        provideText = { "..." },
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}