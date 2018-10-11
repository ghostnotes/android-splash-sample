package co.ghostnotes.sample.splash

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class LaunchViewModelFactory(private val launchDestinationProvider: LaunchDestinationProvider): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return LaunchViewModel(launchDestinationProvider) as T
    }

}