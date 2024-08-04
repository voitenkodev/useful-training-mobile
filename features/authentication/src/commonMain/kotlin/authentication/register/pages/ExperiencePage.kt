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
import components.ShadowBottomButtons
import components.ShadowFooterSpace
import components.cards.HorizontalValueCard
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingL
import molecule.PaddingXL
import molecule.PaddingXS
import molecule.Shadow
import molecule.TextBody2
import molecule.TextH2
import user.ExperienceEnum

@Composable
internal fun ExperiencePage(
    experiences: ImmutableList<ExperienceEnum>,
    experience: ExperienceEnum?,
    update: (ExperienceEnum) -> Unit,
    confirm: () -> Unit,
    back: () -> Unit,
) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            PaddingL()

            TextH2(provideText = { "Experience" }, textAlign = TextAlign.Center)

            PaddingXS()

            TextBody2(
                provideText = { "How experienced are you lifting weights?" },
                textAlign = TextAlign.Center,
                color = Design.colors.caption
            )

            PaddingXL()

            Shadow()

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

        ShadowBottomButtons(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            first = {
                ButtonSecondary(
                    modifier = Modifier.weight(1f),
                    text = "Back",
                    onClick = back
                )
            },
            second = {
                ButtonPrimary(
                    modifier = Modifier.weight(1f),
                    text = "Next",
                    onClick = confirm,
                    enabled = experience != null
                )
            }
        )
    }
}
