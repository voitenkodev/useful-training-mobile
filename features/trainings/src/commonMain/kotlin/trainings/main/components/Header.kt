package trainings.main.components

import DateTimeKtx
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import atom.Design
import components.states.animateScrollAndCentralizeItem
import conditional
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingL
import molecule.PaddingM
import molecule.Shadow
import molecule.TextBody4
import molecule.TextH2
import molecule.TextH3
import trainings.main.models.SelectableCalendar

@Composable
internal fun Header(
    calendar: ImmutableList<SelectableCalendar>,
    onAddMore: () -> Unit,
    selectCalendarDay: (dateTimeIso: String) -> Unit
) {

    val currentDay = remember { calendar.findLast { it.isToday }?.dateTimeIso }
    val selectedDate = calendar.findLast { it.isSelected }?.dateTimeIso ?: return
    val selectedDateIsToday = DateTimeKtx.isCurrentDate(selectedDate)

    val lazyColumnListState = rememberLazyListState()

    val month = remember(lazyColumnListState.firstVisibleItemIndex) {
        val iso = calendar
            .getOrNull(lazyColumnListState.firstVisibleItemIndex)
            ?.dateTimeIso
            ?: return@remember ""
        DateTimeKtx.formattedMonth(iso)?.lowercase()?.capitalize(Locale.current) ?: ""
    }

    val monthIndex = remember(lazyColumnListState.firstVisibleItemIndex) {
        val iso = calendar
            .getOrNull(lazyColumnListState.firstVisibleItemIndex)
            ?.dateTimeIso
            ?: return@remember -1
        DateTimeKtx.formattedMonthNum(iso) ?: -1
    }

    Column(modifier = Modifier.statusBarsPadding()) {

        PaddingL()

        Box(
            modifier = Modifier
                .height(Design.dp.componentM)
                .fillMaxWidth(),
        ) {

            MonthSwiper(
                modifier = Modifier
                    .width(260.dp)
                    .padding(horizontal = Design.dp.paddingL),
                monthNumber = monthIndex,
                month = month,
            )

            TodayControl(
                visibilityCondition = { selectedDateIsToday.not() },
                click = { currentDay?.let { selectCalendarDay.invoke(it) } }
            )
        }

        CalendarRow(
            lazyListState = lazyColumnListState,
            calendar = calendar,
            selectCalendarDay = selectCalendarDay,
            onAddMore = onAddMore
        )

        PaddingM()

        Shadow()
    }
}

@Composable
private fun CalendarRow(
    lazyListState: LazyListState,
    calendar: List<SelectableCalendar>,
    selectCalendarDay: (dateTimeIso: String) -> Unit,
    onAddMore: () -> Unit
) {

    val shouldStartPaginate = remember {
        derivedStateOf {
            (lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                ?: -9) >= (lazyListState.layoutInfo.totalItemsCount - 6)
        }
    }

    LaunchedEffect(key1 = shouldStartPaginate.value) {
        if (shouldStartPaginate.value) onAddMore.invoke()
    }

    val selectedIndex = remember(calendar) { calendar.indexOfFirst { it.isSelected } }

    LaunchedEffect(key1 = selectedIndex) {
        if (selectedIndex != -1) lazyListState.animateScrollAndCentralizeItem(selectedIndex)
    }

    LazyRow(
        state = lazyListState,
        modifier = Modifier.fillMaxWidth(),
        reverseLayout = true,
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
        contentPadding = PaddingValues(horizontal = Design.dp.paddingM)
    ) {

        items(calendar) {
            Box(modifier = Modifier.scale(if (it.isSelected) 1.1f else 1f)) {
                Column(
                    modifier = Modifier
                        .size(Design.dp.componentXL)
                        .conditional(
                            condition = it.isSelected,
                            onYes = {
                                background(
                                    color = Design.palette.tertiary,
                                    shape = Design.shape.default
                                )
                            },
                            onNot = {
                                background(
                                    color = Design.palette.secondary,
                                    shape = Design.shape.default
                                )
                            }
                        ).clickable { selectCalendarDay.invoke(it.dateTimeIso) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    TextBody4(
                        modifier = Modifier,
                        provideText = { if (it.isToday) "NOW" else it.weekDay },
                        color = if (it.isToday) Design.colors.yellow else if (it.isSelected) Design.colors.content else Design.colors.label
                    )

                    TextH3(
                        provideText = { it.day },
                        color = if (it.isToday) Design.colors.yellow else Design.colors.content
                    )
                }

                if (it.repetitions != 0) {
                    Spacer(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .size(10.dp)
                            .background(
                                color = Design.colors.secondary,
                                shape = Design.shape.circleShape
                            )
                            .padding(1.dp)
                            .background(
                                color = Design.colors.green,
                                shape = Design.shape.circleShape
                            )
                    )
                }
            }
        }
    }
}

@Composable
private fun MonthSwiper(
    modifier: Modifier = Modifier,
    monthNumber: Int,
    month: String,
) {
    var oldMonthNumber by remember { mutableStateOf(-1) }

    val isPreviousMonth = if (monthNumber - oldMonthNumber == 1) false
    else if (monthNumber - oldMonthNumber == -1) true
    else monthNumber - oldMonthNumber > 1

    oldMonthNumber = monthNumber

    val slideDirection = if (isPreviousMonth) {
        AnimatedContentTransitionScope.SlideDirection.Up
    } else {
        AnimatedContentTransitionScope.SlideDirection.Down
    }

    AnimatedContent(
        modifier = modifier,
        targetState = month,
        transitionSpec = {
            slideIntoContainer(
                towards = slideDirection,
                animationSpec = tween(durationMillis = 500)
            ) togetherWith slideOutOfContainer(
                towards = slideDirection,
                animationSpec = tween(durationMillis = 500)
            )
        }
    ) { target ->
        TextH2(
            modifier = Modifier,
            provideText = { target },
            softWrap = false
        )
    }
}