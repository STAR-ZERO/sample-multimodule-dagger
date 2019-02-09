package app.starzero.sample.multimodule.dagger.feature_one.di

import androidx.lifecycle.ViewModel
import app.starzero.sample.multimodule.dagger.core.di.ViewModelKey
import app.starzero.sample.multimodule.dagger.feature_one.FeatureOneViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FeatureOneModule {

    @Binds
    @IntoMap
    @ViewModelKey(FeatureOneViewModel::class)
    abstract fun bindFeatureOneViewModel(viewModel: FeatureOneViewModel): ViewModel
}
