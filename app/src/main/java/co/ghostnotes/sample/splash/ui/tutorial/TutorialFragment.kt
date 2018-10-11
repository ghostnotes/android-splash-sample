package co.ghostnotes.sample.splash.ui.tutorial

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.ghostnotes.sample.splash.R

class TutorialFragment : Fragment() {

    companion object {
        fun newInstance() = TutorialFragment()
    }

    private lateinit var viewModel: TutorialViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.tutorial_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TutorialViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
