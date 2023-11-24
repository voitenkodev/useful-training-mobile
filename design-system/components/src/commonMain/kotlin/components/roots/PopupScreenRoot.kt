package components.roots

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import atom.Design
import molecule.ButtonIconTransparent
import molecule.PaddingS
import molecule.Shadow
import molecule.TextH4
import molecule.secondaryBackground
import platformInsets

@Composable
public fun PopupScreenRoot(
    modifier: Modifier = Modifier,
    title: String,
    icon: Pair<ImageVector, () -> Unit>? = null,
    content: (@Composable ColumnScope.() -> Unit)
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .animateContentSize()
            .secondaryBackground()
            .platformInsets()
            .pointerInput(Unit) { detectTapGestures(onTap = { focusManager.clearFocus() }) }
    ) {

        PaddingS()

        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .padding(start = Design.dp.paddingM)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextH4(provideText = { title })

            if (icon != null) ButtonIconTransparent(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .padding(Design.dp.paddingS),
                imageVector = icon.first,
                onClick = icon.second
            )
            else Spacer(Modifier.size(Design.dp.componentS))
        }

        Shadow()

        content.invoke(this)
    }
}