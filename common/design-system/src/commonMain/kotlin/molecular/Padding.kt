package molecular

import Design
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
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

@Composable
public fun PaddingXL(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.size(Design.dp.paddingXL))
}

@Composable
public fun RowScope.PaddingWeight(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.weight(1f))
}

@Composable
public fun ColumnScope.PaddingWeight(modifier: Modifier = Modifier, value: Float = 1f) {
    Spacer(modifier = modifier.weight(value))
}