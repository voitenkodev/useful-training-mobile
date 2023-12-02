package trainingbuilder.builder.popups.components

import Icons
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import atom.Design
import components.inputs.InputRepeat
import components.inputs.InputWeight
import molecule.ButtonIconTransparent
import molecule.PaddingM
import molecule.Shadow
import molecule.TextH4
import molecule.secondaryBackground
import molecule.secondaryDefaultBackground
import trainingbuilder.builder.state.Iteration

@Composable
internal fun SetIteration(
    modifier: Modifier = Modifier,
    index: Int,
    iteration: Iteration?,
    save: (index: Int, iteration: Iteration) -> Unit,
    remove: () -> Unit
) {

    val innerIteration = remember(iteration) { mutableStateOf(iteration ?: Iteration()) }

    val updateWeight = remember {
        { value: String ->
            innerIteration.value = innerIteration.value.copy(weight = value)
        }
    }

    val updateRepeat = remember {
        { value: String ->
            innerIteration.value = innerIteration.value.copy(repetitions = value)
        }
    }

    val weightRequester = remember { FocusRequester() }
    val repeatRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) { weightRequester.requestFocus() }

    val enabledSave = remember(
        innerIteration.value.weight,
        innerIteration.value.repetitions
    ) {
        innerIteration.value.weight.isNotBlank() && innerIteration.value.repetitions.isNotBlank()
    }


    Column(modifier = modifier.fillMaxWidth().secondaryBackground()) {

        Shadow()

        PaddingM()

        TextH4(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            provideText = { "Iteration #${index + 1}" }
        )

        Row(
            modifier = Modifier.padding(Design.dp.paddingM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {

            ButtonIconTransparent(
                modifier = Modifier.width(46.dp),
                imageVector = Icons.delete,
                onClick = remove,
                contentColor = Design.colors.red
            )

            InputWeight(
                modifier = Modifier
                    .focusRequester(weightRequester)
                    .secondaryDefaultBackground()
                    .weight(0.60f),
                provideValue = { innerIteration.value.weight },
                onValueChange = updateWeight
            )

            InputRepeat(
                modifier = Modifier
                    .focusRequester(repeatRequester)
                    .secondaryDefaultBackground()
                    .weight(0.4f),
                provideValue = { innerIteration.value.repetitions },
                onValueChange = updateRepeat
            )

            ButtonIconTransparent(
                modifier = Modifier.width(46.dp),
                imageVector = Icons.save,
                enabled = enabledSave,
                onClick = { save.invoke(index, innerIteration.value) },
                contentColor = if (enabledSave) Design.colors.toxic else Design.colors.white10
            )
        }
    }
}