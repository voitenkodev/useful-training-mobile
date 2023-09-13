package trainings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import controls.ButtonSecondaryIcon
import kotlinx.coroutines.launch
import platformInsets

@Composable
internal fun BoxScope.BottomScreenControls(
    pagerState: PagerState,
    addTraining: () -> Unit,
    logout: () -> Unit
) {

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .platformInsets()
            .fillMaxHeight()
            .padding(Design.dp.paddingM)
            .align(Alignment.CenterEnd),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {

        ButtonSecondaryIcon(
            imageVector = Icons.Default.ExitToApp,
            onClick = logout
        )

        Spacer(modifier = Modifier.weight(1f))

        ButtonSecondaryIcon(
            enabled = pagerState.currentPage > 0,
            imageVector = Icons.Default.KeyboardArrowUp,
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                }
            }
        )

        ButtonSecondaryIcon(
            enabled = pagerState.currentPage < (pagerState.pageCount - 1),
            imageVector = Icons.Default.KeyboardArrowDown,
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }
        )

        ButtonSecondaryIcon(
            imageVector = Icons.Default.Add,
            onClick = addTraining,
        )
    }
}