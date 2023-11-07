package authentication

import AuthenticationRepository
import authentication.repository.AuthenticationRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

public val authenticationDataModule: Module = module {
    single { AuthenticationRepositoryImpl(get(), get(), get(), get(), get()) } bind AuthenticationRepository::class
}