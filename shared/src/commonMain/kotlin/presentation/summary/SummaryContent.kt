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
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import presentation.training.Exercise
import presentation.training.Training
import utils.DateTimeKtx.monthTitle

@Composable
internal fun SummaryContent(vm: SummaryViewModel) {

    val listState = rememberLazyListState()

    val state by vm.state.collectAsState()

    LaunchedEffect(Unit) {
        vm.getTrainings()
    }

    Content(
        listState = listState,
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        back = vm::back,

        query = { state.query },
        search = vm::setQuery,

        month = state.selectedMonth,
        year = state.selectedYear,
        trainingDays = { state.currentMonthTrainings },
        leftMonth = vm::decreaseMonth,
        rightMonth = vm::increaseMonth,
        dayClick = vm::findIndexOfTraining,

        exercises = { state.exercises },
        trainings = { state.trainings },
        listOfTonnage = { state.listOfTonnage }
    )

    AutoScrollStateHandler(
        provideScrollIndex = { state.autoScrollIndex },
        listState = listState,
        doAfterScroll = vm::clearAutoScrollIndex
    )
}

@Composable
private fun Content(
    listState: LazyListState,
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,
    back: () -> Unit,

    // Search
    query: () -> String,
    search: (String) -> Unit,

    // Calendar
    month: Int,
    year: Int,
    trainingDays: () -> List<Int>,
    leftMonth: () -> Unit,
    rightMonth: () -> Unit,
    dayClick: (day: Int, month: Int) -> Unit,

    // Trainings + Exercises
    exercises: () -> Map<ExerciseInfo, List<Exercise>>,
    trainings: () -> List<Training>,

    // Charts
    listOfTonnage: () -> List<Float>
) {

    val isEmptyExercises by remember(exercises()) { mutableStateOf(exercises().isEmpty()) }
    val isNotEmptyTonnage by remember(listOfTonnage()) { mutableStateOf(listOfTonnage().isNotEmpty()) }
    val isSearchBlank by remember(query()) { mutableStateOf(query().isBlank()) }

    ScrollableRoot(
        modifier = Modifier.fillMaxSize(),
        listState = listState,
        loading = { Loading(loading()) },
        error = { Error(message = error(), close = clearError) },
        back = { PlatformBackHandler(back) },
        popups = {},
        header = {
            Header(
                title = "Summary!",
                exit = back
            )
        },
        content = {
            item(key = "input_search") {
                InputSearch(
                    value = query,
                    onValueChange = search
                )
            }

            if (isEmptyExercises)
                item(key = "calendar_component") {
                    CalendarSection(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1.4f)
                            .animateItemPlacement(),
                        provideMonth = { month },
                        provideYear = { year },
                        provideTrainingDays = trainingDays,
                        leftMonth = leftMonth,
                        rightMonth = rightMonth,
                        dayClick = { dayClick(it, month) }
                    )
                }

            if (isNotEmptyTonnage)
                item(key = "tonnage_chart") {
                    ChartSection(
                        label = "Tonnage",
                        provideData = listOfTonnage,
                        color = Design.colors.unique.color1,
                    )
                }

            if (isSearchBlank)
                items(trainings(), key = { it.id!! }) { training ->
                    TrainingItem(
                        training = training,
                    )
                }

            item(key = "exercises") {

                exercises().forEach { item ->

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
fun AutoScrollStateHandler(
    listState: LazyListState,
    provideScrollIndex: () -> Int,
    doAfterScroll: () -> Unit
) {

    val stickyHeaderSize = with(LocalDensity.current) { Design.dp.header.toPx() }

    LaunchedEffect(provideScrollIndex()) {
        // spacer + header + search view + chart + calendar
        val constantItemCount = 5
        if (provideScrollIndex() == -1) return@LaunchedEffect
        val realIndex = provideScrollIndex() + constantItemCount
        if (realIndex in 0..listState.layoutInfo.totalItemsCount) {
            listState.animateScrollToItem(index = realIndex, scrollOffset = -stickyHeaderSize.toInt())
            doAfterScroll.invoke()
        }
    }
}

@Composable
private fun CalendarSection(
    modifier: Modifier,
    provideMonth: () -> Int,
    provideYear: () -> Int,
    provideTrainingDays: () -> List<Int>,
    leftMonth: () -> Unit,
    rightMonth: () -> Unit,
    dayClick: (Int) -> Unit
) {
    Column(
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
                text = "${monthTitle(provideMonth())} ${provideYear()}",
                fontWeight = FontWeight.Bold
            )

            IconPrimary(
                imageVector = Icons.Default.ArrowForward,
                onClick = rightMonth
            )
        }

        Calendar(
            month = provideMonth(),
            year = provideYear(),
            listOfDays = provideTrainingDays,
            headerColor = Color.Transparent,
            daysColor = Design.colors.content,
            labelsColor = Design.colors.accent_secondary,
            selectedColor = Design.colors.accent_primary,
            dayClick = dayClick
        )
    }
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
    provideData: () -> List<Float>,
) {
    val pointColor = Design.colors.content

    val items by remember(provideData()) {
        mutableStateOf(buildList {
            add(
                PointLine(
                    yValue = provideData(),
                    lineColor = color,
                    fillColor = color.copy(alpha = 0.2f),
                    label = label,
                    point = PointCircle(color = pointColor)
                )
            )
        }
        )
    }

    LineChartItem(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.7f)
            ,
        lines = { items }
    )
}