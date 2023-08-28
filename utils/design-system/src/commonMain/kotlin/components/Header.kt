package components

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import atomic.icons.BarChart
import controls.IconPrimary
import controls.TextFieldH1
import controls.primaryBackground
import utils.recomposeHighlighter

@Composable
fun Header(
    title: String?,
    save: (() -> Unit)? = null,
    forward: (() -> Unit)? = null,
    chart: (() -> Unit)? = null,
    exit: (() -> Unit)? = null,
    back: (() -> Unit)? = null,
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .height(Design.dp.header)
        .primaryBackground()
        .recomposeHighlighter(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
) {

    back?.let {
        Action(
            imageVector = Icons.Default.ArrowBack,
            onClick = it
        )
    }

    TextFieldH1(
        modifier = Modifier.weight(1f).recomposeHighlighter(),
        provideText = { title }
    )

    save?.let {
        Action(
            imageVector = Icons.Default.Done,
            onClick = it
        )
    }
    chart?.let {
        Action(
            imageVector = BarChart,
            onClick = it
        )
    }
    forward?.let {
        Action(
            imageVector = Icons.Default.ArrowForward,
            onClick = it
        )
    }
    exit?.let {
        Action(
            imageVector = Icons.Default.Clear,
            onClick = it
        )
    }
}

@Composable
private fun Action(
    imageVector: ImageVector,
    onClick: () -> Unit
) = IconPrimary(
    modifier = Modifier.size(56.dp).recomposeHighlighter(),
    imageVector = imageVector,
    onClick = onClick
)
