# PATHWAY 1: Get user input in an app Part1
[PATHWAY 1 사이트](https://developer.android.com/courses/pathways/android-basics-kotlin-unit-2-pathway-1)

## 1. Welcome to Unit 2: Layout
1. 팁 계산기 앱 프로젝트
2. 일일 명언 앱 프로젝트

두 개의 프로젝트를 진행하면서 클래스, 상속, 목록, 배열 등 코틀린의 기능을 학습

## 2. Tip calculator app introduction
텍스트 입력란에 텍스트를 입력하거나 라디오 버튼을 선택하는 등의 사용자가 앱에 정보를 입력하게 하는 방법을 배움</br>
- 팁 계산기 앱
    - 팁을 얼마나 줘야 하는지 계산할 수 있는 앱으로 텍스트 입력란에 서비스 가격을 입력한다.</br>
    라디오 버튼에서 서비스 만족도를 선택하여 선택 항목에따라 팁은 20%, 18%, 15%로 측정하여 팁 금액을 표시한다.


## 3. Classes and inheritance in Kotlin
[코틀린의 클래스 및 상속 설명](https://developer.android.com/codelabs/basic-android-kotlin-training-classes-and-inheritance?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-classes-and-inheritance#0)

- `클래스 계층구조`
    - **채소라는 카테고리 속에서 콩류라는 좀 더 구체적인 카테고리를 나누기 위한 관계를 프로그래밍 측면에서 어떻게 할까?**</br>
        Vegetable이라는 클래스를 만들게 되면 Legume라는 클래스를 Vegetable 클래스의 하위 또는 서브 클래스로 만들 수 있다.</br>
        이렇게 되면, Vegetable 클래스의 모든 속성과 메서드가 Legume 클래스에 상속이 가능하다(사용이 가능하다).</br>
        ![image](https://user-images.githubusercontent.com/52282493/128620251-9d985148-4667-4d8b-a665-e966a931c6d9.png) </br>
        위 그림과 같이 Vegetable을 Legume 클래스의 상위 또는 슈퍼 클래스로 지칭한다.</br>
        하위 클래스인 Legume에서 또 다른 서브클래스를 만들어서 계층 구조를 더욱 확장할 수 있다.</br>
        예를 들면 콩류인 Lentil이나 Chickpea 클래스를 생성할 수 있다.</br>
        ![image](https://user-images.githubusercontent.com/52282493/128620306-f7942102-660d-44ba-bb1b-c1cef331a2be.png) </br>
        위 그림에서 Vegetable은 루트 또는 최상위 클래스라고 지칭한다.
    - **안드로이드에서의 클래스 상속은 어떻게 될까?**</br>
        Unit 1에서 진행했던 프로젝트를 보면 굳이 클래스를 사용하지 않고도 코드를 작성하여 진행할 수 있었다.</br>
        하지만 안드로이드의 여러 부분에서 Activity, View, ViewGroup 등 클래스 형태로 제공을 한다.</br>
        따라서 클래스 계층 구조를 이해하는 것은 안드로이드 앱 개발에 있어서 중요하며, 이를 토대로 안드로이드 프레임워크에서 제공하는 기능을 활용할 수 있다.</br>
        안드로이드에서 화면의 직사각형 영역에 그리기와 이벤트 처리를 담당하는 View 클래스가 있다고 생각해보자.</br>
        TextView 클래스는 View 클래스의 서브 클래스이므로 View의 클래스의 모든 속성과 기능을 상속받아 사용자에게 텍스트를 보여주는 특정 로직을 추가한다.</br>
        더 나아가 EditText와 Button 클래스는 TextView의 하위 클래스이다. 마찬가지로 TextView와 View 클래스의 모든 속성과 기능을 상속받아 로직을 추가할 수 있다.</br>
        각 클래스의 코드는 해당 요소에 맞는 부분에 중점을 둘 수 있다.</br>
        ![image](https://user-images.githubusercontent.com/52282493/128620589-d7be1192-ba3c-4d06-8efb-f1c8a2ef9043.png) <br>
        참고로 코틀린에는 모든 클래스에 공통 슈퍼 클래스인 Any가 존재한다.</br>
        ![image](https://user-images.githubusercontent.com/52282493/128620600-45831b40-7a24-4464-8f58-e518f1846646.png)
    
- `abstract(추상 클래스)`</br>
    완전히 구현되지 않아서 인스턴스화 할 수 없는 클래스. 스케치라고 생각하면 된다.</br>
    abstract로 클래스를 생성시 내부 변수에 값이 선언되지 않았다면 abstract를 붙여주어야 한다.</br>
    추상 함수 및 변수를 선언하는 것은 나중에 서브 클래스에서 값과 나머지 구현을 해야 한다는 약속이다.

- `private`</br>
    private 접근자가 표시된 변수는 내부 클래스에서만 사용할 수 있고, 프로그램의 다른 위치에서는 액세스할 수 없도록 막는다.

- `constructor(생성자)`</br>
    클래스에서 객체 인스턴스를 만들 때 호출된다. 호출이 되면 객체 인스턴스를 초기화한다.

- `override`</br>
    서브 클래스에서 override를 통해 상위 클래스에서 정의된 값을 재정의 할 것이라고 나타낸다.

- `with`</br>
    상속받은 변수에서 속성이나 함수를 참조할 때 '변수.~'을 사용하게 되는데 이러한 반복적 행위를 예방하여 코드를 단순화 할 수 있는 명령어이다.

- `open`</br>
    코틀린에서는 부모 클래스에 open을 붙여줘야 한다. 단, 추상 클래스에는 open을 쓰지 않아도 된다.

- `라이브러리`</br>
    프로그램이 사용할 수 있는 프로그램 외부에 정의된 함수 및 값의 사전 정의된 모음

- `kotlin.math.PI , kotlin.math.sqrt`</br>
    수학 라이브러리에서의 파이와 제곱근 함수

- `super`</br>
    상위 클래스에 정의된 함수를 호출 → super.'상위 클래스 함수명'

[계층구조 공부를 위해 작업한 코드](https://github.com/OhGyong/Android_Study/tree/master/Android%20Kotlin%20Basics%20in%20Kotlin/Unit%202-%20Layouts/PATHWAY%201-Get%20user%20input%20in%20an%20app%20Part1/PATHWAY1-3%20code)


## 4. Create XML layouts for Android
[팁 계산기 앱 xml 레이아웃 만들기](https://developer.android.com/codelabs/basic-android-kotlin-training-xml-layouts?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-xml-layouts#0)

- `XML`</br>
    XML은 확장성 마크업 언어를 의미하며 텍스트 기반 문서를 사용하여 데이터를 표현한다.</br>
    각 UI 요소는 XML 파일의 XML 요소로 표현되고 태그로 시작하고 끝난다(<>).

- `XML 요소, 속성`</br>
    '빈 요소 태그' 라고 하는 약식 표현과 요소를 채운 종료 태그는 같은 의미이다.</br>
    ```XML
        <!-- 약식 표현 -->
        <TextView />

        <!-- 요소를 채운 종료 태그 -->
        <TextView> </TextView>

    ```
- `androidx.constraintlayout.widget.ConstraintLayout`</br>
    ConstraintLayout이 안드로이드 플랫폼 이외에도 추가 기능을 제공하는 코드 라이브러리가 포함된 Android Jetpack의 일부이기 때문이다.</br>
    UI 구성요소가 'adroidx'로 시작하는 것은 Jetpack의 일부인 것을 알 수 있다.

- `Android Jetpack`</br>
    앱을 더 쉽게 빌드하는데 활용할 수 있는 유용한 기능이 집약된 라이브러리이다.

- `xmlns`</br>
    XML 네임스페이스를 나타내고 각 줄은 스키마 같은 속성의 어휘를 정의한다.

- `XML에서의 주석, <!-- -->`

- `<?xml version="1.0" encoding="utf-8"?>`</br>
    XML 선언부(Declaration)이다. 뒤에 나올 문서가 XML이라는 표시를 나타낸 것이다.

- `padding`</br>
    패딩은 여백과 비슷하지만 외부에 공간을 추가하는 대신 layout 내부에 공간을 추가한다.

- `constraintlayout 제약조건`</br>
    LTR(왼쪽에서 오른쪽) 또는 RTL(오른쪽에서 왼쪽) 언어에서 모두 작동할 수 있도록 제약 조건을 추가한다.

- `EditText의 속성`</br>
    inputType으로 text나 number로 지정, hint 사용

- `RadioGroup, RadioButton`</br>
    RadioGroup 내에서 RadioButton을 그룹화하여 버튼의 선택이 한 개만 적용이 되도록 설정해준다.</br>
    그룹화를 하지 않은 RadioButton은 개별 버튼으로 동작하게 된다.</br>
    RadioGroup은 orientation속성으로 vertical이나 horizontal으로 가로 세로 방향을 지정해야한다.

- `android:checkedButton`</br>
    RadioGroup에서 checkedButton 속성으로 RadioButton id를 부여하여 처음에 선택되어지도록 버튼을 지정할 수 있다.

- `Switch 버튼`</br>
    사용자에게 두 옵션 간에 전환을 할 수 있도록 한다.

- `0dp`</br>
    시스템에서 너비 또는 높이를 계산하지 않고 뷰에 적용된 제약 조건을 이치시켜준다.

## 5. Calculate the tip
[xml 레이아웃 만들기에서 생성한 UI에 사용할 수 있는 코틀린 코드 작성하기](https://developer.android.com/codelabs/basic-android-kotlin-training-tip-calculator?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-tip-calculator#0)

- `뷰 결합(View Binding)`</br>
    xml에서 작업한 view를 코드로 호출할 때 findViewById() 메서드를 사용하는데, 이러한 접근 방식은 앱에 뷰가 많아지고 UI들이 복잡해지면 매번 findViewById()를 사용하기 번거로워진다. 이것을 위해 build.gradle(.app)파일에
    ```gradle
    buildFeatures {
        viewBinding = true
    }
    ```
    를 추가하고 MainActivity 클래스에서 바인딩 객체를 한 번 만들고 초기화시켜서 사용한다.</br>
    ```kotlin
    lateinit var binding: ActivityMainBinding
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root) // 앱의 뷰 계층 구조 루트인 binding.root를 시작 레이아웃으로 지정
    ```

- `lateinit`</br>
    코드가 변수를 사용하기 전에 먼저 초기화할 것임을 확인해주는 키워드이다.</br>
    변수가 초기화가 될 때까지는 변수에 메모리가 할당되지 않으며, 변수를 초기화하지 않으면 앱이 강제 종료된다.

- `Double 데이터 유형`</br>
    앱에서 십진수를 사용하려면 Int 대신 Double을 사용해야 한다.</br>
    [코틀린의 숫자 데이터 유형 문서](https://kotlinlang.org/docs/basic-types.html#numbers)를 참고.

- `toDouble()`</br>
    코틀린에서 String을 Double로 변환하는 메서드

- `EditText 또는 TextView의 String을 숫자 data로 변환`</br>
    코틀린에서 TextView의 text 요소를 가져올때 '변수명'.text로 가져오게 되는데 이 상태에서 toDouble()을 사용할 수 없다.</br>
    .text로 가져온 데이터 타입이 Editable이기 때문에 toString()을 한 번더 호출해주어야 사용가능하다. → '변수명'.text.toString().toDouble()

- `kotlin.math.ceil`</br>
    코틀린에서 제공하는 반올림 함수

- `안드로이드에서의 숫자형식 지정 → NumberFormat.getCurrencyInstance()`</br>
    국가마다 서로 다른 통화(유통화폐)를 사용하게 되는데 안드로이드에서는 숫자를 통화 형식으로 지정하는 메서드를 제공한다.</br>
    사용자가 스마트폰에서 선택한 언어 및 기타 설정에 따라 시스템이 자동으로 통화 형식으로 지정한다.</br>
    NumberFormat.getCurrencyInstance()을 쓰면 숫자를 통화 형식으로 지정할 수 있다.

- `문자열 매개변수`</br>
    string.xml 파일에서 %s를 추가하고 코드에서 getString('string.xml의 name 값', '매개변수')로 사용하면 된다.
    ```XML
        <string name="tip_amount">Tip Amount: %s</string>
    ```

    ```kotlin
        val text = getString(R.string.tip_amount, 10)
    ```

- `Null`</br>
    값이 없음을 의미하는 특수 값

- `ToDoubleOrNull()`</br>
    toDouble()과 달리 null이 반환되는지 확인가능

- `return`</br>
    return 뒤에 아무 입력을 하지 않았다면 나머지 명령을 실행하지 않고 메서드를 종료하는 것을 의미

https://user-images.githubusercontent.com/52282493/129019448-378b5693-78ce-49d0-82bd-6e1aed85f60e.mp4