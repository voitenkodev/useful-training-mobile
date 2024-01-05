package data

import AuthenticationRepository
import ExerciseExamplesRepository
import MusclesRepository
import TrainingsRepository
import data.authentication.AuthenticationRepositoryImpl
import data.exerciseexamples.ExerciseExamplesRepositoryImpl
import data.muscles.MusclesRepositoryImpl
import data.statistics.StatisticsRepositoryImpl
import data.traininigs.TrainingsRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

public val dataModule: Module = module {
    single { AuthenticationRepositoryImpl(get(), get(), get(), get(), get()) } bind AuthenticationRepository::class
    single { ExerciseExamplesRepositoryImpl(get(), get()) } bind ExerciseExamplesRepository::class
    single { MusclesRepositoryImpl(get(), get()) } bind MusclesRepository::class
    single { StatisticsRepositoryImpl(get()) } bind StatisticsRepositoryImpl::class
    single { TrainingsRepositoryImpl(get(), get(), get()) } bind TrainingsRepository::class
}
