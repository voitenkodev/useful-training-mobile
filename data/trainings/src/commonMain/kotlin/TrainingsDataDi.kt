import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import repository.TrainingRepositoryImpl

public val trainingsDataDiModule: Module = module {
    single { TrainingRepositoryImpl(get(), get()) } bind TrainingRepository::class
}