package app.starzero.sample.multimodule.dagger.core.di

import androidx.lifecycle.ViewModelProvider
import app.starzero.sample.multimodule.dagger.core.util.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
