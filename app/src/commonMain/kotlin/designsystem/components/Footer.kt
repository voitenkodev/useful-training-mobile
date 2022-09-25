package designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import designsystem.common.BarChart
import designsystem.common.DesignComponent
import designsystem.common.Save
import designsystem.controls.IconPrimary
import designsystem.controls.TextFieldH1

@Composable
fun BoxScope.Footer(
) = Row(
    modifier = Modifier.fillMaxWidth().height(56.dp).background(DesignComponent.colors.primary),
    horizontalArrangement = Arrangement.SpaceBetween
) {


}
