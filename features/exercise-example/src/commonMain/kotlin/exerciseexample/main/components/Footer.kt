package exerciseexample.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.overlay.BottomShadow
import molecule.ButtonIconPrimary
import molecule.ButtonPrimary
import resources.Icons

@Composable
internal fun Footer(
    modifier: Modifier = Modifier,
    exerciseExampleId: String?,
    primaryAction: (Pair<String, (id: String) -> Unit>)?,
    close: () -> Unit
) {
    Box(modifier = modifier.height(IntrinsicSize.Min)) {

        BottomShadow(modifier = Modifier.fillMaxSize())

        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM, Alignment.End)
            ) {

                if (primaryAction != null) {

                    ButtonPrimary(
                        modifier = Modifier.width(Design.dp.componentXL),
                        text = primaryAction.first,
                        onClick = { primaryAction.second.invoke(exerciseExampleId ?: return@ButtonPrimary) }
                    )
                }

                ButtonIconPrimary(
                    backgroundColor = Design.colors.secondary,
                    imageVector = Icons.close,
                    onClick = close
                )
            }

            Spacer(modifier = Modifier.statusBarsPadding().height(Design.dp.paddingXL))
        }
    }
}
