package app.starzero.sample.multimodule.dagger.core.di

import android.content.Context
import app.starzero.sample.multimodule.dagger.core.data.repository.SampleDataRepository
import app.starzero.sample.multimodule.dagger.core.data.repository.SampleRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule(
    private val context: Context
) {

    @Singleton
    @Provides
    fun provideSampleRepository(): SampleRepository {
        return SampleDataRepository(context)
    }
}