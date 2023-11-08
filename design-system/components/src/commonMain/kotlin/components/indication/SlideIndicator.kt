package components.indication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import atom.Design

@Composable
public fun SlideIndicator(pagerState: PagerState) {

    val dotWidth = 40.dp
    val dotHeight = 8.dp
    val density = LocalDensity.current
    val distance = with(density) { (dotWidth + Design.dp.paddingS).toPx() }

    Box(contentAlignment = Alignment.CenterStart) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            repeat(pagerState.pageCount) {
                Box(
                    modifier = Modifier
                        .size(width = dotWidth, height = dotHeight)
                        .background(color = Design.colors.white10, shape = CircleShape)
                )
            }
        }

        Box(
            Modifier
                .slidingLineTransition(pagerState, distance)
                .size(width = dotWidth, height = dotHeight)
                .background(color = Design.colors.toxic, shape = CircleShape)
        )
    }
}

private fun Modifier.slidingLineTransition(pagerState: PagerState, distance: Float) =
    graphicsLayer {
        val scrollPosition = pagerState.currentPage + pagerState.currentPageOffsetFraction
        translationX = scrollPosition * distance
    }