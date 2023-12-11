package searchexercise.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.inputs.InputSearch
import molecule.ButtonIconTransparent
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.Shadow
import molecule.TextH2
import resources.Icons

@Composable
internal fun Header(
    modifier: Modifier = Modifier,
    query: String,
    setQuery: (String) -> Unit,
    close: () -> Unit
) {
    Column(
        modifier = modifier
            .background(Design.colors.secondary)
            .statusBarsPadding()
    ) {

        PaddingS()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(Design.dp.componentL),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextH2(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { "Exercises" },
                softWrap = false
            )

            PaddingWeight()

            ButtonIconTransparent(
                imageVector = Icons.close,
                contentColor = Design.colors.content,
                onClick = close
            )
        }


        PaddingS()

        InputSearch(
            provideName = { query },
            update = setQuery,
        )

        PaddingM()

        Shadow()
    }
}