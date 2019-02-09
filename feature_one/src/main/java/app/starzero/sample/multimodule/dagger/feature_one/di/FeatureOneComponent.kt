package app.starzero.sample.multimodule.dagger.feature_one.di

import app.starzero.sample.multimodule.dagger.core.di.CoreComponent
import app.starzero.sample.multimodule.dagger.core.di.ViewModelModule
import app.starzero.sample.multimodule.dagger.core.di.scope.ModuleScope
import app.starzero.sample.multimodule.dagger.feature_one.FeatureOneActivity
import dagger.Component

@ModuleScope
@Component(
    modules = [
        FeatureOneModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface FeatureOneComponent {
    @Component.Builder
    interface Builder {
        fun build(): FeatureOneComponent
        fun coreComponent(coreComponent: CoreComponent): Builder
    }

    fun inject(activity: FeatureOneActivity)
}
