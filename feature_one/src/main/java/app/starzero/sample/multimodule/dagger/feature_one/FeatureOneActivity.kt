package app.starzero.sample.multimodule.dagger.feature_one

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import app.starzero.sample.multimodule.dagger.core.di.CoreComponentProvider
import app.starzero.sample.multimodule.dagger.feature_one.di.DaggerFeatureOneComponent
import javax.inject.Inject

class FeatureOneActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(FeatureOneViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_one)

        val coreComponent =
            (application as? CoreComponentProvider)?.provideCoreComponent() ?: throw IllegalStateException()
        val component = DaggerFeatureOneComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
        component.inject(this)

        Log.d("FeatureOneActivity", viewModel.getData())
    }
}