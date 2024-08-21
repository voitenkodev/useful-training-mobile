package trainings.main.components

import DateTimeKtx
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import atom.Design
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonText
import molecule.PaddingM
import molecule.TextBody5
import resources.Icons
import trainings.Training
import trainings.component.Exercise

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
                        .padding(horizontal = Design.dp.paddingL)
                        .background(
                            shape = RoundedCornerShape(
                                topStart = Design.dp.shapeLarge,
                                topEnd = Design.dp.shapeLarge
                            ),
                            color = Design.colors.secondary
                        )
                        .padding(
                            start = Design.dp.paddingM,
                            end = Design.dp.paddingM,
                            top = Design.dp.paddingM,
                            bottom = Design.dp.paddingS
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {

                    TextBody5(
                        modifier = Modifier.wrapContentHeight(),
                        provideText = { date?.uppercase() },
                    )

                    ButtonText(
                        text = "OVERVIEW",
                        trailingIcon = Icons.arrowRight,
                        textDecoration = TextDecoration.None,
                        color = Design.colors.orange,
                        onClick = { openTraining.invoke(training.id) }
                    )
                }
            }

            itemsIndexed(
                items = training.exercises,
                key = { _, item -> "${training.id}:${item.id}" }) { index, item ->

                val number by rememberUpdatedState(index + 1)

                Exercise(
                    modifier = Modifier
                        .padding(horizontal = Design.dp.paddingL)
                        .background(
                            shape = RoundedCornerShape(
                                bottomStart = if (index == training.exercises.lastIndex) Design.dp.shapeLarge else 0.dp,
                                bottomEnd = if (index == training.exercises.lastIndex) Design.dp.shapeLarge else 0.dp,
                            ),
                            color = Design.colors.secondary
                        ).padding(
                            start = Design.dp.paddingM,
                            end = Design.dp.paddingM,
                            top = Design.dp.paddingXS,
                            bottom = if (index == training.exercises.lastIndex) Design.dp.paddingM else Design.dp.paddingXS,
                        ),
                    number = number,
                    exercise = item
                )
            }

            item("footer:${training.id}") {
                PaddingM()
            }
        }

        item("button_space") {
            Spacer(modifier = Modifier.height(Design.dp.paddingS + Design.dp.paddingL + Design.dp.componentS))
        }
    }
}