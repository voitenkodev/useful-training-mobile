package user

import UserRepository
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import user.repository.UserRepositoryImpl

public val userDataModule: Module = module {
    single { UserRepositoryImpl(get(), get()) } bind UserRepository::class
}