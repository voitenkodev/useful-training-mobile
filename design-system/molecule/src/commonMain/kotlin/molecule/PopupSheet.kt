package molecule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design

@Composable
public fun PopupSheet(
    onClose: (() -> Unit)? = null,
    visibility: Boolean,
    cancelable: Boolean = true,
    sheetContent: @Composable ColumnScope.() -> Unit,
    content: @Composable () -> Unit,
) {

    val state = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
        confirmValueChange = {
            if (cancelable && it == ModalBottomSheetValue.Hidden) {
                onClose?.invoke()
            }
            cancelable
        }
    )

    LaunchedEffect(visibility) {
        if (visibility) {
            state.show()
        } else if (state.isVisible) {
            state.hide()
        }
    }

    ModalBottomSheetLayout(
        sheetState = state,
        sheetBackgroundColor = Design.colors.secondary,
        sheetShape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp
        ),
        sheetContent = {
            Column(
                modifier = Modifier.padding(
                    vertical = Design.dp.paddingXL,
                    horizontal = Design.dp.paddingM
                ),
                content = {
                    sheetContent.invoke(this)
                }
            )
        },
        scrimColor = Design.colors.black30,
        content = content
    )
}