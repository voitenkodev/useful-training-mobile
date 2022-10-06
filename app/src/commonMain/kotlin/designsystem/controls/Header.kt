package designsystem.controls

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import designsystem.atomic.BarChart
import designsystem.atomic.DesignComponent
import designsystem.atomic.Save

@Composable
fun Header(
    title: String?,
    save: (() -> Unit)? = null,
    forward: (() -> Unit)? = null,
    chart: (() -> Unit)? = null,
    exit: (() -> Unit)? = null,
) = Row(
    modifier = Modifier.fillMaxWidth().height(56.dp).background(DesignComponent.colors.primary),
    horizontalArrangement = Arrangement.SpaceBetween
) {
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
