package splash

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.mp.KoinPlatformTools
import repository.AuthRepository
import utils.ViewModel

class SplashViewModel : ViewModel() {

    private val api = KoinPlatformTools.defaultContext().get().get<AuthRepository>()


    fun subscribeToken(
        onAuth: () -> Unit,
        onNonAuth: () -> Unit
    ) = viewModelScope.launch {
        api.getToken()
            .onEach {
                if (it == null) onNonAuth.invoke()
                else onAuth.invoke()
            }
            .launchIn(this)
    }
}