package ui.training

import android.widget.Toast
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import content.TrainingContent
import kotlinx.coroutines.flow.collectLatest
import ui.navigation.LocalNavigator
import ui.navigation.Router

@Composable
fun TrainingScreen(
    viewModel: TrainingViewModel, navigate: (Router) -> Unit
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.error.collectLatest { value: String ->
            Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
        }
    }

    val state = viewModel.trainingState.collectAsState()

    LocalNavigator(
        viewModel.event, navigate = navigate
    )

    TrainingContent(
        modifier = Modifier.statusBarsPadding().navigationBarsPadding(),
        state = state.value,
        update = viewModel::update,
        save = viewModel::save,
    )
}