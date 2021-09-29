package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*


// 컵케이크 한 개 가격
private const val PRICE_PER_CUPCAKE = 2.00

// 당일 수령 시 추가 요금 청구
private const val PRICE_FOR_SAME_DAY_PICKUP = 3.00

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
    val price: LiveData<String> = Transformations.map(_price){
        NumberFormat.getCurrencyInstance().format(it) // Transformations.map()을 사용하여 $와 같은 통화 기호가 있는 문자열로 데이터를 지정한다.
    }


    val dateOptions = getPickupOptions()

    /**
     * setter 메서드는 뷰 모델 외부에서 호출되어야 하므로 public 메서드로 그대로 둔다.
     */
    fun setQuantity(numberCupcakes: Int) {
        _quantity.value = numberCupcakes
        updatePrice()
    }

    fun setFlavor(desiredFlavor: String) {
        _flavor.value = desiredFlavor
    }

    fun setDate(pickupDate: String) {
        _date.value = pickupDate
        updatePrice()
    }

    /**
     * 객체 인스턴스가 생성될 때 실행되는 함수.
     */
    init {
        resetOrder() // 객체 인스턴스가 실행될 때 resetOrder() 메서드를 호출하여 data를 초기화 시킨다.
    }


    /**
     * 주문의 맛이 설정되었는지 여부를 확인하는 메서드
     */
    fun hasNoFlavorSet(): Boolean {
        return _flavor.value.isNullOrEmpty()
    }


    /**
     * 수령 날짜 목록을 만들고 반환하는 메서드
     */
    private fun getPickupOptions(): List<String> {
        val options = mutableListOf<String>()

        // 형식 지정 문자열을 만들어 날짜 정보를 저장
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())

        // 현재 날짜 및 시간이 포함된 변수
        val calender = Calendar.getInstance()

        // 현재 날짜 및 다음 세 날짜로 시작하는 날짜 목록 생성
        repeat(4) {
            options.add(formatter.format(calender.time))
            calender.add(Calendar.DATE, 1)
        }

        return options
    }


    /**
     * 가격을 계산하는 메서드
     */
    private fun updatePrice() {
        var calculatedPrice = (quantity.value ?:0) * PRICE_PER_CUPCAKE

        // 당일 계산일 경우 추가요금
        if (dateOptions[0] == date.value) {
            calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
        }
        _price.value = calculatedPrice
    }


    /**
     * MutableLiveData 속성을 재설정하는 메서드.
     */
    fun resetOrder() {
        _quantity.value = 0
        _flavor.value = ""
        _date.value = dateOptions[0]
        _price.value = 0.0
    }
}
