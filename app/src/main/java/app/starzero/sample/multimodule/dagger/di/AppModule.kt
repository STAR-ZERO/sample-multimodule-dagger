package app.starzero.sample.multimodule.dagger.di

import androidx.lifecycle.ViewModel
import app.starzero.sample.multimodule.dagger.MainViewModel
import app.starzero.sample.multimodule.dagger.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}