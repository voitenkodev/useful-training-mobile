package components

import Design
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import conditional
import controls.TextFieldBody1
import controls.TextFieldH2
import controls.accentBackground
import controls.secondaryBackground
import trainings.SelectableCalendar

@Composable
internal fun PaginatedCalendar(
    calendar: List<SelectableCalendar>,
    onAddMore: () -> Unit,
    selectCalendarDay: (dateTimeIso: String) -> Unit
) {

    val selectedIndex = remember(calendar) { calendar.indexOfFirst { it.isSelected } }
    val lazyColumnListState = rememberLazyListState()

    val shouldStartPaginate = remember {
        derivedStateOf {
            (lazyColumnListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                ?: -9) >= (lazyColumnListState.layoutInfo.totalItemsCount - 6)
        }
    }

    LaunchedEffect(key1 = shouldStartPaginate.value) {
        if (shouldStartPaginate.value)
            onAddMore.invoke()
    }

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
                    .conditional(
                        condition = it.isToday,
                        onYes = { accentBackground() },
                        onNot = { secondaryBackground() }
                    ).clickable { selectCalendarDay.invoke(it.dateTimeIso) }
                    .border(
                        width = 1.dp,
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
            }
        }
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