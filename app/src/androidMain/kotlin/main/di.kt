package main

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import datasource.AuthSource
import datasource.TrainingSource
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.parameter.ParametersHolder
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ui.auth.AuthViewModel
import ui.training.TrainingViewModel

val appModule = module {
    single(named("IO")) { Dispatchers.IO }
    single(named("MAIN")) { Dispatchers.Main }

    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }

    single { AuthSource(get(), get(named("IO"))) }
    single { TrainingSource(get(), get(named("IO"))) }

    viewModel { params: ParametersHolder -> TrainingViewModel(params.get(), get(), get()) }
    viewModelOf(::AuthViewModel)
}