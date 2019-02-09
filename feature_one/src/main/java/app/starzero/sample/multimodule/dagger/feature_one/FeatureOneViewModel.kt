package app.starzero.sample.multimodule.dagger.feature_one

import androidx.lifecycle.ViewModel
import app.starzero.sample.multimodule.dagger.core.data.repository.SampleRepository
import javax.inject.Inject

class FeatureOneViewModel @Inject constructor(
    private val sampleRepository: SampleRepository
) : ViewModel() {
    fun getData() = sampleRepository.getData()
}
