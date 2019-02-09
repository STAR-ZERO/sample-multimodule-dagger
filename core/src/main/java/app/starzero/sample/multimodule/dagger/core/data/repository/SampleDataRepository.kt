package app.starzero.sample.multimodule.dagger.core.data.repository

import android.content.Context

class SampleDataRepository(
    private val context: Context
) : SampleRepository {
    override fun getData(): String {
        return context.packageName
    }
}
