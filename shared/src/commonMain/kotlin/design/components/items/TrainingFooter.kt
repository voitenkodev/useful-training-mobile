package design.components.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import design.Design
import design.controls.TextFieldBody2

@Composable
internal fun TrainingFooter(
    modifier: Modifier = Modifier,
    durationTime: String?,
    tonnage: String?,
) {

    val tonnageKg = remember(tonnage) { "${tonnage}kg" }

    Row(
        modifier = modifier.requiredHeight(44.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        TextFieldBody2(
            modifier = Modifier.padding(end = 4.dp),
            text = "Duration:",
            color = Design.colors.caption,
        )

        TextFieldBody2(
            text = durationTime,
            color = Design.colors.content,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        TextFieldBody2(
            modifier = Modifier.padding(end = 4.dp),
            text = "Tonnage:",
            color = Design.colors.caption,
        )

        TextFieldBody2(
            text = tonnageKg,
            color = Design.colors.content,
            fontWeight = FontWeight.Bold
        )
    }
}