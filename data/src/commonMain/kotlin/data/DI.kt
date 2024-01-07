package data

import AuthenticationRepository
import EquipmentsRepository
import ExerciseExamplesRepository
import MusclesRepository
import StatisticsRepository
import TrainingsRepository
import data.authentication.AuthenticationRepositoryImpl
import data.equipments.EquipmentsRepositoryImpl
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
    single { EquipmentsRepositoryImpl(get(), get()) } bind EquipmentsRepository::class
    single { StatisticsRepositoryImpl(get()) } bind StatisticsRepository::class
    single { TrainingsRepositoryImpl(get(), get(), get()) } bind TrainingsRepository::class
}
