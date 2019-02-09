package app.starzero.sample.multimodule.dagger

import android.app.Application
import app.starzero.sample.multimodule.dagger.core.di.CoreComponent
import app.starzero.sample.multimodule.dagger.core.di.CoreComponentProvider
import app.starzero.sample.multimodule.dagger.core.di.CoreModule
import app.starzero.sample.multimodule.dagger.core.di.DaggerCoreComponent

class App : Application(), CoreComponentProvider {

    private val coreComponent by lazy {
        DaggerCoreComponent
            .builder()
            .coreModule(CoreModule(this))
            .build()
    }

    override fun provideCoreComponent(): CoreComponent {
        return coreComponent
    }
}