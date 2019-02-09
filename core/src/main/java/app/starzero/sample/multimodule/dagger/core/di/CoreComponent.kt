package app.starzero.sample.multimodule.dagger.core.di

import app.starzero.sample.multimodule.dagger.core.data.repository.SampleRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CoreModule::class
    ]
)
interface CoreComponent {
    @Component.Builder
    interface Builder {
        fun build(): CoreComponent
        fun coreModule(coreModule: CoreModule): Builder
    }

    fun sampleRepository(): SampleRepository
}
