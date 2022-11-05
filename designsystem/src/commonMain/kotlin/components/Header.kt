package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import Design
import androidx.compose.material.icons.filled.ArrowBack
import atomic.icons.BarChart
import atomic.icons.Save
import controls.IconPrimary
import controls.TextFieldH1

@Composable
fun Header(
    title: String?,
    save: (() -> Unit)? = null,
    forward: (() -> Unit)? = null,
    chart: (() -> Unit)? = null,
    exit: (() -> Unit)? = null,
    back: (() -> Unit)? = null,
) = Row(
    modifier = Modifier.fillMaxWidth().height(56.dp).background(Design.colors.primary),
    horizontalArrangement = Arrangement.SpaceBetween
) {

    back?.let {
        Action(
            imageVector = Icons.Default.ArrowBack,
            onClick = it
        )
    }

    TextFieldH1(modifier = Modifier.weight(1f), text = title)

    save?.let {
        Action(
            imageVector = Save,
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
    modifier = Modifier.size(56.dp),
    imageVector = imageVector,
    onClick = onClick
)
