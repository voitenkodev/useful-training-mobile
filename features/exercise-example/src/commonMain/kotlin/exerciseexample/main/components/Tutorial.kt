package exerciseexample.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.Design
import components.cards.HorizontalValueCard
import exercise.Tutorial
import kotlinx.collections.immutable.ImmutableList
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

        tutorials.forEach {
            HorizontalValueCard(
                title = "[${it.language}] ${it.title}",
                description = "By \"${it.author}\"",
                startIcon = it.icon,
                endIcon = Icons.arrowRight to Design.colors.content,
                onClick = { onClick.invoke(it) }
            )
        }
    }
}