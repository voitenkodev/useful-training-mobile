package data.muscles

import MusclesRepository
import data.muscles.repository.MusclesRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

public val musclesDataModule: Module = module {
    single { MusclesRepositoryImpl(get(), get()) } bind MusclesRepository::class
}