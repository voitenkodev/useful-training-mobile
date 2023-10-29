package exerciseexample

import ExerciseExamplesRepository
import exerciseexample.repository.ExerciseExamplesRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

public val exerciseExamplesDataModule: Module = module {
    single { ExerciseExamplesRepositoryImpl(get()) } bind ExerciseExamplesRepository::class
}