package designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.components.labels.WeekDayLabel
import designsystem.controls.DividerPrimary
import designsystem.controls.TextFieldBody2
import presentation.state.ShortTrainingState

@Composable
fun ShortTrainingItem(
    modifier: Modifier = Modifier,
    state: ShortTrainingState
) = Column(
    modifier = modifier
        .width(250.dp)
        .height(150.dp)
        .background(
            color = DesignComponent.colors.secondary,
            shape = DesignComponent.shape.default
        )
        .padding(DesignComponent.size.space),
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        WeekDayLabel(
            modifier = Modifier.padding(end = 4.dp),
            weekDay = state.weekDay,
        )

        TextFieldBody2(
            modifier = Modifier.padding(end = 4.dp),
            text = "at",
            color = DesignComponent.colors.caption,
        )

        TextFieldBody2(
            text = state.startDate,
            color = DesignComponent.colors.content,
            fontWeight = FontWeight.Bold
        )
    }

    DividerPrimary(modifier = Modifier.padding(bottom = 4.dp, top = 12.dp))

    state.exercises.take(4).forEachIndexed { index, item ->
        TextFieldBody2(
            text = "${index + 1}.  $item",
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
    TextFieldBody2(
        text = "...",
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}