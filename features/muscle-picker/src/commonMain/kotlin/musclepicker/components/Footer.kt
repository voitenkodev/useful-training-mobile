package musclepicker.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.Shadow
import molecule.secondaryRoundBackground
import musclepicker.state.MuscleType
import platformBottomInset

@Composable
internal fun Footer(
    skip: () -> Unit,
    apply: () -> Unit,
    list: ImmutableList<MuscleType>
) {
    Column(modifier = Modifier.fillMaxWidth().secondaryRoundBackground()) {

        val selectedSum = remember(list) {
            list.sumOf { it.muscles.count { c -> c.isSelected } }
        }

        Shadow()

        Row(
            modifier = Modifier
                .padding(Design.dp.paddingM)
                .platformBottomInset(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            ButtonSecondary(
                modifier = Modifier.weight(1f),
                text = "Skip",
                onClick = skip
            )

            ButtonPrimary(
                modifier = Modifier.weight(1f),
                text = buildString {
                    append("Apply")
                    selectedSum.takeIf { it > 0 }?.let { append(" $it") }
                },
                enabled = selectedSum > 0,
                onClick = apply
            )
        }
    }
}