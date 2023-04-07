package design.controls

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import design.Design

@Composable
internal fun BottomSheet(
    modifier: Modifier = Modifier,
    collapsed: Dp,
    expanded: Dp,
    topBar: @Composable BoxScope.(progress: Float) -> Unit,
    listState: LazyListState = rememberLazyListState(),
    content: LazyListScope.() -> Unit,
) {

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed)
    )

    val progress = animateFloatAsState(
        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) 1.0f else 0.0f,
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {

        val contentExpandHeight = this.maxHeight - collapsed
        val contentCollapseHeight = this.maxHeight - expanded

        val headerHeight = animateDpAsState(
            targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) expanded else collapsed,
            animationSpec = spring(stiffness = Spring.StiffnessLow)
        )

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            backgroundColor = Color.Transparent,
            sheetBackgroundColor = Color.Transparent,
            sheetPeekHeight = contentCollapseHeight,
            sheetElevation = 0.dp,
            content = {
                Box(
                    modifier = Modifier.fillMaxWidth().height(headerHeight.value),
                    content = { topBar.invoke(this, progress.value) }
                )
            },

            sheetContent = {
                LazyColumn(
                    state = listState,
                    contentPadding = PaddingValues(Design.dp.padding),
                    modifier = Modifier.fillMaxWidth().height(contentExpandHeight),
                    verticalArrangement = Arrangement.spacedBy(Design.dp.padding),
                    content = content
                )
            }
        )
    }
}