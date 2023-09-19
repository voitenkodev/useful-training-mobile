package splash

import decompose.ViewModel
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import org.koin.mp.KoinPlatformTools
import repository.AuthRepository

class SplashViewModel : ViewModel() {

    private val api = KoinPlatformTools.defaultContext().get().get<AuthRepository>()

    fun checkToken(
        onAuth: () -> Unit,
        onNonAuth: () -> Unit
    ) = launch {
        if (api.getToken().firstOrNull() == null) onNonAuth.invoke()
        else onAuth.invoke()
    }
}