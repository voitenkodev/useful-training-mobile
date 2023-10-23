import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import repository.ExercisesBundleRepositoryImpl

public val exercisesBundleDataDiModule: Module = module {
    single { ExercisesBundleRepositoryImpl(get()) } bind ExercisesBundleRepository::class
}