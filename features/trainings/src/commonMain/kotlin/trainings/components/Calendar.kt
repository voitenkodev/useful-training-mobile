package trainings.components

import DateTimeKtx
import Design
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import controls.TextFieldBody1
import controls.TextFieldH1
import controls.TextFieldH2
import controls.quaternaryBackground
import platformTopInset
import trainings.state.SelectableCalendar

@Composable
internal fun PaginatedCalendar(
    modifier: Modifier = Modifier,
    calendar: List<SelectableCalendar>,
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
        DateTimeKtx.formattedMonth(iso) ?: ""
    }

    val monthIndex = remember(lazyColumnListState.firstVisibleItemIndex) {
        val iso = calendar
            .getOrNull(lazyColumnListState.firstVisibleItemIndex)
            ?.dateTimeIso
            ?: return@remember -1
        DateTimeKtx.formattedMonthNum(iso) ?: -1
    }

    Column(
        modifier = modifier
            .platformTopInset(),
    ) {

        Spacer(
            modifier = Modifier.size(Design.dp.componentM)
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {

            MonthSwiper(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .padding(horizontal = Design.dp.paddingM),
                monthNumber = monthIndex,
                month = month,
            )

            TodayControl(
                visibilityCondition = { selectedDateIsToday.not() },
                click = { currentDay?.let { selectCalendarDay.invoke(it) } }
            )
        }

        CalendarRow(
            lazyColumnListState = lazyColumnListState,
            calendar = calendar,
            selectCalendarDay = selectCalendarDay,
            onAddMore = onAddMore
        )
    }
}

@Composable

private fun CalendarRow(
    lazyColumnListState: LazyListState,
    calendar: List<SelectableCalendar>,
    selectCalendarDay: (dateTimeIso: String) -> Unit,
    onAddMore: () -> Unit
) {


    val shouldStartPaginate = remember {
        derivedStateOf {
            (lazyColumnListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                ?: -9) >= (lazyColumnListState.layoutInfo.totalItemsCount - 6)
        }
    }

    LaunchedEffect(key1 = shouldStartPaginate.value) {
        if (shouldStartPaginate.value) onAddMore.invoke()
    }

    val selectedIndex = remember(calendar) { calendar.indexOfFirst { it.isSelected } }

    LaunchedEffect(key1 = selectedIndex) {
        if (selectedIndex != -1) lazyColumnListState.animateScrollAndCentralizeItem(selectedIndex)
    }


    LazyRow(
        state = lazyColumnListState,
        modifier = Modifier.fillMaxWidth(),
        reverseLayout = true,
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
        contentPadding = PaddingValues(Design.dp.paddingM)
    ) {

        items(calendar) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .scale(if (it.isSelected) 1.1f else 1f)
                    .border(
                        width = if (it.isSelected) 1.dp else 0.5.dp,
                        color = if (it.isSelected) Design.colors.content else Design.colors.caption,
                        shape = Design.shape.default
                    )
                    .quaternaryBackground()
                    .clickable { selectCalendarDay.invoke(it.dateTimeIso) }
            ) {

                TextFieldBody1(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 18.dp),
                    provideText = { if (it.isToday) "TODAY" else it.weekDay },
                    color = if (it.isToday) Design.colors.accent_primary else if (it.isSelected) Design.colors.content else Design.colors.caption
                )

                TextFieldH2(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 14.dp),
                    provideText = { it.day },
                    color = if (it.isToday) Design.colors.accent_primary else Design.colors.content
                )

                if (it.countOfTrainings != 0) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(Design.dp.paddingS),
                        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
                    ) {
                        repeat(it.countOfTrainings) {
                            Spacer(
                                modifier = Modifier
                                    .size(10.dp)
                                    .background(
                                        color = Design.colors.accent_secondary,
                                        shape = Design.shape.circleShape
                                    )
                            )
                        }
                    }
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
        TextFieldH1(
            modifier = Modifier.fillMaxWidth(),
            provideText = { target },
            softWrap = false
        )
    }
}

private suspend fun LazyListState.animateScrollAndCentralizeItem(index: Int) {
    val itemInfo = this.layoutInfo.visibleItemsInfo.firstOrNull { it.index == index }
    if (itemInfo != null) {
        val center = layoutInfo.viewportEndOffset / 2
        val childCenter = itemInfo.offset + itemInfo.size / 2
        animateScrollBy((childCenter - center).toFloat())
    } else {
        animateScrollToItem(index)
    }
}