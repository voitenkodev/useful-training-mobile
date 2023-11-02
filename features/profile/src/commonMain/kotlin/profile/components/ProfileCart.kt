package profile.components

import Design
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import molecular.ButtonSmall
import molecular.PaddingM
import molecular.PaddingS
import molecular.PaddingXS
import molecular.TextBody2
import molecular.TextH2
import molecular.accentSecondaryDefaultBackground

@Composable
public fun ProfileCart(
    visibility: Boolean,
    onClose: () -> Unit
) {

    Column(
        modifier = Modifier
            .accentSecondaryDefaultBackground()
            .padding(vertical = Design.dp.paddingM, horizontal = Design.dp.paddingXL)
            .fillMaxWidth()
    ) {
        TextH2(
            provideText = { "Max Voitenko" },
            color = Design.colors.primary
        )

        PaddingS()

        TextBody2(
            provideText = { "weight: ${82}kg" },
            color = Design.colors.primary
        )

        PaddingXS()

        TextBody2(
            provideText = { "height: ${179}cm" },
            color = Design.colors.primary
        )

        PaddingM()

        ButtonSmall(
            text = "Update",
            onClick = {},
            backgroundColor = Design.colors.primary
        )
    }
}