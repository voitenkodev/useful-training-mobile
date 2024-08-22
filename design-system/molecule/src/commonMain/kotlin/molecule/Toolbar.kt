package molecule

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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(Design.dp.componentS)
            .padding(horizontal = Design.dp.paddingL),
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextH4(
            modifier = Modifier,
            provideText = { title },
        )

        PaddingWeight()

        if (icon != null) ButtonIconTransparent(
            imageVector = icon.first,
            contentColor = Design.colors.content,
            onClick = icon.second
        )
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
                start = Design.dp.paddingL,
                end = Design.dp.paddingL,
                top = Design.dp.paddingL
            ).height(Design.dp.componentS),
        verticalAlignment = Alignment.CenterVertically
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