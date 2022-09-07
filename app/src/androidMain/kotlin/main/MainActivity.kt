package main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.rememberCoroutineScope
import datasource.Auth
import datasource.Store
import models.Training
import ui.designsystem.common.DesignComponent
import ui.designsystem.common.DesignTheme
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
                        save = {},
                        help = {}
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
