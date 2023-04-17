package presentation.summary

import PlatformBackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import design.Design
import design.calendar.Calendar
import design.chart.PointCircle
import design.chart.PointLine
import design.components.Error
import design.components.Header
import design.components.Loading
import design.components.inputs.InputSearch
import design.components.items.ExerciseItem
import design.components.items.LineChartItem
import design.components.items.TrainingItem
import design.components.labels.WeekDayLabel
import design.components.roots.ScrollableRoot
import design.controls.IconPrimary
import design.controls.TextFieldBody2
import design.controls.TextFieldH2
import utils.DateTimeKtx.monthTitle

@Composable
internal fun SummaryContent(vm: SummaryViewModel) {

    val listState = rememberLazyListState()

    val state by vm.state

    LaunchedEffect(Unit) {
        vm.getTrainings()
    }

    val stickyHeaderSize = with(LocalDensity.current) { Design.dp.header.toPx() }

    LaunchedEffect(state.autoScrollIndex) {
        // spacer + header + search view + chart + calendar
        val constantItemCount = 5
        if (state.autoScrollIndex == -1) return@LaunchedEffect
        val realIndex = state.autoScrollIndex + constantItemCount
        if (realIndex in 0..listState.layoutInfo.totalItemsCount) {
            listState.animateScrollToItem(index = realIndex, scrollOffset = -stickyHeaderSize.toInt())
            vm.clearAutoScrollIndex()
        }
    }

    ScrollableRoot(
        modifier = Modifier.fillMaxSize(),
        listState = listState,
        loading = { Loading(state.loading) },
        error = { Error(message = state.error, close = vm::clearError) },
        back = { PlatformBackHandler(vm::back) },
        popups = {},
        header = {
            Header(
                title = "Summary!",
                exit = vm::back
            )
        },
        content = {
            item(key = "search_input") {
                InputSearch(
                    value = state.query,
                    onValueChange = vm::setQuery
                )
            }

            if (state.exercises.isEmpty())
                item(key = "calendar_component") {
                    CalendarSection(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1.4f)
                            .animateItemPlacement(),
                        month = state.selectedMonth,
                        year = state.selectedYear,
                        trainingDays = state.currentMonthTrainings,
                        leftMonth = vm::decreaseMonth,
                        rightMonth = vm::increaseMonth,
                        dayClick = { vm.findIndexOfTraining(day = it, month = state.selectedMonth) }
                    )
                }

            if (state.listOfTonnage.isNotEmpty())
                item(key = "tonnage_chart") {
                    ChartSection(
                        label = "Tonnage",
                        data = state.listOfTonnage,
                        color = Design.colors.unique.color1,
                    )
                }

            if (state.query.isBlank())
                items(state.trainings, key = { it.id ?: it.hashCode() }) { training ->
                    TrainingItem(
                        training = training,
                    )
                }

            item(key = "exercises") {

                state.exercises.forEach { item ->

                    Spacer(
                        modifier = Modifier.height(Design.dp.padding)
                    )

                    ExerciseHeader(
                        weekDay = item.key.weekDay,
                        date = item.key.dateTime
                    )

                    item.value.forEachIndexed { index, exercise ->
                        ExerciseItem(
                            number = index + 1,
                            exercise = exercise
                        )
                    }
                }
            }
        }
    )
}

@Composable
private fun CalendarSection(
    modifier: Modifier,
    month: Int,
    year: Int,
    trainingDays: List<Int>,
    leftMonth: () -> Unit,
    rightMonth: () -> Unit,
    dayClick: (Int) -> Unit
) = Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Design.dp.padding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        IconPrimary(
            imageVector = Icons.Default.ArrowBack,
            onClick = leftMonth
        )

        TextFieldH2(
            modifier = Modifier,
            text = "${monthTitle(month)} $year",
            fontWeight = FontWeight.Bold
        )

        IconPrimary(
            imageVector = Icons.Default.ArrowForward,
            onClick = rightMonth
        )
    }

    Calendar(
        month = month,
        year = year,
        listOfDays = trainingDays,
        headerColor = Color.Transparent,
        daysColor = Design.colors.content,
        labelsColor = Design.colors.accent_secondary,
        selectedColor = Design.colors.accent_primary,
        dayClick = dayClick
    )
}

@Composable
private fun ExerciseHeader(
    modifier: Modifier = Modifier,
    weekDay: String,
    date: String,
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(4.dp),
    verticalAlignment = Alignment.CenterVertically,
) {

    WeekDayLabel(
        modifier = Modifier.padding(end = 4.dp),
        weekDayEnglish = weekDay,
    )

    TextFieldBody2(
        text = date,
        color = Design.colors.caption,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun ChartSection(
    label: String,
    color: Color,
    data: List<Float>,
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
                point = PointCircle(color = Design.colors.content)
            )
        )
    }
)