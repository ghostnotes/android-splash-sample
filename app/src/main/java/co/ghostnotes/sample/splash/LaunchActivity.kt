package co.ghostnotes.sample.splash

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import co.ghostnotes.sample.splash.data.source.local.LocalApplicationSettingsDataSource
import co.ghostnotes.sample.splash.ui.Navigator

class LaunchActivity: AppCompatActivity(), LaunchContract.View {

    lateinit var navigator: Navigator
    private lateinit var viewModel: LaunchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        //setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

        // TODO Wanna use Dagger2 in the future.
        navigator = Navigator()
        val applicationSettingsDataSource = LocalApplicationSettingsDataSource(PreferenceManager.getDefaultSharedPreferences(applicationContext))
        val launchDestinationProvider = LaunchDestinationProvider(applicationSettingsDataSource)
        val viewModelFactory = LaunchViewModelFactory(launchDestinationProvider)

        //viewModel = ViewModelProviders.of(this).get(LaunchViewModel::class.java)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LaunchViewModel::class.java)
        viewModel.launchDestination.observe(this, LaunchDestinationObserver(this))

        viewModel.checkLaunchDestination()
    }

    override fun startTutorial() {
        navigator.startTutorial(this)
    }

    override fun startMain() {
        navigator.startMain(this)
    }

    internal class LaunchDestinationObserver(private val view: LaunchContract.View): Observer<LaunchDestination> {
        override fun onChanged(t: LaunchDestination?) {
            when (t) {
                LaunchDestination.TUTORIAL -> view.startTutorial()
                LaunchDestination.MAIN -> view.startMain()
            }

            view.finish()
        }
    }

}