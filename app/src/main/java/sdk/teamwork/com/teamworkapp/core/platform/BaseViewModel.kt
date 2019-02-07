package sdk.teamwork.com.teamworkapp.core.platform

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import sdk.teamwork.com.teamworkapp.core.exception.Failure

abstract class BaseViewModel : ViewModel() {

    var failure: MutableLiveData<Failure> = MutableLiveData()

    fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }
}