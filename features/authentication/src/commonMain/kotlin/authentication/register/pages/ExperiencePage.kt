package authentication.register.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import authentication.register.models.ExperienceEnum
import components.ShadowFooter
import components.ShadowFooterSpace
import components.cards.HorizontalValueCard
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingM
import molecule.PaddingXL
import molecule.TextBody2
import molecule.TextH2

@Composable
internal fun ExperiencePage(
    experiences: ImmutableList<ExperienceEnum>,
    experience: ExperienceEnum?,
    update: (ExperienceEnum) -> Unit,
    confirm: () -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            PaddingM()

            TextH2(provideText = { "Experience" }, textAlign = TextAlign.Center)

            TextBody2(provideText = { "How experienced are you lifting weights?" }, textAlign = TextAlign.Center)

            PaddingXL()

            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(1f),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
                contentPadding = PaddingValues(vertical = Design.dp.paddingL)
            ) {
                items(experiences) {
                    HorizontalValueCard(
                        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                        title = it.title,
                        description = it.description,
                        startIcon = it.icon to Color.Transparent,
                        isSelected = experience == it,
                        onClick = { update.invoke(it) }
                    )
                }

                item("navigation_padding") {
                    ShadowFooterSpace()
                }
            }
        }

        ShadowFooter(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            primary = Triple("Continue", experience != null, confirm)
        )
    }
}
