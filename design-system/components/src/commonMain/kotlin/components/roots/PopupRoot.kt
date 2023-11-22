package components.roots

import Icons
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import molecule.ButtonIconTransparent
import molecule.PaddingS
import molecule.Shadow
import molecule.TextH4
import molecule.bottomSheetBackground
import platformBottomInset

@Composable
public fun PopupRoot(
    modifier: Modifier = Modifier,
    title: String,
    close: () -> Unit,
    content: (@Composable ColumnScope.() -> Unit)
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize()
            .bottomSheetBackground()
            .platformBottomInset()
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

            ButtonIconTransparent(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .padding(Design.dp.paddingS),
                imageVector = Icons.close,
                onClick = close
            )
        }

        Shadow()

        content.invoke(this)
    }
}