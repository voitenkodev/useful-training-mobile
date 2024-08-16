package authentication.register.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.Design
import components.BottomButtons
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingXS
import molecule.TextBody1
import molecule.TextH1
import user.ExperienceEnum
import user.component.ExperienceCard

@Composable
internal fun ExperiencePage(
    experiences: ImmutableList<ExperienceEnum>,
    experience: ExperienceEnum?,
    update: (ExperienceEnum) -> Unit,
    confirm: () -> Unit,
    back: () -> Unit,
) {


    Column(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {
            item(key = "header") {

                PaddingL()

                TextH1(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingL),
                    provideText = { "Experience" },
                )

                PaddingXS()

                TextBody1(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingL),
                    provideText = { "How experienced are you lifting weights?" },
                    color = Design.colors.label
                )

                PaddingM()
            }

            items(experiences) {
                ExperienceCard(
                    modifier = Modifier
                        .padding(horizontal = Design.dp.paddingL),
                    title = it.title,
                    description = it.description,
                    isSelected = experience == it,
                    onClick = { update.invoke(it) }
                )
            }
        }

        PaddingL()

        BottomButtons(
            modifier = Modifier.fillMaxWidth(),
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
