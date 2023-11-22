package musclepicker

import androidx.compose.runtime.Composable
import io.github.xxfast.decompose.router.rememberOnRoute
import musclepicker.screen.MusclePickerContent
import musclepicker.screen.MusclePickerViewModel

@Composable
public fun MusclePickerFeature(
    toTraining: (List<String>) -> Unit
) {
    val vm = rememberOnRoute(MusclePickerViewModel::class) {
        MusclePickerViewModel()
    }

    MusclePickerContent(
        vm = vm,
        toTraining = toTraining
    )
}
