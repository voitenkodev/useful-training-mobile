package design.components.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import design.components.inputs.InputRepeat
import design.components.inputs.InputWeight
import design.controls.DividerPrimary

@Composable
internal fun IterationInputItem(
    modifier: Modifier = Modifier,
    provideWeight: () -> String,
    provideRepeat: () -> String,
    updateWeight: (value: String) -> Unit,
    updateRepeat: (value: String) -> Unit
) {
    Column(modifier = modifier.width(60.dp).padding(vertical = 4.dp)) {

        InputWeight(
            modifier = Modifier,
            provideValue = provideWeight,
            onValueChange = updateWeight
        )

        DividerPrimary(
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        InputRepeat(
            modifier = Modifier,
            provideValue = provideRepeat,
            onValueChange = updateRepeat
        )
    }
}