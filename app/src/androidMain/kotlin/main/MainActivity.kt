package main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.rememberCoroutineScope
import co.touchlab.kermit.Logger
import datasource.Auth
import datasource.Store
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import models.Training
import ui.designsystem.DesignComponent
import ui.designsystem.common.DesignTheme
import ui.screens.AuthScreen
import ui.screens.TrainingScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DesignTheme {
                Surface(color = DesignComponent.colors.primary) {
                    val auth = Auth()
                    val store = Store()
                    val scope = rememberCoroutineScope()

                    TrainingScreen(
                        training = Training.empty(store.createId()),
                        createId = { store.createId() },
                        save = {}
                    )

//                    AuthScreen(
//                        login = { email, password ->
//                            scope.launch {
//                                auth.login(email, password)
//                                    .onEach { Logger.i("success -> $it") }
//                                    .catch { Logger.i("error -> $it") }
//                                    .launchIn(scope)
//                            }
//                        },
//                        registration = { email, password ->
//                            scope.launch {
//                                auth.registration(email, password)
//                                    .onEach { Logger.i("success -> $it") }
//                                    .catch { Logger.i("error -> $it") }
//                                    .launchIn(scope)
//                            }
//                        }
//                    )
                }
            }
        }
    }
}
