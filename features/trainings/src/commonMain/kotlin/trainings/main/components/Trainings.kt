package trainings.main.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import atom.Design
import components.cards.ActionCard
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingM
import trainings.main.models.Training

@Composable
internal fun Trainings(
    trainings: ImmutableList<Training>,
    selectedDateIsToday: Boolean,
    newTraining: () -> Unit,
    openTraining: (trainingId: String) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {

        if (selectedDateIsToday) {
            item {
                ActionCard(
                    modifier = Modifier.fillMaxWidth().padding(Design.dp.paddingM),
                    btnText = "Start workout",
                    title = "Time to workout",
                    description = "Press to start workout",
                    onClick = newTraining
                )
            }
        }

        trainings.forEach { training ->

            item(key = "header:${training.id}") {

                PaddingM()

                TrainingHeader(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    training = training
                )

                PaddingM()

                TrainingTitle(
                    mainTitle = { "At ${training.startDate}" },
                    click = { openTraining.invoke(training.id) }
                )

                PaddingM()
            }

            itemsIndexed(items = training.exercises, key = { _, item -> "${training.id}:${item.id}" }) { index, item ->

                val number by rememberUpdatedState(index + 1)

                Exercise(
                    modifier = Modifier,
                    number = number,
                    exercise = item
                )
            }

            item("footer:${training.id}") {
                PaddingM()
            }
        }
    }
}