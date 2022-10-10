package designsystem.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import designsystem.atomic.DesignComponent
import designsystem.controls.ButtonSecondary
import designsystem.controls.TextFieldBody2

@Composable
fun QuestionButton(
    modifier: Modifier = Modifier,
    question: String,
    answer: String,
    onClick: () -> Unit
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
    verticalAlignment = Alignment.CenterVertically
) {

    TextFieldBody2(
        text = question,
        color = DesignComponent.colors.caption
    )

    ButtonSecondary(
        text = answer,
        onClick = onClick
    )
}