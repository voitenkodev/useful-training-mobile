package components

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import recomposeHighlighter

@Composable
public fun Loading(visible: () -> Boolean) {

    if (visible().not()) return

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Design.colors.primary.copy(alpha = 0.5f))
            .clickable(enabled = false) {}
            .recomposeHighlighter(),
    ) {
        CircularProgressIndicator(
            color = Design.colors.accentPrimary,
            modifier = Modifier
                .size(80.dp)
                .padding(16.dp)
                .recomposeHighlighter()
        )
    }
}