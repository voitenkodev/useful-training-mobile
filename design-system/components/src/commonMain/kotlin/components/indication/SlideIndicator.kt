package components.indication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import atom.Design

@Composable
public fun SlideIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    spacing: Dp = 4.dp
) {
    val dotHeight = 8.dp // Fixed height for each dot
    val density = LocalDensity.current

    BoxWithConstraints(modifier = modifier) {
        val screenWidth = maxWidth // Gets the available width of the parent composable

        // Calculate the total width of all spacing between dots
        val totalSpacing = with(density) { (spacing * (pagerState.pageCount - 1)).toPx() }

        // Calculate the width of each dot based on available space
        val availableWidthForDots = with(density) { screenWidth.toPx() } - totalSpacing
        val dotWidthPx = availableWidthForDots / pagerState.pageCount
        val dotWidth = with(density) { dotWidthPx.toDp() }

        Box(contentAlignment = Alignment.CenterStart) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(spacing),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                repeat(pagerState.pageCount) {
                    Box(
                        modifier = Modifier
                            .size(width = dotWidth, height = dotHeight)
                            .background(color = Design.colors.white30, shape = CircleShape)
                    )
                }
            }

            // Slider indicator box
            Box(
                Modifier
                    .slidingLineTransition(
                        pagerState,
                        dotWidthPx + with(density) { spacing.toPx() })
                    .size(width = dotWidth, height = dotHeight)
                    .background(color = Design.colors.orange, shape = CircleShape)
            )
        }
    }
}

private fun Modifier.slidingLineTransition(pagerState: PagerState, distance: Float) =
    graphicsLayer {
        val scrollPosition = pagerState.currentPage + pagerState.currentPageOffsetFraction
        translationX = scrollPosition * distance
    }