package components

import Design
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import controls.ButtonSecondaryIcon
import platformInsets

@Composable
internal fun BoxScope.TrainingsControls(
    modifier: Modifier = Modifier,
    visibilityCondition: () -> Boolean = { true },
    addTraining: () -> Unit,
    logout: () -> Unit
) {

    val animatedDp by animateDpAsState(
        targetValue = if (visibilityCondition()) 0.dp else Design.dp.component + Design.dp.paddingL,
        animationSpec = tween(
            durationMillis = Design.duration.animDurationS,
        )
    )

   Column(
        modifier = modifier
            .platformInsets()
            .fillMaxHeight()
            .padding(Design.dp.paddingM)
            .align(Alignment.CenterEnd),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {


        ButtonSecondaryIcon(
            modifier = Modifier.offset(x = animatedDp),
            imageVector = Icons.Default.ExitToApp,
            onClick = logout
        )

        Spacer(modifier = Modifier.weight(1f))

        ButtonSecondaryIcon(
            modifier = Modifier.offset(x = animatedDp),
            imageVector = Icons.Default.Add,
            onClick = addTraining,
        )
    }
}

@Composable
internal fun BoxScope.ReviewControls(
    modifier: Modifier = Modifier,
    back: () -> Unit
) {

    Column(
        modifier = modifier
            .platformInsets()
            .fillMaxHeight()
            .padding(Design.dp.paddingM)
            .align(Alignment.CenterEnd),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {

        Spacer(modifier = Modifier.weight(1f))

        ButtonSecondaryIcon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            onClick = back
        )
    }
}