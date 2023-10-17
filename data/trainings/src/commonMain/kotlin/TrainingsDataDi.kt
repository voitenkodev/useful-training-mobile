import org.koin.dsl.bind
import org.koin.dsl.module
import repository.TrainingRepositoryImpl

val trainingsDataDiModule = module {
    single { TrainingRepositoryImpl(get(), get()) } bind TrainingRepository::class
}