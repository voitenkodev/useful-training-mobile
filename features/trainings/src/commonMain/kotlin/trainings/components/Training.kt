package trainings.components

import Design
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import components.buttons.ButtonQuestion
import trainings.state.Training

@Composable
internal fun TrainingItem(
    modifier: Modifier = Modifier,
    training: Training,
    onDetailsClick: () -> Unit,
    onTemplateClick: () -> Unit,

    ) {

    val trainingProvider by rememberUpdatedState(training)

    Column(
        modifier = modifier
    ) {

        Spacer(
            modifier = Modifier.size(Design.dp.paddingM)
        )

        TrainingHeader(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            training = trainingProvider
        )

        Spacer(
            modifier = Modifier.size(Design.dp.paddingM)
        )

        TrainingTitle(
            mainTitle = { "At ${training.startDate}" },
            click = onDetailsClick,
        )

        Spacer(
            modifier = Modifier.size(Design.dp.paddingM)
        )

        Exercises(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            training = trainingProvider,
        )

        ButtonQuestion(
            modifier = Modifier.fillMaxWidth(),
            question = "Use training as",
            answer = "Template",
            onClick = onTemplateClick
        )

        Spacer(
            modifier = Modifier.size(Design.dp.paddingS)
        )
    }
}
