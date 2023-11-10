package statistics.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import atom.Design
import components.inputs.InputSearch
import icons.Filters
import icons.Notifications
import kotlinx.collections.immutable.ImmutableList
import molecule.IconPrimary
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.TextH2
import molecule.black30RoundBackground
import platformTopInset

@Composable
internal fun Header(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = Design.dp.paddingM)
            .platformTopInset()
    ) {

        PaddingS()

        Row(
            modifier = Modifier
                .height(Design.dp.componentM)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextH2(
                modifier = Modifier,
                provideText = { "Statistics" },
                softWrap = false
            )

            PaddingWeight()

            IconPrimary(
                imageVector = Filters,
            )

        }

        PaddingS()
    }
}