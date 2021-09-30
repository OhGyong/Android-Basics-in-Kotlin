# PATHWAY 4: Advanced navigation app examples
[PATHWAY 4 사이트](https://developer.android.com/courses/pathways/android-basics-kotlin-unit-3-pathway-4)

## 1. Cupcake app introduction
이번 유닛에 배웠던 내용들을 종합적으로 합쳐 컵케이크에 관한 앱을 만들어본다.</br>
컵케이크 주문 과정이 있고, 사용자가 컵케이크 주문의 수량, 맛과 수령날짜를 선택할 수 있다.</br>
또한, 백 스택을 수정하는 방법도 배운다. 예를 들어 취소 버튼을 누르면 현재 주문을 취소하고 첫 화면으로 돌아가 새로운 주문을 하게한다.

## 2. Shared ViewModel
[Fragment간 ViewModel 공유하기](https://developer.android.com/codelabs/basic-android-kotlin-training-shared-viewmodel?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-3-pathway-4%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-shared-viewmodel#0)

이전 활동에서 Activity, Fragment, Intent, Data Binding, Jetpack Navigation Component, Architecture components의 사용 방법을 알아봤다.</br>
이번에는 위의 내용을 종합하고 Shared ViewModel을 사용하여 동일한 Activity의 Fragment 간에 데이터를 공유하는 방법 및 LiveData 변환과 같은 새로운 개념을 컵케이크 주문 앱을 개발해보면서 알아보자.


- `공유 ViewModel`</br>
    공유 ViewModel 구현은 UI 컨트롤러에서 ViewModel에 액세스하는 방식이다.</br>
    Fragment 인스턴스 대신 Activity 인스턴스를 사용하여 ViewModel을 여러 Fragment 간에 공유할 수 있다.</br>
    각 Fragment는 ViewModel에 액세스하여 데이터의 세부정화를 확인하거나 ViewModel의 일부 데이터를 업데이트 할 수 있다.

    공유 ViewModel을 사용하려면 viewModels() 대리자 클래스 대신 activityViewModels()를 사용하여 공유 ViewModel 파일을 초기화한다.
    - viewModels()는 현재 Fragment로 범위가 지정된 ViewModel 인스턴스를 제공한다. 따라서 인스턴스는 Fragment마다 다르다.
    - activityViewModels()는 현재 Activity로 범위가 지정된 ViewModel 인스턴스를 제공한다. 따라서 인스턴스는 동알한 Activity의 여러 Fragment 간에 동일하게 유지된다.

- `apply 범위 함수`</br>
    apply는 코틀린 표준 라이브러리의 범위 함수이다.</br>
    객체의 컨텍스트 내에서 코드 블록을 실행하며, 임시 범위를 형성한다. 그러면 해당 범위에서 이름을 사용하지 않고 객체에 액세스할 수 있다.</br>
    apply의 일반적인 사용 사례는 객체를 구성하는 것이다.

    ```kotlin
        clark.apply {
            firstName = "Clark"
            lastName = "James"
            age = 18
        }

        clark.firstName = "Clark"
        clark.lastName = "James"
        clark.age = 18
    ```

- `SimpleDateFormat, 안드로이드의 날짜 형식 지정`</br>
    안드로이드 프레임워크는 SimpleDateFormat이라는 클래스를 제공한다. 이 클래스를 통해 날짜의 형식(날짜 → 텍스트) 지정 및 파싱(텍스트 → 날짜)이 가능하다.</br>
    'A'부터 'Z'까지, 'a'부터 'z'까지의 문자는 날짜 또는 시간 문자열의 구성요소를 나타내는 패턴 문자로 해석된다.</br>
    예를 들어 2018년 1월 4일이면 패턴 문자열 "EEE, MMM d"는 "Wed, Jul 4"로 파싱된다.

- `Calendar.getInstance()`</br>
    시스템의 현재 날짜와 시간정보를 얻기 위한 Calendar 클래스의 getinstance() 메서드.

- `Calendar.add(Calendar.DATE, Int value)`</br>
    두번째 매개변수인 정수 값만큼 Calendar에 날짜를 더해준다.

- `elvis 연산자`</br>
    변수의 값이 null일 수 있을 때 elvis 연산자 '?:'를 사용하여 왼쪽의 표현식이 null이 아니면 이 값을 사용한다는 것을 의미한다.</br>
    반대로 null이면 오른쪽에 있는 표현식의 값을 사용한다.</br>
    ```kotlin
        /**
        * elvis 연산자 예시
        * null이 아니면 quantity.value를 사용, null이면 0을 사용
        */
        private fun updatePrice() {
            _price.value = (quantity.value ?: 0) * PRICE_PER_CUPCAKE
        }
    ```

- `binding 객체에 생명 주기 소유자 설정`</br>
    data binding을 사용하면 LiveData가 관찰 가능한 값이 변경되는 경우 binding 된 UI 요소가 자동으로 업데이트 된다.</br>
    LiveData가 관창 가능한 데이터를 파악하는 방법은 레이아웃 파일의 binding 표현식을 확인하는 것이다.</br>
    UI 요소가 자동으로 업데이트 되도록 하려면 binding.lifecycleOwnewr를 앱의 생명 주기 소유자와 연결해야 한다.</br>
    아래 방법을 통해 LiveData 객체를 관찰할 수 있다.
    ```kotlin
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
        }
    ```

- `Transformations.map()`</br>
    변환 함수 중 하나이며, LiveData 및 함수를 매개변수로 사용하여 LiveData 소스를 조작하고, 관찰할 수도 있는 업데이트된 값을 반환한다.</br>
    Transformations.map()를 사용하여 현지 통화를 사용할 수 있도록 가격 형식을 지정할 수 있다.

- `리스너 Binding을 통한 버튼 클릭 리스너를 레이아웃에 결합하기`</br>
    **9.리스너 Binding을 사용하여 클릭 리스너 설정**을 참고


https://user-images.githubusercontent.com/52282493/135451858-20a6e8ce-005f-4b67-85ee-404d89acd327.mp4