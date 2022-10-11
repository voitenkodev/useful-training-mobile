import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import components.labels.WeekDayLabel
import controls.DividerPrimary
import controls.TextFieldBody2
import controls.secondaryBackground
import redux.TrainingState

@Composable
fun CollapsedTrainingItem(
    modifier: Modifier = Modifier,
    state: TrainingState,
    onClick: (TrainingState) -> Unit
) = Column(
    modifier = modifier
        .width(250.dp)
        .height(150.dp)
        .secondaryBackground()
        .padding(DesignComponent.size.space)
        .clickable { onClick.invoke(state) },
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        WeekDayLabel(
            modifier = Modifier.padding(end = 4.dp),
            weekDayEnglish = state.weekDay,
        )

        TextFieldBody2(
            modifier = Modifier.padding(end = 4.dp),
            text = "at",
            color = DesignComponent.colors.caption,
        )

        TextFieldBody2(
            text = state.startLongDate,
            color = DesignComponent.colors.content,
            fontWeight = FontWeight.Bold
        )
    }

    DividerPrimary(modifier = Modifier.padding(bottom = 4.dp, top = 12.dp))

    state.exercises.take(4).map { it.name }.forEachIndexed { index, item ->
        TextFieldBody2(
            text = "${index + 1}.  $item",
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
    if (state.exercises.size > 4) TextFieldBody2(
        text = "...",
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}