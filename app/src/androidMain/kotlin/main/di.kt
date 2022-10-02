package main

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import data.repository.TrainingRepository
import data.source.AuthProtocol
import data.source.TrainingProtocol
import datasource.AuthSource
import datasource.TrainingSource
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.parameter.ParametersHolder
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import ui.auth.AuthViewModel
import ui.review.ReviewViewModel
import ui.training.TrainingViewModel
import ui.trainings.TrainingsViewModel

val appModule = module {
    single(named("IO")) { Dispatchers.IO }
    single(named("MAIN")) { Dispatchers.Main }

    single { AuthSource(FirebaseAuth.getInstance(), get(named("IO"))) } bind AuthProtocol::class
    single { TrainingSource(FirebaseFirestore.getInstance(), get(named("IO"))) } bind TrainingProtocol::class

    single { TrainingRepository(get(), get()) }

    viewModel { params: ParametersHolder -> TrainingViewModel(params.get(), get()) }
    viewModel { params: ParametersHolder -> ReviewViewModel(params.get()) }

    viewModelOf(::AuthViewModel)
    viewModelOf(::TrainingsViewModel)
}