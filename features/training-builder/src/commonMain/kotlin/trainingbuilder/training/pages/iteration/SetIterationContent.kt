package trainingbuilder.training.pages.iteration

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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import kotlinx.coroutines.delay
import molecule.ButtonIconTransparent
import molecule.PaddingM
import molecule.Shadow
import molecule.TextH5
import molecule.secondaryBackground
import molecule.secondaryDefaultBackground
import resources.Icons
import trainingbuilder.training.models.BuildIteration
import trainingbuilder.training.models.IterationTargetFocus

@Composable
internal fun BoxScope.SetIterationContent(
    stateHolder: SetIterationStateHolder,
    save: (index: Int, buildIteration: BuildIteration) -> Unit,
    remove: () -> Unit,
    close: () -> Unit
) {

    val state by stateHolder.state.collectAsState()

    val focus = LocalFocusManager.current

    val innerClose = remember {
        {
            focus.clearFocus()
            close.invoke()
        }
    }

    ShadowBackground(
        modifier = Modifier.fillMaxSize(),
        condition = state.iterationIndex != -1,
        onClick = innerClose
    )

    if (state.iterationIndex != -1) {

        val weightRequester = remember { FocusRequester() }
        val repeatRequester = remember { FocusRequester() }

        LaunchedEffect(Unit) {
            delay(100)
            when (state.targetFocus) {
                IterationTargetFocus.Weight -> weightRequester.requestFocus()
                IterationTargetFocus.Repetition -> repeatRequester.requestFocus()
            }
        }

        val enabledSave = remember(state.buildIteration.weight, state.buildIteration.repetitions) {
            state.buildIteration.weight.isNotBlank() && state.buildIteration.repetitions.isNotBlank()
        }

        val interactionSource = remember { MutableInteractionSource() }

        val innerSave = remember {
            {
                focus.clearFocus()
                save.invoke(state.iterationIndex, state.buildIteration)
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

                TextH5(provideText = { "Set #${state.iterationIndex + 1}" })

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
                modifier = Modifier.imePadding().padding(horizontal = Design.dp.paddingS),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
            ) {

                ButtonIconTransparent(
                    modifier = Modifier.width(Design.dp.componentXS),
                    imageVector = Icons.delete,
                    onClick = innerRemove,
                    contentColor = Design.colors.red
                )

                InputWeight(
                    modifier = Modifier
                        .focusRequester(weightRequester)
                        .secondaryDefaultBackground()
                        .weight(0.56f),
                    provideValue = { state.buildIteration.weight },
                    onValueChange = stateHolder::updateWeight
                )

                InputRepeat(
                    modifier = Modifier
                        .focusRequester(repeatRequester)
                        .secondaryDefaultBackground()
                        .weight(0.44f),
                    provideValue = { state.buildIteration.repetitions },
                    onValueChange = stateHolder::updateRepeat
                )

                ButtonIconTransparent(
                    modifier = Modifier.width(Design.dp.componentXS),
                    imageVector = Icons.save,
                    enabled = enabledSave,
                    onClick = innerSave,
                    contentColor = if (enabledSave) Design.colors.green else Design.colors.white10
                )
            }

            PaddingM()
        }
    }
}