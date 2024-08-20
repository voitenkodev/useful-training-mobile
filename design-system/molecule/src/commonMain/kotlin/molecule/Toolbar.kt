package molecule

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design

@Composable
public fun SmallToolbar(
    title: String,
    icon: Pair<ImageVector, () -> Unit>? = null
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Design.dp.componentS),
    ) {

        TextH4(
            modifier = Modifier.align(Alignment.Center),
            provideText = { title },
        )

        if (icon != null) ButtonIconTransparent(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(horizontal = Design.dp.paddingS),
            imageVector = icon.first,
            contentColor = Design.colors.content,
            onClick = icon.second
        ) else Spacer(Modifier.size(Design.dp.componentS))
    }
}

@Composable
public fun Toolbar(
    title: String, icon: Pair<ImageVector, () -> Unit>? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = Design.dp.paddingL,
                start = Design.dp.paddingL,
                end = Design.dp.paddingL
            )
            .height(Design.dp.componentS),
    ) {

        TextH2(
            modifier = Modifier,
            provideText = { title },
            softWrap = false
        )

        PaddingWeight()

        if (icon != null) ButtonIconTransparent(
            modifier = Modifier,
            imageVector = icon.first,
            contentColor = Design.colors.content,
            onClick = icon.second
        ) else Spacer(Modifier.size(Design.dp.componentS))
    }
}