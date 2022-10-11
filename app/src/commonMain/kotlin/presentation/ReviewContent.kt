package presentation

import DesignComponent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import components.Header
import components.Root
import components.items.ExerciseItem
import components.items.LineChartItem
import components.items.ShortTrainingItem
import components.labels.WeekDayLabel
import controls.ButtonSecondary
import controls.DividerPrimary
import controls.TextFieldBody2
import controls.secondaryBackground
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import models.PointLineComponent
import presentation.map.toExerciseComponent
import presentation.map.toTrainingComponent
import redux.Direction
import redux.GlobalState
import redux.NavigatorAction
import redux.ReviewAction
import redux.ReviewState
import redux.TrainingState
import redux.rememberDispatcher
import redux.selectState
import rememberComposeCoroutineContext

@Composable
fun ReviewContent(
    modifier: Modifier = Modifier,
) {
    val api = globalKoin().get<TrainingRepository>()
    val loader = rememberComposeCoroutineContext()

    val dispatcher = rememberDispatcher()
    val state by selectState<GlobalState, ReviewState> { this.reviewState }

    Root(
        modifier = modifier.fillMaxSize(),
        header = {
            Header(
                title = "Review!",
                exit = { dispatcher(NavigatorAction.BACK) }
            )
        },
        content = {
            item(key = "date") {
                DateItem(
                    weekDay = state.reviewTraining.weekDay,
                    startTime = state.reviewTraining.startTime,
                    startDate = state.reviewTraining.shortStartDate
                )
            }

            item(key = "tonnage_chart") {
                ChartSection(
                    label = "Tonnage",
                    data = state.reviewTraining.exercises.map { it.tonnage.toFloat() },
                    compareData = state.compareTraining?.exercises?.map { it.tonnage.toFloat() },
                    color = DesignComponent.colors.unique.color1,
                )
            }

            item(key = "intensity_chart") {
                ChartSection(
                    label = "Intensity",
                    data = state.reviewTraining.exercises.map { it.intensity.toFloat() },
                    compareData = state.compareTraining?.exercises?.map { it.intensity.toFloat() },
                    color = DesignComponent.colors.unique.color4,
                )
            }

            item(key = "comparing") {
                Comparing(
                    list = state.otherTrainings,
                    compare = { dispatcher(ReviewAction.CompareTrainings(it)) }
                )
            }

            item(key = "summary") {
                Summary(state = state.reviewTraining)
            }

            item(key = "exercises") {
                state.reviewTraining.exercises.forEachIndexed { index, item ->
                    ExerciseItem(
                        number = index + 1,
                        exercise = item.toExerciseComponent()
                    )
                }
            }

            item(key = "remove_action") {
                ButtonSecondary(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Remove Training",
                    onClick = {
                        loader.call {
                            api
                                .removeTraining(trainingId = state.reviewTraining.id ?: error("invalid Training ID"))
                                .onEach { dispatcher(NavigatorAction.NAVIGATE(Direction.Trainings)) }
                                .catch { }
                                .launchIn(this)
                        }
                    },
                )
            }
        }
    )
}

@Composable
private fun Comparing(
    list: List<TrainingState>,
    compare: (TrainingState) -> Unit
) = Column(
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
) {

    TextFieldBody2(
        modifier = Modifier.padding(start = DesignComponent.size.space),
        text = "Compare with...",
        color = DesignComponent.colors.caption
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
    ) {
        items(list) {
            ShortTrainingItem(
                training = it.toTrainingComponent(),
                onClick = { compare.invoke(it) }
            )
        }
    }
}

@Composable
private fun DateItem(
    modifier: Modifier = Modifier,
    weekDay: String,
    startTime: String,
    startDate: String
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(2.dp),
    verticalAlignment = Alignment.CenterVertically,
) {

    WeekDayLabel(
        modifier = Modifier.padding(end = 4.dp),
        weekDayEnglish = weekDay
    )

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = "Date",
        color = DesignComponent.colors.caption,
    )

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = startTime,
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )

    TextFieldBody2(
        text = startDate,
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun ChartSection(
    label: String,
    color: Color,
    data: List<Float>,
    compareData: List<Float>? = null,
) = LineChartItem(
    modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(1.7f),
    lines = buildList {
        add(
            PointLineComponent(
                yValue = data,
                lineColor = color,
                fillColor = color.copy(alpha = 0.2f),
                pointColor = DesignComponent.colors.content,
                label = label
            )
        )
        if (compareData != null) add(
            PointLineComponent(
                yValue = compareData,
                lineColor = DesignComponent.colors.caption,
                fillColor = DesignComponent.colors.caption.copy(alpha = 0.2f),
                label = "Compare"
            )
        )
    }
)

@Composable
private fun Summary(
    state: TrainingState
) = Column(
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
) {

    TextFieldBody2(
        modifier = Modifier.padding(start = DesignComponent.size.space),
        text = "Summary",
        color = DesignComponent.colors.caption
    )

    Column(
        modifier = Modifier
            .secondaryBackground()
            .padding(horizontal = DesignComponent.size.space),
    ) {

        Section(
            label = "Tonnage", value = "${state.tonnage}kg"
        )

        DividerPrimary()

        Section(
            label = "Repeats", value = "${state.countOfLifting}"
        )

        DividerPrimary()

        Section(
            label = "Intensity", value = "${state.intensity}%"
        )

        DividerPrimary()

        Section(
            label = "Duration", value = state.durationTime
        )
    }
}

@Composable
private fun Section(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = DesignComponent.size.space),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextFieldBody2(
            text = label,
            color = DesignComponent.colors.caption,
        )
        TextFieldBody2(
            text = value,
            fontWeight = FontWeight.Bold,
        )
    }
}