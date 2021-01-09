package com.cafebazaar.test.nearlocations.location.app.view.locationDetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cafebazaar.test.nearlocations.location.domain.model.LocationData
import com.cafebazaar.test.nearlocations.location.domain.usecase.GetLocationUseCase
import com.test.cleanArchRoomTest.utils.ext.addTo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class LocationDetailsViewModel @ViewModelInject constructor(
    private val getLocationUseCase: GetLocationUseCase
) : ViewModel() {
    private val disposables = CompositeDisposable()
    private var _location = MutableLiveData<LocationData>()
    val location: LiveData<LocationData>
        get() = _location

    var errorMessage = MutableLiveData<String?>()


    fun getEpisodeDetail(id: String) {
        getLocationUseCase.getLocation(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { handleData(it) }
            .addTo(disposables)
    }

    private fun handleData(it: GetLocationUseCase.Result?) {
        when (it) {
            is GetLocationUseCase.Result.Success -> {
                _location.value = it.locations

            }
            is GetLocationUseCase.Result.Failure -> errorMessage.value = it.throwable.message
        }
    }


    override fun onCleared() {
        disposables.clear()
    }
}
