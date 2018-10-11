package co.ghostnotes.sample.splash.ui

import android.content.Context
import android.content.Intent
import co.ghostnotes.sample.splash.ui.main.MainActivity
import co.ghostnotes.sample.splash.ui.tutorial.TutorialActivity

class Navigator() {

    fun startTutorial(context: Context) {
        val intent = Intent(context, TutorialActivity::class.java)
        context.startActivity(intent)
    }

    fun startMain(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }

}