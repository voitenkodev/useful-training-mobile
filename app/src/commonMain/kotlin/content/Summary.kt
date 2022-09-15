package content

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import designsystem.controls.DividerPrimary
import designsystem.controls.TextFieldBody2

@Composable
fun Summary() {
    Card(
        modifier = Modifier.fillMaxWidth(), elevation = 2.dp, shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Section(
                label = "Tonnage",
                value = "30 000"
            )

            DividerPrimary()

            Section(
                label = "Repeats",
                value = "120"
            )

            DividerPrimary()

            Section(
                label = "Intensity",
                value = "54%"
            )
        }
    }
}

@Composable
private fun Section(
    label: String, value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextFieldBody2(
            modifier = Modifier.padding(8.dp),
            text = label,
            fontWeight = FontWeight.Bold
        )
        TextFieldBody2(
            modifier = Modifier.padding(8.dp),
            text = value
        )
    }
}