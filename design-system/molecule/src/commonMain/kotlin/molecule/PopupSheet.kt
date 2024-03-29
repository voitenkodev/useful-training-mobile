package molecule

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import atom.Design
import kotlinx.coroutines.launch

public const val POPUP_ANIM_DURATION_MS: Long = 300L

@Composable
public fun PopupSheet(
    onDismiss: () -> Unit,
    cancelable: Boolean = true,
    content: @Composable ColumnScope.(hideLambda: () -> Unit) -> Unit
) {

    val modalBottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { cancelable }
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
        onDismissRequest = onDismiss,
        sheetState = modalBottomSheetState,
        dragHandle = null,
        windowInsets = WindowInsets(top = 0.dp),
        scrimColor = Design.colors.black70,
        containerColor = Color.Transparent,
        shape = RoundedCornerShape(0),
        content = { content.invoke(this, hideLambda) }
    )
}