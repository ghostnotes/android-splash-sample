package co.ghostnotes.sample.splash

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import co.ghostnotes.sample.splash.data.source.ApplicationSettingsDataSource
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class LaunchViewModel(private val launchDestinationProvider: LaunchDestinationProvider): ViewModel() {

    companion object {
        private val TAG = LaunchViewModel::class.java.simpleName
    }

    private val disposables = CompositeDisposable()

    private val _launchDestination = MutableLiveData<LaunchDestination>()
    val launchDestination: LiveData<LaunchDestination>
        get() = _launchDestination

    override fun onCleared() {
        super.onCleared()

        disposables.clear()
    }

    fun checkLaunchDestination() {
        //_launchDestination.value = launchDestinationProvider.getLaunchDestination()
        checkLaunchDestinationWithSomethingHeavyProcess()
    }

    private fun checkLaunchDestinationWithSomethingHeavyProcess() {
        val disposable = Observable.just(true).delay(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::getLaunchDestination, this::onError)

        disposables.add(disposable)
    }

    private fun getLaunchDestination(flag: Boolean) {
        Log.d(TAG, "### flag: $flag")
        _launchDestination.value = launchDestinationProvider.getLaunchDestination()
    }

    private fun onError(e: Throwable) {
        Log.e(TAG, e.message, e)
    }

}