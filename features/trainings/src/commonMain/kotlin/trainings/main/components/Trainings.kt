package trainings.main.components

import DateTimeKtx
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import atom.Design
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonText
import molecule.PaddingM
import molecule.TextBody4
import resources.Icons
import trainings.Training

@Composable
internal fun Trainings(
    trainings: ImmutableList<Training>,
    openTraining: (trainingId: String) -> Unit
) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        trainings.forEach { training ->

            item(key = "header:${training.id}") {
                PaddingM()

                val date = remember(training.createdAt) {
                    DateTimeKtx.convert(
                        training.createdAt,
                        DateTimeKtx.Format.HH_MM_DD_MMM
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Design.dp.paddingL),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {

                    TextBody4(
                        modifier = Modifier.wrapContentHeight(),
                        provideText = { "At $date" },
                    )

                    ButtonText(
                        text = "OVERVIEW",
                        trailingIcon = Icons.arrowRight,
                        textDecoration = TextDecoration.None,
                        color = Design.colors.orange,
                        onClick = { openTraining.invoke(training.id) }
                    )
                }

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
    }
}