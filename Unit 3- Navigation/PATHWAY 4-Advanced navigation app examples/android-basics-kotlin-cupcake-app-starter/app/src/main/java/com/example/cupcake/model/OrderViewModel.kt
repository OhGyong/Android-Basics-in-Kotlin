package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 데이터를 저장할 단일 ViewModel.
 */
class OrderViewModel : ViewModel() {

    /**
     * ViewModel 데이터는 public 변수로 노출하지 않는 것이 좋다.
     * 앱 데이터는 private로 외부 접근을 막고, 새로운 val public 변수를 생성한다.
     */
    private val _quantity = MutableLiveData<Int>(0) // 주문 수량
    val quantity: LiveData<Int> = _quantity

    private val _flavor = MutableLiveData<String>("") // 컵케이크 맛
    val flavor: LiveData<String> = _flavor

    private val _date = MutableLiveData<String>("") // 수령 날짜
    val date: LiveData<String> = _date

    private val _price = MutableLiveData<Double>(0.0) // 가격
    val price: LiveData<Double> = _price

    /**
     * setter 메서드는 뷰 모델 외부에서 호출되어야 하므로 public 메서드로 그대로 둔다.
     */
    fun setQuantity(numberCupcakes: Int) {
        _quantity.value = numberCupcakes
    }

    fun setFlavor(desiredFlavor: String) {
        _flavor.value = desiredFlavor
    }

    fun setDate(pickupDate: String) {
        _date.value = pickupDate
    }
}
