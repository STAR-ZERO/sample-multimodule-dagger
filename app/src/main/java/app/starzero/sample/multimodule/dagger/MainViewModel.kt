package app.starzero.sample.multimodule.dagger

import androidx.lifecycle.ViewModel
import app.starzero.sample.multimodule.dagger.core.data.repository.SampleRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val sampleRepository: SampleRepository
) : ViewModel() {
    fun getData() = sampleRepository.getData()
}