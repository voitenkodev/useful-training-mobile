package data.traininigs

import TrainingsRepository
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import data.traininigs.repository.TrainingsRepositoryImpl

public val trainingsDataModule: Module = module {
    single { TrainingsRepositoryImpl(get(), get(), get()) } bind TrainingsRepository::class
}