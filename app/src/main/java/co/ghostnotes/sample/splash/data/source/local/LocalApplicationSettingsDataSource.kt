package co.ghostnotes.sample.splash.data.source.local

import android.content.SharedPreferences
import co.ghostnotes.sample.splash.data.source.ApplicationSettingsDataSource

class LocalApplicationSettingsDataSource(private val sharedPreferences: SharedPreferences): ApplicationSettingsDataSource {

    companion object {
        private const val BASE_PREF_KEY = "co.ghostnotes.sample.splash."

        private const val PREF_KEY_IS_TUTORIAL_DONE = BASE_PREF_KEY + "PREF_KEY_IS_TUTORIAL_DONE"
    }

    override fun isTutorialDone(): Boolean {
        return sharedPreferences.getBoolean(PREF_KEY_IS_TUTORIAL_DONE, false)
    }

    override fun setTutorialDone(done: Boolean) {
        sharedPreferences.edit().putBoolean(PREF_KEY_IS_TUTORIAL_DONE, done).apply()
    }


}