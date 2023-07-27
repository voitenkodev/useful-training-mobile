package components.items

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import controls.TextFieldBody2
import utils.recomposeHighlighter

@Composable
fun TrainingFooter(
    modifier: Modifier = Modifier,
    durationTime: String?,
    tonnage: String?,
) {

    val tonnageKg by remember(tonnage) { mutableStateOf("${tonnage}kg") }

    Row(
        modifier = modifier
            .requiredHeight(44.dp)
            .recomposeHighlighter(),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        TextFieldBody2(
            modifier = Modifier
                .padding(end = 4.dp)
                .recomposeHighlighter(),
            provideText = { "Duration:" },
            color = Design.colors.caption,
        )

        TextFieldBody2(
            modifier = Modifier.recomposeHighlighter(),
            provideText = { durationTime },
            color = Design.colors.content,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier
                .weight(1f)
                .recomposeHighlighter()
        )

        TextFieldBody2(
            modifier = Modifier
                .padding(end = 4.dp)
                .recomposeHighlighter(),
            provideText = { "Tonnage:" },
            color = Design.colors.caption,
        )

        TextFieldBody2(
            modifier = Modifier.recomposeHighlighter(),
            provideText = { tonnageKg },
            color = Design.colors.content,
            fontWeight = FontWeight.Bold
        )
    }
}