package molecule

import androidx.compose.foundation.layout.Box
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
            .height(Design.dp.componentM),
    ) {

        TextH3(
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
        ) else Spacer(Modifier.size(Design.dp.componentM))
    }
}

@Composable
public fun Toolbar(title: String, icon: Pair<ImageVector, () -> Unit>? = null) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Design.dp.componentM),
    ) {

        TextH2(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = Design.dp.paddingM),
            provideText = { title },
            softWrap = false
        )

        if (icon != null) ButtonIconTransparent(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(horizontal = Design.dp.paddingM),
            imageVector = icon.first,
            contentColor = Design.colors.content,
            onClick = icon.second
        ) else Spacer(Modifier.size(Design.dp.componentM))
    }
}