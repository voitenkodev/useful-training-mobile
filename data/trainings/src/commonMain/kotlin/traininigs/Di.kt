package traininigs

import TrainingsRepository
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import traininigs.repository.TrainingsRepositoryImpl

public val trainingsDataModule: Module = module {
    single { TrainingsRepositoryImpl(get(), get()) } bind TrainingsRepository::class
}