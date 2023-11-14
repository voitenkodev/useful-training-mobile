package molecule

import Icons
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import atom.Design

@Composable
public fun ButtonPrimary(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    textColor: Color = Design.colors.content,
    enableBackgroundColor: Color = Design.colors.orange,
    disableBackgroundColor: Color = Design.colors.caption.copy(alpha = 0.1f),
    onClick: () -> Unit,
    loading: Boolean = false
) {

    val bgColor = animateColorAsState(
        targetValue = when {
            loading -> Design.colors.content
            enabled -> enableBackgroundColor
            else -> disableBackgroundColor
        },
        animationSpec = tween(durationMillis = 300, easing = LinearEasing)
    )

    Row(
        modifier = modifier
            .requiredHeight(Design.dp.componentM)
            .borderCirclePrimary()
            .background(
                shape = Design.shape.circleShape,
                color = bgColor.value
            ).clip(
                shape = Design.shape.circleShape
            ).clickable(
                onClick = onClick,
                enabled = enabled && loading.not()
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(loading.not()) {
            TextField(
                modifier = Modifier
                    .padding(horizontal = Design.dp.paddingXL + Design.dp.paddingXL),
                provideText = { text },
                textStyle = Design.typography.PrimaryButton.copy(color = textColor)
            )
        }

        AnimatedVisibility(loading) {

            val infiniteTransition = rememberInfiniteTransition()

            val rotation by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(2000),
                    repeatMode = RepeatMode.Restart
                )
            )

            IconSecondary(
                modifier = Modifier
                    .size(Design.dp.componentM)
                    .padding(Design.dp.paddingXS)
                    .graphicsLayer(rotationZ = rotation),
                imageVector = Icons.loading,
                color = Design.colors.primary
            )
        }
    }
}

@Composable
public fun ButtonSmall(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    textColor: Color = Design.colors.content,
    backgroundColor: Color = Design.colors.orange,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        text = text,
        contentPadding = PaddingValues(horizontal = Design.dp.paddingL, vertical = Design.dp.paddingS),
        textStyle = Design.typography.PrimaryButton.copy(color = textColor),
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            disabledBackgroundColor = Design.colors.caption,
        ),
        shape = Design.shape.circleShape,
        borderStroke = null,
        leadIcon = null
    )
}

@Composable
public fun ButtonTextLink(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    color: Color = Design.colors.content,
    leadIcon: ImageVector? = null,
) {

    val innerBackgroundColor = Color.Companion.Transparent

    Design.typography.TertiaryButton

    TextField(
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        provideText = { text },
        textStyle = Design.typography.TertiaryButton.copy(color = color)
    )
}

@Composable
private fun Button(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    text: String,
    textStyle: TextStyle,
    onClick: () -> Unit,
    enabled: Boolean = true,
    colors: ButtonColors,
    shape: Shape? = null,
    borderStroke: BorderStroke? = null,
    leadIcon: ImageVector? = null,
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        contentPadding = contentPadding,
        shape = shape ?: MaterialTheme.shapes.small,
        border = borderStroke,
        colors = colors,
        content = {
            if (leadIcon != null) {
                Icon(
                    imageVector = leadIcon,
                    modifier = Modifier.size(24.dp),
                    contentDescription = null,
                    tint = Design.colors.content
                )
            }
            TextField(
                modifier = Modifier.padding(horizontal = 0.dp),
                provideText = { text },
                textStyle = textStyle
            )
        }
    )
}