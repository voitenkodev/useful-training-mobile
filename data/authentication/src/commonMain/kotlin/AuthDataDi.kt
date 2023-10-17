import org.koin.dsl.bind
import org.koin.dsl.module
import repository.AuthRepositoryImpl

val authDataDiModule = module {
    single { AuthRepositoryImpl(get(), get(), get()) } bind AuthRepository::class
}