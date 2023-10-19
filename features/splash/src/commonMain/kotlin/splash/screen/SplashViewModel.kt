package splash.screen

import AuthRepository
import ViewModel
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import org.koin.core.component.inject

internal class SplashViewModel : ViewModel() {

    private val api by inject<AuthRepository>()
    fun checkToken(
        onAuth: () -> Unit,
        onNonAuth: () -> Unit
    ) = launch {
        if (api.getToken().firstOrNull() == null) onNonAuth.invoke()
        else onAuth.invoke()
    }
}