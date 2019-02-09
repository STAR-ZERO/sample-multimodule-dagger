package app.starzero.sample.multimodule.dagger.di

import app.starzero.sample.multimodule.dagger.MainActivity
import app.starzero.sample.multimodule.dagger.core.di.CoreComponent
import app.starzero.sample.multimodule.dagger.core.di.ViewModelModule
import app.starzero.sample.multimodule.dagger.core.di.scope.ModuleScope
import dagger.Component

@ModuleScope
@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun coreComponent(coreComponent: CoreComponent): Builder
    }

    fun inject(activity: MainActivity)
}
