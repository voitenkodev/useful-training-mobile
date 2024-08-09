package trainings.main.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import atom.Design
import components.ShadowFooterSpace
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingM
import trainings.main.models.Training

@Composable
internal fun Trainings(
    trainings: ImmutableList<Training>,
    openTraining: (trainingId: String) -> Unit
) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {

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

            itemsIndexed(
                items = training.exercises,
                key = { _, item -> "${training.id}:${item.id}" }) { index, item ->

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

        item {
            ShadowFooterSpace(
                contentPadding = PaddingValues(
                    start = Design.dp.paddingM,
                    end = Design.dp.paddingM,
                    bottom = Design.dp.paddingM
                ),
                navigationBarsPadding = false,
            )
        }
    }
}