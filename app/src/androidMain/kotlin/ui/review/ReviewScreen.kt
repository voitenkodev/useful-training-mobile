package ui.review

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import presentation.ReviewContent
import ui.navigation.ScreenNavigator

@Composable
fun ReviewScreen(
    viewModel: ReviewViewModel,
) {

    ScreenNavigator(event = viewModel.event)

    ReviewContent(
        modifier = Modifier.statusBarsPadding().navigationBarsPadding(),
        remove = viewModel::remove,
    )
}