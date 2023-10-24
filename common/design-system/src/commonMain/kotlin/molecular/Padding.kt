package molecular

import Design
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
public fun PaddingXS(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.size(Design.dp.paddingXS))
}

@Composable
public fun PaddingS(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.size(Design.dp.paddingS))
}

@Composable
public fun PaddingM(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.size(Design.dp.paddingM))
}

@Composable
public fun PaddingL(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.size(Design.dp.paddingL))
}