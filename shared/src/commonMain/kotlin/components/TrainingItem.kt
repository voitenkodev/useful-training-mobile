package components

import Design
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.items.TrainingFooter
import components.items.TrainingHeader
import controls.DividerPrimary
import controls.secondaryBackground
import presentation.training.Training
import recomposeHighlighter

@Composable
internal fun TrainingItem(
    modifier: Modifier = Modifier,
    training: Training,
    edit: (() -> Unit)? = null,
    review: (() -> Unit)? = null,
) = Column(
    modifier = modifier
        .secondaryBackground()
        .padding(horizontal = Design.dp.padding)
        .recomposeHighlighter()
) {

    TrainingHeader(
        modifier = Modifier.fillMaxWidth().recomposeHighlighter(),
        weekDay = training.weekDay,
        date = training.startTime,
        review = review,
        edit = edit
    )

    DividerPrimary(
        modifier = Modifier
            .padding(bottom = 4.dp)
            .recomposeHighlighter()
    )

    training.exercises.forEachIndexed { index, item ->
        val number by rememberUpdatedState(index + 1)
        ExerciseItem(
            modifier = Modifier.recomposeHighlighter(),
            provideNumber = { index + 1 },
            exercise = { item }
        )
    }

    DividerPrimary(
        modifier = Modifier
            .padding(top = 12.dp)
            .recomposeHighlighter()
    )

    TrainingFooter(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter(),
        tonnage = training.tonnage.toString(),
        durationTime = training.durationTime
    )
}