package main

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import data.repository.TrainingRepository
import data.source.AuthProtocol
import data.source.AuthSource
import data.source.TrainingProtocol
import data.source.TrainingSource
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModelOf
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

    viewModelOf(::ReviewViewModel)
    viewModelOf(::AuthViewModel)
    viewModelOf(::TrainingsViewModel)
    viewModelOf(::TrainingViewModel)
}