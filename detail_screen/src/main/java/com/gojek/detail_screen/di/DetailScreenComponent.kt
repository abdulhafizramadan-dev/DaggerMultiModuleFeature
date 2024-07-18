package com.gojek.detail_screen.di

import com.gojek.daggermultimodulefeature.di.ApplicationComponent
import com.gojek.detail_screen.DetailScreenActivity
import dagger.Component

@DetailScreenScope
@Component(dependencies = [ApplicationComponent::class])
interface DetailScreenComponent {
    @Component.Factory
    interface Factory {
        fun create(component: ApplicationComponent): DetailScreenComponent
    }
    fun inject(activity: DetailScreenActivity)
}