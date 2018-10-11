package co.ghostnotes.sample.splash

import co.ghostnotes.sample.splash.data.source.ApplicationSettingsDataSource

class LaunchDestinationProvider(private val applicationSettingsDataSource: ApplicationSettingsDataSource) {
    fun getLaunchDestination(): LaunchDestination {
        val isTutorialDone = applicationSettingsDataSource.isTutorialDone()
        return if (isTutorialDone) {
            LaunchDestination.MAIN
        } else {
            LaunchDestination.TUTORIAL
        }
    }
}
