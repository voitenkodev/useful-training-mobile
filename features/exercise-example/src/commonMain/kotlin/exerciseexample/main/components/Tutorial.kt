package exerciseexample.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import atom.Design
import components.cards.HorizontalValueCard
import exerciseexample.main.models.Tutorial
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingS
import molecule.TextLabel
import resources.Icons

@Composable
internal fun Tutorial(
    tutorials: ImmutableList<Tutorial>,
    onClick: (Tutorial) -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
    ) {

        TextLabel(provideText = { "Tutorial" })

        PaddingS()

        tutorials.forEach {
            HorizontalValueCard(
                title = "[${it.language}] ${it.title}",
                description = "By \"${it.resource}\"",
                startIcon = it.imageVector to Color(0xffff0100),
                endIcon = Icons.arrowRight to Design.colors.content,
                onClick = { onClick.invoke(it) }
            )
        }
    }
}