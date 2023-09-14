package splash

import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import org.koin.mp.KoinPlatformTools
import repository.AuthRepository
import utils.ViewModel

class SplashViewModel : ViewModel() {

    private val api = KoinPlatformTools.defaultContext().get().get<AuthRepository>()

    fun checkToken(
        onAuth: () -> Unit,
        onNonAuth: () -> Unit
    ) = viewModelScope.launch {
        if (api.getToken().firstOrNull() == null) onNonAuth.invoke()
        else onAuth.invoke()
    }
}