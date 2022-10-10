package designsystem.components.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import designsystem.atomic.BarChart
import designsystem.atomic.DesignComponent
import designsystem.components.labels.WeekDayLabel
import designsystem.controls.DividerPrimary
import designsystem.controls.IconPrimary
import designsystem.controls.TextFieldBody2
import designsystem.controls.secondaryBackground
import redux.TrainingState

@Composable
fun TrainingItem(
    modifier: Modifier = Modifier,
    state: TrainingState,
    edit: (TrainingState) -> Unit,
    review: (TrainingState) -> Unit,
) = Column(
    modifier = modifier
        .secondaryBackground()
        .padding(12.dp)
) {

    TrainingHeader(
        modifier = Modifier.fillMaxWidth(),
        trainingState = state,
        review = review,
        edit = edit
    )

    DividerPrimary(modifier = Modifier.padding(bottom = 4.dp, top = 12.dp))

    state.exercises.forEachIndexed { index, item ->
        ExerciseItem(
            number = index + 1,
            exercise = item
        )
    }

    DividerPrimary(modifier = Modifier.padding(vertical = 12.dp))

    TrainingFooter(
        modifier = Modifier.fillMaxWidth(),
        trainingState = state
    )
}

@Composable
private fun TrainingHeader(
    modifier: Modifier = Modifier,
    trainingState: TrainingState,
    review: (TrainingState) -> Unit,
    edit: (TrainingState) -> Unit
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(2.dp),
    verticalAlignment = Alignment.CenterVertically,
) {

    WeekDayLabel(
        modifier = Modifier.padding(end = 4.dp),
        weekDay = trainingState.weekDay,
    )

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = "Start Time",
        color = DesignComponent.colors.caption,
    )

    TextFieldBody2(
        text = trainingState.startTime,
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.weight(1f))

    IconPrimary(
        modifier = Modifier.height(20.dp),
        imageVector = BarChart,
        color = DesignComponent.colors.caption,
        onClick = { review.invoke(trainingState) }
    )

    Spacer(modifier = Modifier.size(20.dp))

    IconPrimary(
        modifier = Modifier.height(20.dp),
        imageVector = Icons.Default.Edit,
        color = DesignComponent.colors.caption,
        onClick = { edit.invoke(trainingState) }
    )
}

@Composable
private fun TrainingFooter(
    modifier: Modifier = Modifier,
    trainingState: TrainingState,
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(2.dp),
    verticalAlignment = Alignment.CenterVertically,
) {

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = "Duration",
        color = DesignComponent.colors.caption,
    )

    TextFieldBody2(
        text = trainingState.durationTime,
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.weight(1f))

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = "Tonnage",
        color = DesignComponent.colors.caption,
    )

    TextFieldBody2(
        text = "${trainingState.tonnage}kg",
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )
}