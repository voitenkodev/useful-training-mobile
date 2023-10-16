import org.koin.dsl.bind
import org.koin.dsl.module
import repository.AuthRepositoryImpl

val dataAuthenticationModule = module {
    single { AuthRepositoryImpl(get(), get(), get()) } bind AuthRepository::class
}