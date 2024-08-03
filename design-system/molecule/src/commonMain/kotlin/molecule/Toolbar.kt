package molecule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import atom.Design

@Composable
public fun SmallToolbar(
    title: String,
    icon: Pair<ImageVector, () -> Unit>? = null
) {
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
}

@Composable
public fun Toolbar(title: String, icon: Pair<ImageVector, () -> Unit>? = null) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Design.dp.componentL),
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
                .padding(horizontal = Design.dp.paddingM)
                .padding(bottom = 2.dp),
            imageVector = icon.first,
            contentColor = Design.colors.content,
            onClick = icon.second
        ) else Spacer(Modifier.size(Design.dp.componentL))
    }
}