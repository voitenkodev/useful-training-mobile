package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Modifier as Modifier1


@Composable
public fun ShadowFooterSpace() {
    Spacer(modifier = Modifier.statusBarsPadding().height(Design.dp.paddingXL + Design.dp.componentM))
}

@Composable
public fun ShadowFooter(
    modifier: Modifier1 = Modifier1,
    primary: Pair<String, () -> Unit>? = null,
    close: () -> Unit
) {

    Box(modifier = modifier.height(IntrinsicSize.Min)) {

        BottomShadow(modifier = Modifier1.fillMaxSize())

        Column(modifier = Modifier1.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM, Alignment.End)
            ) {

                if (primary != null) {
                    ButtonPrimary(
                        modifier = Modifier1.width(Design.dp.componentXL),
                        text = primary.first,
                        onClick = primary.second
                    )
                }


                ButtonIconPrimary(
                    backgroundColor = Design.colors.secondary,
                    imageVector = Icons.close,
                    onClick = close
                )
            }

            Spacer(modifier = Modifier1.statusBarsPadding().height(Design.dp.paddingXL))
        }
    }
}