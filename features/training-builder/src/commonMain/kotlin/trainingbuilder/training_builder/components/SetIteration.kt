package trainingbuilder.training_builder.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import atom.Design
import components.inputs.InputRepeat
import components.inputs.InputWeight
import components.overlay.ShadowBackground
import molecule.ButtonIconTransparent
import molecule.PaddingM
import molecule.Shadow
import molecule.TextH4
import molecule.secondaryBackground
import molecule.secondaryDefaultBackground
import resources.Icons
import trainingbuilder.training_builder.state.Iteration
import trainingbuilder.training_builder.state.IterationTargetFocus

@Composable
internal fun BoxScope.SetIteration(
    visible: Boolean,
    index: Int,
    targetFocus: IterationTargetFocus,
    iteration: Iteration?,
    save: (index: Int, iteration: Iteration) -> Unit,
    remove: () -> Unit,
    close: () -> Unit
) {

    val focus = LocalFocusManager.current

    val innerClose = remember {
        {
            focus.clearFocus()
            close.invoke()
        }
    }

    ShadowBackground(
        modifier = Modifier.fillMaxSize(),
        condition = visible,
        onClick = innerClose
    )

    if (visible) {
        val innerIteration = remember(iteration) { mutableStateOf(iteration ?: Iteration()) }

        val updateWeight = remember {
            { value: String -> innerIteration.value = innerIteration.value.copy(weight = value) }
        }

        val updateRepeat = remember {
            { value: String -> innerIteration.value = innerIteration.value.copy(repetitions = value) }
        }

        val weightRequester = remember { FocusRequester() }
        val repeatRequester = remember { FocusRequester() }

        LaunchedEffect(Unit) {
            when (targetFocus) {
                IterationTargetFocus.Weight -> weightRequester.requestFocus()
                IterationTargetFocus.Repetition -> repeatRequester.requestFocus()
            }
        }

        val enabledSave = remember(innerIteration.value.weight, innerIteration.value.repetitions) {
            innerIteration.value.weight.isNotBlank() && innerIteration.value.repetitions.isNotBlank()
        }

        val interactionSource = remember { MutableInteractionSource() }

        val innerSave = remember {
            {
                focus.clearFocus()
                save.invoke(index, innerIteration.value)
            }
        }

        val innerRemove = remember {
            {
                focus.clearFocus()
                remove.invoke()
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .secondaryBackground()
                .navigationBarsPadding()
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = {} // solution for avoid click under background (to hide this section)
                ).align(Alignment.BottomCenter)
        ) {

            Shadow()

            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .padding(start = Design.dp.paddingM)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextH4(provideText = { "Set #${index + 1}" })

                ButtonIconTransparent(
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                        .padding(Design.dp.paddingS),
                    imageVector = Icons.close,
                    onClick = innerClose
                )
            }

            Row(
                modifier = Modifier.padding(horizontal = Design.dp.paddingS),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
            ) {

                ButtonIconTransparent(
                    modifier = Modifier.width(Design.dp.componentS),
                    imageVector = Icons.delete,
                    onClick = innerRemove,
                    contentColor = Design.colors.red
                )

                InputWeight(
                    modifier = Modifier
                        .focusRequester(weightRequester)
                        .secondaryDefaultBackground()
                        .weight(0.56f),
                    provideValue = { innerIteration.value.weight },
                    onValueChange = updateWeight
                )

                InputRepeat(
                    modifier = Modifier
                        .focusRequester(repeatRequester)
                        .secondaryDefaultBackground()
                        .weight(0.44f),
                    provideValue = { innerIteration.value.repetitions },
                    onValueChange = updateRepeat
                )

                ButtonIconTransparent(
                    modifier = Modifier.width(Design.dp.componentS),
                    imageVector = Icons.save,
                    enabled = enabledSave,
                    onClick = innerSave,
                    contentColor = if (enabledSave) Design.colors.toxic else Design.colors.white10
                )
            }

            PaddingM()
        }
    }
}