package trainings.components

import Design
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import components.buttons.ButtonQuestion
import kotlinx.collections.immutable.ImmutableList
import trainings.state.Training

@Composable
internal fun Trainings(
    trainings: ImmutableList<Training>,
    selectedDateIsToday: Boolean,

    newTraining: () -> Unit,
    openTraining: (trainingId: String) -> Unit,
    trainingWithTemplate: (trainingId: String) -> Unit,
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {

        if (selectedDateIsToday) {
            item {
                NewTraining(
                    newTraining = newTraining
                )
            }
        }

        trainings.forEach { training ->

            item("header:${training.id}") {

                Spacer(
                    modifier = Modifier.size(Design.dp.paddingM)
                )

                TrainingHeader(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    training = training
                )

                Spacer(
                    modifier = Modifier.size(Design.dp.paddingM)
                )

                TrainingTitle(
                    mainTitle = { "At ${training.startDate}" },
                    click = {
                        val id = training.id ?: return@TrainingTitle
                        openTraining.invoke(id)
                    },
                )

                Spacer(
                    modifier = Modifier.size(Design.dp.paddingM)
                )
            }

            itemsIndexed(
                training.exercises,
                key = { _, item -> "${training.id}:${item.id}" }
            ) { index, item ->

                val number by rememberUpdatedState(index + 1)

                Exercise(
                    modifier = Modifier,
                    number = number,
                    exercise = item
                )
            }

            item("footer:${training.id}") {


                ButtonQuestion(
                    modifier = Modifier.fillMaxWidth(),
                    question = "Use training as",
                    answer = "Template",
                    onClick = {
                        val id = training.id ?: return@ButtonQuestion
                        trainingWithTemplate.invoke(id)
                    }
                )

                Spacer(
                    modifier = Modifier.size(Design.dp.paddingM)
                )
            }
        }
    }
}