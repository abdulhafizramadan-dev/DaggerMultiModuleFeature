package com.gojek.daggermultimodulefeature.di

import com.gojek.core.di.CoreModule
import com.gojek.core.domain.repository.UserRepository
import com.gojek.daggermultimodulefeature.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [CoreModule::class])
@Singleton
interface ApplicationComponent {
    fun inject(activity: MainActivity)

    fun userRepository(): UserRepository
}