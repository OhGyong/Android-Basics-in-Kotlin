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
 * OverviewViewModel에 상응하는 viewModel
 */
class OverviewViewModel : ViewModel() {

    /**
     * LiveData 속성을 사용하므로써 xml 파일에서 사용할 수 있게 한다.
     * 내부의 저장된 데이터의 값을 변경할 수 있도록 Mutable 속성으로 선언한 변수 _status
     * 외부에서 호출하여 사용할 변수 status
     */
    private val _status = MutableLiveData<MarsApiStatus>()
    val status: LiveData<MarsApiStatus> = _status
    // 같은 표현
//    val status: LiveData<MarsApiStatus>
//        get() = _status

    /**
     * MarsPhoto 객체를 저장할 수 있는 변수
     * 앱 데이터는 private로 외부 접근을 막고 새로운 val public 변수를 생성한다.
     */
    private val _photos = MutableLiveData<List<MarsPhoto>>()
    val photos: LiveData<List<MarsPhoto>> = _photos

    /**
     * 객체 인스턴스가 처음 생성되어 초기화 될 때 실행된다.
     * 초기 설정 코드를 배치하는 장소이다.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Mars API Retrofit 서버에서 가져온 데이터를 표시한다.
     * 자리 표시자 응답을 업데이트 한다.
     * 응답 데이터에 따른 LiveData를 업데이트한다.
     * [MarsPhoto] [List] [LiveData].
     */
    private fun getMarsPhotos() {

        // 코루틴 실행 함수.
        viewModelScope.launch {
            _status.value = MarsApiStatus.LOADING
            try{
                // 싱글톤 객체인 MarsApi의 retrofitService를 호출하면서 인터페이스로 정의한 MarsApiService를 호출.
                _photos.value = MarsApi.retrofitService.getPhotos()
                _status.value = MarsApiStatus.DONE
            }catch (e: Exception){
                _status.value = MarsApiStatus.ERROR
                _photos.value = listOf()
            }

        }
    }
}
