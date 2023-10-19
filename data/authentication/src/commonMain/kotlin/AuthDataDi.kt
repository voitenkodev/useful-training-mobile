import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import repository.AuthRepositoryImpl

public val authDataDiModule: Module = module {
    single { AuthRepositoryImpl(get(), get(), get()) } bind AuthRepository::class
}