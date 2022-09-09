package main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import datasource.AuthSource
import datasource.TrainingSource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import designsystem.common.DesignComponent
import designsystem.common.DesignTheme
import auth.AuthContent
import training.TrainingContent
import training.TrainingState

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DesignTheme {
                Surface(color = DesignComponent.colors.primary) {

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "auth") {
                        composable("auth") {
                            val authSource = AuthSource()
                            val scope = rememberCoroutineScope()
                            val context = LocalContext.current

                            LaunchedEffect(Unit) { if (authSource.isAuthorized) navController.navigate("training") }

                            AuthContent(
                                login = { email, password ->
                                    scope.launch {
                                        authSource.login(email, password)
                                            .onEach { navController.navigate("training") }
                                            .catch { Toast.makeText(context, "login - $it", Toast.LENGTH_LONG).show() }
                                            .launchIn(scope)
                                    }
                                },
                                registration = { email, password ->
                                    scope.launch {
                                        authSource.registration(email, password)
                                            .onEach { navController.navigate("training") }
                                            .catch { Toast.makeText(context, "registration - $it", Toast.LENGTH_LONG).show() }
                                            .launchIn(scope)
                                    }
                                }
                            )
                        }
                        composable("training") {
                            val authSource = AuthSource()
                            val trainingSource = TrainingSource()
                            val scope = rememberCoroutineScope()
                            val context = LocalContext.current

                            TrainingContent(
                                training = TrainingState.empty(0.0),
                                save = {
                                    scope.launch {
                                        trainingSource.writeTraining(authSource.user?.uid, it)
                                            .onEach { Toast.makeText(context, "save training - success", Toast.LENGTH_LONG).show() }
                                            .catch { Toast.makeText(context, "save training - $it", Toast.LENGTH_LONG).show() }
                                            .launchIn(this)
                                    }
                                },
                            )
                        }
                    }
                }
            }
        }
    }
}
