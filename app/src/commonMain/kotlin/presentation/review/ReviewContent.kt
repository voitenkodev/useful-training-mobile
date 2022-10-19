package presentation.review

import DesignComponent
import GlobalState
import PointCircle
import PointLine
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import components.BackHandler
import components.Error
import components.Header
import components.Loading
import components.Root
import components.items.ExerciseItem
import components.items.LineChartItem
import components.items.ShortTrainingItem
import components.labels.WeekDayLabel
import controls.ButtonSecondary
import controls.DividerPrimary
import controls.IconPrimary
import controls.TextFieldBody2
import controls.secondaryBackground
import presentation.map.toExerciseComponent
import presentation.map.toTrainingComponent
import presentation.training.Training
import rememberDispatcher
import selectState

@Composable
fun ReviewContent() {
    val dispatcher = rememberDispatcher()
    val state by selectState<GlobalState, ReviewState> { this.reviewState }

    val presenter = remember { ReviewPresenter(dispatcher) }

    Root(
        modifier = Modifier.fillMaxSize(),
        loading = {
            Loading(state.loading)
        },
        error = {
            Error(message = state.error, close = { dispatcher(ReviewAction.Error(null)) })
        },
        back = {
            BackHandler(action = {
//                navigator.back()
            })
        },
        header = {
            Header(
                title = "Review!",
                exit = {
//                    navigator.back()
                }
            )
        },
        scrollableContent = {
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
                    onClick = { point, index ->
                    }
                )
            }

            item(key = "intensity_chart") {
                ChartSection(
                    label = "Intensity",
                    data = state.reviewTraining.exercises.map { it.intensity.toFloat() },
                    compareData = state.compareTraining?.exercises?.map { it.intensity.toFloat() },
                    color = DesignComponent.colors.unique.color4,
                    onClick = { point, index ->
                    }
                )
            }

            if (state.otherTrainings.isNotEmpty()) {
                item(key = "comparing") {
                    Comparing(
                        list = state.otherTrainings,
                        selected = state.compareTraining,
                        compare = { dispatcher(ReviewAction.CompareTrainings(it)) },
                        clear = { dispatcher(ReviewAction.CompareTrainings(null)) }
                    )
                }
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
                        presenter.removeTraining(state.reviewTraining.id) {
//                            navigator.direct(Graph.Trainings)
                        }
                    }
                )
            }
        }
    )
}

@Composable
private fun Comparing(
    selected: Training?,
    list: List<Training>,
    compare: (Training) -> Unit,
    clear: () -> Unit
) = Column(
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
    ) {

        TextFieldBody2(
            modifier = Modifier.padding(start = DesignComponent.size.space),
            text = "Compare with...",
            color = DesignComponent.colors.caption
        )

        if (selected != null) IconPrimary(
            modifier = Modifier
                .width(16.dp)
                .height(16.dp)
                .background(
                    color = DesignComponent.colors.accent_secondary,
                    shape = DesignComponent.shape.default
                ),
            imageVector = Icons.Default.Clear,
            onClick = clear
        )
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
    ) {

        items(list) {
            ShortTrainingItem(
                training = it.toTrainingComponent(),
                highlight = it == selected,
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
    onClick: (PointLine, Int) -> Unit
) = LineChartItem(
    modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(1.7f),
    lines = buildList {
        add(
            PointLine(
                yValue = data,
                lineColor = color,
                fillColor = color.copy(alpha = 0.2f),
                label = label,
                point = PointCircle(color = DesignComponent.colors.content)
            )
        )
        if (compareData != null) add(
            PointLine(
                yValue = compareData,
                lineColor = DesignComponent.colors.caption,
                fillColor = DesignComponent.colors.caption.copy(alpha = 0.2f),
                label = "Compare",
            )
        )
    },
    onClick = onClick
)

@Composable
private fun Summary(
    state: Training
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
private fun Section(label: String, value: String) = Row(
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
