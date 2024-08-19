package molecule

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import atom.Design

@Composable
public fun ButtonPrimary(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
    trailingIcon: ImageVector? = null,
    leadingIcon: ImageVector? = null,
) {

    val textColor: Color = Design.colors.content
    val backgroundColor: Color = Design.colors.orange

    val alpha = animateFloatAsState(
        targetValue = when (enabled) {
            true -> 1f
            false -> 0.4f
        },
        animationSpec = tween(durationMillis = 300, easing = LinearEasing)
    )

    Row(
        modifier = modifier
            .alpha(alpha.value)
            .requiredHeight(Design.dp.componentM)
            .background(
                shape = Design.shape.default,
                color = backgroundColor
            ).clip(
                shape = Design.shape.default
            ).clickable(
                onClick = onClick,
                enabled = enabled
            ).padding(
                horizontal = Design.dp.paddingL
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            Design.dp.paddingS,
            Alignment.CenterHorizontally
        )
    ) {
        if (leadingIcon != null) {
            Icon(
                modifier = Modifier.size(Design.dp.iconM),
                imageVector = leadingIcon,
                color = textColor
            )
        }

        TextField(
            modifier = Modifier.padding(
                start = if (trailingIcon != null) Design.dp.paddingM else 0.dp,
                end = if (leadingIcon != null) Design.dp.paddingM else 0.dp,
            ),
            provideText = { text },
            textStyle = Design.typography.button.copy(color = textColor)
        )

        if (trailingIcon != null) {
            Icon(
                modifier = Modifier.size(Design.dp.iconXS),
                imageVector = trailingIcon,
                color = textColor
            )
        }
    }
}

@Composable
public fun ButtonSecondary(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
    trailingIcon: ImageVector? = null,
    leadingIcon: ImageVector? = null,
) {

    val textColor: Color = Design.colors.content
    val enableBackgroundColor: Color = Color.Transparent

    val alpha = animateFloatAsState(
        targetValue = when (enabled) {
            true -> 1f
            false -> 0.4f
        },
        animationSpec = tween(durationMillis = 300, easing = LinearEasing)
    )

    Row(
        modifier = modifier
            .alpha(alpha.value)
            .requiredHeight(Design.dp.componentM)
            .background(
                shape = Design.shape.default,
                color = enableBackgroundColor
            ).clip(
                shape = Design.shape.default
            ).clickable(
                onClick = onClick,
                enabled = enabled
            ).padding(
                horizontal = Design.dp.paddingL
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            Design.dp.paddingS,
            Alignment.CenterHorizontally
        )
    ) {

        if (leadingIcon != null) {
            Icon(
                modifier = Modifier.size(Design.dp.iconXS),
                imageVector = leadingIcon,
                color = textColor
            )
        }

        TextField(
            modifier = Modifier.padding(
                start = if (trailingIcon != null) Design.dp.paddingS else 0.dp,
                end = if (leadingIcon != null) Design.dp.paddingS else 0.dp,
            ),
            provideText = { text },
            textStyle = Design.typography.button.copy(color = textColor)
        )

        if (trailingIcon != null) {
            Icon(
                modifier = Modifier.size(Design.dp.iconXS),
                imageVector = trailingIcon,
                color = textColor
            )
        }
    }
}

@Composable
public fun ButtonText(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    trailingIcon: ImageVector? = null,
    leadingIcon: ImageVector? = null,
    color: Color = Design.colors.content,
    textDecoration: TextDecoration = TextDecoration.Underline
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingXS),
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (leadingIcon != null) {
            Icon(
                modifier = Modifier.height(Design.dp.iconXS),
                imageVector = leadingIcon,
                color = color
            )
        }

        TextField(
            modifier = Modifier
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onClick
                ),
            provideText = { text },
            textStyle = Design.typography.textButton
                .copy(
                    color = color,
                    textDecoration = textDecoration
                )
        )

        if (trailingIcon != null) {
            Icon(
                modifier = Modifier.height(Design.dp.iconXS),
                imageVector = trailingIcon,
                color = color
            )
        }
    }
}