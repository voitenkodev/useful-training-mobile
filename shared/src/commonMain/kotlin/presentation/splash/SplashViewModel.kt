package presentation.splash

import Graph
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import data.source.datastore.DataStoreKeys
import globalKoin
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import navigation.NavigatorCore
import utils.ViewModel

internal class SplashViewModel(private val navigator: NavigatorCore) : ViewModel() {

    private val datastore = globalKoin().get<DataStore<Preferences>>()

    init {
        viewModelScope.launch {
            datastore.data
                .map { it[DataStoreKeys.KEY_TOKEN] }
                .onEach {
                    if (it == null) navigator.navigate(Graph.Auth.link, true)
                    else navigator.navigate(Graph.Trainings.link, true)
                }
                .launchIn(this)
        }
    }
}