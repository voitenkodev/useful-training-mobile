package components.items

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
import DesignComponent
import atomic.icons.BarChart
import components.labels.WeekDayLabel
import controls.DividerPrimary
import controls.IconPrimary
import controls.TextFieldBody2
import controls.secondaryBackground
import models.TrainingComponent

@Composable
fun TrainingItem(
    modifier: Modifier = Modifier,
    training: TrainingComponent,
    edit: () -> Unit,
    review: () -> Unit,
) = Column(
    modifier = modifier
        .secondaryBackground()
        .padding(DesignComponent.size.space)
) {

    TrainingHeader(
        modifier = Modifier.fillMaxWidth(),
        weekDay = training.weekDay,
        date = training.shortStartDateTime,
        review = review,
        edit = edit
    )

    DividerPrimary(modifier = Modifier.padding(bottom = 4.dp, top = 12.dp))

    training.exercises.forEachIndexed { index, item ->
        ExerciseItem(
            number = index + 1,
            exercise = item
        )
    }

    DividerPrimary(modifier = Modifier.padding(vertical = 12.dp))

    TrainingFooter(
        modifier = Modifier.fillMaxWidth(),
        tonnage = training.tonnage,
        durationTime = training.durationTime
    )
}

@Composable
private fun TrainingHeader(
    modifier: Modifier = Modifier,
    weekDay: String,
    date: String,
    review: () -> Unit,
    edit: () -> Unit
) = Row(
    modifier = modifier,
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

@Composable
private fun TrainingFooter(
    modifier: Modifier = Modifier,
    durationTime: String?,
    tonnage: String?,
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
        text = durationTime,
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
        text = "${tonnage}kg",
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )
}