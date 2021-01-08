package com.cafebazaar.test.nearlocations.location.app.view.locationList

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cafebazaar.test.nearlocations.location.domain.model.LocationData
import com.cafebazaar.test.nearlocations.location.domain.usecase.GetLocationsUseCase
import com.cafebazaar.test.nearlocations.location.domain.usecase.InsertLocationsToDatabaseUseCase
import com.test.cleanArchRoomTest.utils.ext.addTo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LocationListViewModel @ViewModelInject constructor(
    private val getLocationsUseCase: GetLocationsUseCase,
    private val insertLocationsToDatabaseUseCase: InsertLocationsToDatabaseUseCase
) :
    ViewModel() {
    private val disposables = CompositeDisposable()

    private var _locations = MutableLiveData<List<LocationData>>()
    val locations: LiveData<List<LocationData>>
        get() = _locations

    private var _showProgress = MutableLiveData<Boolean>()
    val showProgress: LiveData<Boolean>
        get() = _showProgress


    private var _listIsEmpty = MutableLiveData(false)
    val listIsEmpty: LiveData<Boolean>
        get() = _listIsEmpty

    var errorMessage = MutableLiveData<String?>()

    fun getLocations(lat: Double?, lng: Double?) {
        if (locations.value.isNullOrEmpty()) {
            _showProgress.value = true
            errorMessage.value = null
            _locations.value = mutableListOf()
            _listIsEmpty.value = false
            getLocationsUseCase.getLocationsList(lat, lng)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    handleData(it)
                }
                .addTo(disposables)
        } else {
            _showProgress.value = false

        }

    }

    private fun handleData(it: GetLocationsUseCase.Result?) {
        when (it) {
            is GetLocationsUseCase.Result.Success -> {
                insertLocations(it.locations)
                _locations.value = it.locations
                _showProgress.value = false
                _listIsEmpty.value = it.locations.isEmpty()
            }
            is GetLocationsUseCase.Result.Failure -> {
                errorMessage.value = it.throwable.message!!
                _showProgress.value = false
            }
            is GetLocationsUseCase.Result.Loading -> _showProgress.value = false
        }
    }

    private fun insertLocations(data: List<LocationData>) {
        insertLocationsToDatabaseUseCase.insertLocations(data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
        disposables.dispose()
    }

}