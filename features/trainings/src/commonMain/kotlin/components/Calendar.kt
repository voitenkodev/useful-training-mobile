package components

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import conditional
import controls.TextFieldBody1
import controls.TextFieldH1
import controls.TextFieldH2
import controls.accentBackground
import controls.tertiaryBackground
import platformTopInset
import trainings.SelectableCalendar

@Composable
internal fun PaginatedCalendar(
    modifier: Modifier = Modifier,
    calendar: List<SelectableCalendar>,
    onAddMore: () -> Unit,
    selectCalendarDay: (dateTimeIso: String) -> Unit
) {

    val lazyColumnListState = rememberLazyListState()

    val selectedIndex = remember(calendar) {
        calendar.indexOfFirst { it.isSelected }
    }

    val shouldStartPaginate = remember {
        derivedStateOf {
            (lazyColumnListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                ?: -9) >= (lazyColumnListState.layoutInfo.totalItemsCount - 6)
        }
    }

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

    LaunchedEffect(key1 = shouldStartPaginate.value) {
        if (shouldStartPaginate.value) onAddMore.invoke()
    }

    LaunchedEffect(key1 = selectedIndex) {
        if (selectedIndex != -1) lazyColumnListState.animateScrollAndCentralizeItem(selectedIndex)
    }

    Column(
        modifier = modifier.platformTopInset(),
    ) {
        Spacer(
            modifier = Modifier.size(Design.dp.component)
        )

        MonthSwiper(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            monthNumber = monthIndex,
            month = month,
        )

//        TextFieldH1(
//            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
//            provideText = { month },
//        )

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
                        .conditional(
                            condition = it.isToday,
                            onYes = { accentBackground() },
                            onNot = { tertiaryBackground() }
                        ).clickable { selectCalendarDay.invoke(it.dateTimeIso) }
                        .border(
                            width = Design.dp.border,
                            color = if (it.isSelected) Design.colors.content else Color.Transparent,
                            shape = Design.shape.default
                        )

                ) {

                    TextFieldBody1(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 16.dp),
                        provideText = { it.weekDay },
                        color = Design.colors.caption
                    )

                    TextFieldH2(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 16.dp),
                        provideText = { it.day },
                        color = Design.colors.content
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
                                            color = Design.colors.accent_quinary,
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
}

@Composable
fun MonthSwiper(
    modifier: Modifier = Modifier,
    monthNumber: Int,
    month: String,
) {

    val isPreviousMonth = remember { mutableStateOf(false) }
    val oldMonthNumber = remember { mutableStateOf(-1) }

    // TODO CHECK IT
    if (monthNumber - oldMonthNumber.value == 1) {
        isPreviousMonth.value = false
    } else if (monthNumber - oldMonthNumber.value == -1) {
        isPreviousMonth.value = true
    } else if (monthNumber - oldMonthNumber.value > 1) {
        isPreviousMonth.value = true
    } else if (monthNumber - oldMonthNumber.value < -1) {
        isPreviousMonth.value = false
    }
    oldMonthNumber.value = monthNumber

    AnimatedContent(
        modifier = modifier,
        targetState = month,
        transitionSpec = {
            if (isPreviousMonth.value) {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                    animationSpec = tween(durationMillis = 500)
                ) togetherWith slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                    animationSpec = tween(durationMillis = 500)
                )
            } else {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Down,
                    animationSpec = tween(durationMillis = 500)
                ) togetherWith slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Down,
                    animationSpec = tween(durationMillis = 500)
                )
            }
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