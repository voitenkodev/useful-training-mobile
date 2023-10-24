package authentication

import AuthenticationRepository
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import authentication.repository.AuthenticationRepositoryImpl

public val authenticationDataModule: Module = module {
    single { AuthenticationRepositoryImpl(get(), get(), get()) } bind AuthenticationRepository::class
}