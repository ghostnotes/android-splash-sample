package co.ghostnotes.sample.splash.data.source

interface ApplicationSettingsDataSource {

    fun isTutorialDone(): Boolean
    fun setTutorialDone(done: Boolean)

}
