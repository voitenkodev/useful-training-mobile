import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import repository.ExerciseExamplesRepositoryImpl

public val exerciseExamplesDataDiModule: Module = module {
    single { ExerciseExamplesRepositoryImpl(get()) } bind ExerciseExamplesRepository::class
}