package app.starzero.sample.multimodule.dagger

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import app.starzero.sample.multimodule.dagger.core.di.CoreComponentProvider
import app.starzero.sample.multimodule.dagger.databinding.ActivityMainBinding
import app.starzero.sample.multimodule.dagger.di.DaggerAppComponent
import app.starzero.sample.multimodule.dagger.feature_one.FeatureOneActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this

        val coreComponent =
            (application as? CoreComponentProvider)?.provideCoreComponent() ?: throw IllegalStateException()
        val component = DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
        component.inject(this)

        Log.d("MainActivity", viewModel.getData())
    }

    fun onClickFeatureOne(@Suppress("UNUSED_PARAMETER") view: View) {
        val intent = Intent(this, FeatureOneActivity::class.java)
        startActivity(intent)
    }
}
