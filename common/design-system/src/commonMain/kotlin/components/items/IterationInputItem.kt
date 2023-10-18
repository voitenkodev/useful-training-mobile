package components.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.inputs.InputRepeat
import components.inputs.InputWeight
import controls.DividerPrimary
import recomposeHighlighter

@Composable
fun IterationInputItem(
    modifier: Modifier = Modifier,
    provideWeight: () -> String,
    provideRepeat: () -> String,
    updateWeight: (value: String) -> Unit,
    updateRepeat: (value: String) -> Unit
) {
    Column(
        modifier = modifier
            .width(60.dp)
            .padding(vertical = 4.dp)
            .recomposeHighlighter()
    ) {

        InputWeight(
            provideValue = provideWeight,
            onValueChange = updateWeight
        )

        DividerPrimary(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .recomposeHighlighter()
        )

        InputRepeat(
            modifier = Modifier.recomposeHighlighter(),
            provideValue = provideRepeat,
            onValueChange = updateRepeat
        )
    }
}