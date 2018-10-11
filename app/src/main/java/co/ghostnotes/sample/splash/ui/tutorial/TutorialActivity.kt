package co.ghostnotes.sample.splash.ui.tutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.ghostnotes.sample.splash.R

class TutorialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tutorial_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, TutorialFragment.newInstance())
                    .commitNow()
        }
    }

}
