package ui.training

import android.widget.Toast
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.flow.collectLatest
import presentation.TrainingContent
import ui.navigation.ScreenNavigator

@Composable
fun TrainingScreen(
    viewModel: TrainingViewModel
) {

    val context = LocalContext.current
    LaunchedEffect(key1 = Unit) {
        viewModel.error.collectLatest { value: String ->
            Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
        }
    }

    ScreenNavigator(event = viewModel.event)


    TrainingContent(
        modifier = Modifier.statusBarsPadding().navigationBarsPadding().imePadding(),
        save = viewModel::save
    )
}