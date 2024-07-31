package molecule

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.Design

@Composable
public fun Modifier.paddingHorizontalM(): Modifier {
    return padding(horizontal = Design.dp.paddingM)
}

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
public fun PaddingXXL(modifier: Modifier = Modifier) {
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