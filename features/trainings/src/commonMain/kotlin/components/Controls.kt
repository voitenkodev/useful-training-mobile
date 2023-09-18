package components

import Design
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import controls.ButtonSecondaryIcon
import kotlinx.coroutines.launch
import platformInsets

@Composable
internal fun BoxScope.TrainingsControls(
    modifier: Modifier = Modifier,
    visibilityCondition: () -> Boolean = { true },
    pagerState: PagerState,
    addTraining: () -> Unit,
    openTraining: () -> Unit,
    logout: () -> Unit
) {

    val coroutineScope = rememberCoroutineScope()

    val animatedDp by animateDpAsState(
        targetValue = if (visibilityCondition()) 0.dp else Design.dp.component + Design.dp.paddingL,
        animationSpec = tween(
            durationMillis = Design.duration.animDurationS,
        )
    )

    val animatedFloat by animateFloatAsState(
        targetValue = if (visibilityCondition()) 0f else 180f,
        animationSpec = tween(
            durationMillis = Design.duration.animDurationS,
        )
    )

    Column(
        modifier = modifier
            .platformInsets()
            .fillMaxHeight()
            .padding(Design.dp.paddingM)
            .align(Alignment.CenterEnd),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {

        Spacer(modifier = Modifier.weight(1f))

        ButtonSecondaryIcon(
            modifier = Modifier.offset(x = animatedDp),
            imageVector = Icons.Default.ExitToApp,
            onClick = logout
        )

        ButtonSecondaryIcon(
            modifier = Modifier.offset(x = animatedDp),
            enabled = pagerState.currentPage > 0,
            imageVector = Icons.Default.KeyboardArrowUp,
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                }
            }
        )

        ButtonSecondaryIcon(
            modifier = Modifier.offset(x = animatedDp),
            enabled = pagerState.currentPage < (pagerState.pageCount - 1),
            imageVector = Icons.Default.KeyboardArrowDown,
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }
        )

        ButtonSecondaryIcon(
            modifier = Modifier.offset(x = animatedDp),
            imageVector = Icons.Default.Add,
            onClick = addTraining,
        )

        ButtonSecondaryIcon(
            modifier = Modifier.rotate(animatedFloat),
            imageVector = Icons.Default.KeyboardArrowRight,
            onClick = openTraining,
        )
    }
}

@Composable
internal fun BoxScope.ReviewControls(
    modifier: Modifier = Modifier,
    back: () -> Unit
) {

    Column(
        modifier = modifier
            .platformInsets()
            .fillMaxHeight()
            .padding(Design.dp.paddingM)
            .align(Alignment.CenterEnd),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {

        Spacer(modifier = Modifier.weight(1f))

        ButtonSecondaryIcon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            onClick = back
        )
    }
}