package molecule

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import atom.Design
import kotlinx.coroutines.launch

@Composable
public fun PopupSheet(
    onDismiss: () -> Unit,
    content: @Composable ColumnScope.(hideLambda: () -> Unit) -> Unit
) {

    val modalBottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    val scope = rememberCoroutineScope()

    val hideLambda: () -> Unit = remember {
        {
            scope.launch {
                modalBottomSheetState.hide()
                onDismiss.invoke()
            }
        }
    }

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = Design.colors.secondary,
        scrimColor = Design.colors.black80,
        windowInsets = WindowInsets(top = 0.dp),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        content = { content.invoke(this, hideLambda) }
    )
}