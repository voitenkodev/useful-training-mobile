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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import atom.Design
import components.inputs.InputRepeat
import components.inputs.InputWeight
import molecule.ButtonIconTransparent
import molecule.Shadow
import molecule.TextBody2
import molecule.secondaryBackground
import molecule.secondaryDefaultBackground

@Composable
internal fun SetIteration(
    modifier: Modifier = Modifier,
    number: Int,
    weight: String,
    repetitions: String,
    setWeight: (String) -> Unit,
    setRepeat: (String) -> Unit,
    remove: () -> Unit
) {

    val weightRequester = remember { FocusRequester() }
    val repeatRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) { weightRequester.requestFocus() }

    Column(modifier = modifier.fillMaxWidth().secondaryBackground()) {

        Shadow()

        Row(
            modifier = Modifier.padding(Design.dp.paddingM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
        ) {

            TextBody2(
                modifier = Modifier.width(46.dp),
                provideText = { "$number" },
                textAlign = TextAlign.Center,
                maxLines = 1
            )

            InputWeight(
                modifier = Modifier
                    .focusRequester(weightRequester)
                    .secondaryDefaultBackground()
                    .weight(0.60f),
                provideValue = { weight },
                onValueChange = setWeight
            )

            InputRepeat(
                modifier = Modifier
                    .focusRequester(repeatRequester)
                    .secondaryDefaultBackground()
                    .weight(0.4f),
                provideValue = { repetitions },
                onValueChange = setRepeat
            )

            ButtonIconTransparent(
                modifier = Modifier.width(46.dp),
                imageVector = Icons.remove,
                onClick = remove
            )
        }
    }
}