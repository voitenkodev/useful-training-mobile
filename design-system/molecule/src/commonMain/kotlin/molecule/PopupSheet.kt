package molecule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
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
                modifier = Modifier.fillMaxWidth(),
                content = {

                    PaddingL()

                    Box(
                        modifier = Modifier
                            .size(width = 28.dp, height = 6.dp)
                            .background(color = Design.colors.caption.copy(alpha = 0.5f), shape = Design.shape.circleShape)
                            .align(Alignment.CenterHorizontally)
                    )

                    PaddingL()

                    sheetContent.invoke(this)

                    PaddingXL()
                }
            )
        },
        scrimColor = Design.colors.black30,
        content = content
    )
}