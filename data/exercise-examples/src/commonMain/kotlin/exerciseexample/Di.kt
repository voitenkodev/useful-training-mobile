package exerciseexample

import ExerciseExamplesRepository
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import exerciseexample.repository.ExerciseExamplesRepositoryImpl

public val exerciseExamplesDataModule: Module = module {
    single { ExerciseExamplesRepositoryImpl(get()) } bind ExerciseExamplesRepository::class
}