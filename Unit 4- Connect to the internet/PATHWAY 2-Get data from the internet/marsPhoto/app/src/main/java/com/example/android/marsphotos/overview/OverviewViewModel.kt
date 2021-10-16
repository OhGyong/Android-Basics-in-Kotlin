package com.example.android.marsphotos.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsphotos.network.MarsApi
import com.example.android.marsphotos.network.MarsPhoto
import kotlinx.coroutines.launch
import java.lang.Exception

enum class MarsApiStatus { LOADING, ERROR, DONE }

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<MarsApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<MarsApiStatus> = _status

    /**
     * MarsPhoto 객체를 저장할 수 있는 변수
     * 앱 데이터는 private로 외부 접근을 막고 새로운 val public 변수를 생성한다.
     * ViewModel 데이터는 public 변수로 노출하지 않는다.
     */
    private val _photos = MutableLiveData<List<MarsPhoto>>()
    val photos: LiveData<List<MarsPhoto>> = _photos

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    private fun getMarsPhotos() {

        // 코루틴 실행 함수.
        viewModelScope.launch {
            _status.value = MarsApiStatus.LOADING
            try{
                _photos.value = MarsApi.retrofitService.getPhotos() // 얻어온 첫 번째 화성 사진을 새 변수에 할당한다.
                _status.value = MarsApiStatus.DONE
            }catch (e: Exception){
                _status.value = MarsApiStatus.ERROR
                _photos.value = listOf()
            }

        }
    }
}
