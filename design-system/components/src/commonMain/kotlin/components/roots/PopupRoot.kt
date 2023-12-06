package components.roots

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import molecule.bottomSheetBackground
import platformBottomInset

@Composable
public fun PopupRoot(
    modifier: Modifier = Modifier,
    content: (@Composable ColumnScope.() -> Unit)
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize()
            .bottomSheetBackground()
            .platformBottomInset()
            .pointerInput(Unit) { detectTapGestures(onTap = { focusManager.clearFocus() }) }
    ) {

        content.invoke(this)
    }
}