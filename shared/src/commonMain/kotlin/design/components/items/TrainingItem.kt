package design.components.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import design.Design
import design.controls.DividerPrimary
import design.controls.secondaryBackground
import presentation.training.Training

@Composable
internal fun TrainingItem(
    modifier: Modifier = Modifier,
    training: Training,
    edit: () -> Unit,
    review: () -> Unit,
) = Column(
    modifier = modifier
        .secondaryBackground()
        .padding(horizontal = Design.dp.padding)
) {

    TrainingHeader(
        modifier = Modifier.fillMaxWidth(),
        weekDay = training.weekDay,
        date = training.startTime,
        review = review,
        edit = edit
    )

    DividerPrimary(modifier = Modifier.padding(bottom = 4.dp))

    training.exercises.forEachIndexed { index, item ->
        ExerciseItem(
            number = index + 1,
            exercise = item
        )
    }

    DividerPrimary(modifier = Modifier.padding(top = 12.dp))

    TrainingFooter(
        modifier = Modifier.fillMaxWidth(),
        tonnage = training.tonnage.toString(),
        durationTime = training.durationTime
    )
}