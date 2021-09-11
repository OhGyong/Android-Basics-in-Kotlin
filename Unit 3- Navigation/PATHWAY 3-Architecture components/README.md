# PATHWAY 3: Architecture components
[PATHWAY 3 사이트](https://developer.android.com/courses/pathways/android-basics-kotlin-unit-3-pathway-3)


## 1. Unscramble app introduction
뷰 모델과 실시간 데이터와 같은 강력한 라이브러리를 사용해 앱 아키텍처나 디자인을 만들 것이다.</br>
앱 아키텍처가 견고한 앱은 확장하거나 유지하기가 쉽다.</br>
또한 아키텍처를 사용하면 Activity, Fragment의 생명 주기를 간단하게 관리할 수 있다.</br>
숙련된 안드로이드 개발자가 되기 위해서는 앱 아키텍처 권장사항을 따라야 한다.</br>
뷰 모델에 데이터를 저장하고 실시간 데이터에서 data binding을 사용하여 앱의 데이터 변경사항에 따라 UI를 업데이트 할 것이다.

## 2. Store data in ViewModel
[ViewModel에 데이터 저장하기](https://developer.android.com/codelabs/basic-android-kotlin-training-viewmodel?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-3-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-viewmodel#0)

- `Android Jetpack`</br>
    안드로이드 앱을 더 간편하게 개발하기 위해 활용할 수 있는 라이브러리 컬렉션이다.</br>
    이 라이브러리를 사용하면 권장사항을 따를 수 있고 상용구 코드를 작성하지 않아도 되며 복잡한 작업을 간소화 할 수 있다.

- `Android Architecture components`</br>
    Android Jetpack 라이브러리에 포함되어 있다. 효율적인 아키텍처로 앱을 디자인하는데 도움을 준다.</br>
    이것은 안드로이드의 권장사항으로, 앱 아키텍처를 안내하는 역할을 한다.

    **Android Architecture**의 기본 클래스 또는 구성요소
    - UI 컨트롤러</br>
        Activity와 Fragment는 UI 컨트롤러이다.</br>
        UI 컨트롤러는 화면에 뷰를 그리고 사용자가 상호작용하는 모든 UI 관련 동작을 캡처하여 UI를 제어한다.</br>
            
        앱의 데이터 또는 데이터에 관한 모든 의사 결정 로직은 UI 컨트롤러 클래스에 포함되어서는 안된다. 안드로이드 시스템은 특정 사용자 상호작용을 기반으로 또는 메모리 부족과 같은 시스템 조건으로 인해 언제든지 UI 컨트롤러가 제거될 수 있다. 이러한 이벤트는 개발자가 직접 제어할 수 없기 때문에, UI 컨트롤러에 앱 데이터나 상태를 저장해서는 안된다.</br>
        대신 데이터에 관한 로직을 ViewModel에 추가한다.

    - ViewModel</br>
        Modeld은 앱의 데이터 처리를 담당하는 구성요소로, 아키텍처 원칙에 따라 Model에서 UI가 도출되는 앱을 만들 수 있다.

        ViewModel은 뷰에 표시되는 앱 데이터의 Model이다. 안드로이드 프레임워크에서 Activity나 Fragment가 소멸되고 다시 생성될 때 폐기되지 않는 앱 관련 데이터를 저장한다.</br>
        ViewModel의 객체는 구성이 변경되는 동안 자동으로 유지되어 Activity 또는 Fragment의 인스턴스처럼 소멸되지 않고 데이터가 다음 Activity 또는 Fragment 인스턴스에 즉시 사용될 수 있다.

        앱에 ViewModel을 구현하려면 Architecture components 라이브러리에서 가져온 ViewModel 클래스를 확장하고 이 클래스 내에 앱 데이터를 저장한다.

        ![image](https://user-images.githubusercontent.com/52282493/132863148-679eea6f-2375-4b40-aa9e-2b8f6bedcab5.png)

    - LiveData</br>


    - Room</br>

- `ViewModel`</br>
    앱 데이터를 저장하기 위한 아키텍처의 구성요소 중 하나로 UI에 필요한 모든 데이터를 보유하고 처리한다.</br>
    저장된 데이터는 프레임워크에서 구성 변경이나 다른 이벤트 중에 Activity와 Fragment가 소멸되고 다시 생성되는 경우에도 손실되지 않는다.</br>
    이전에 데이터의 저장을 onSaveInstanceState()[https://github.com/OhGyong/Android-Kotlin-Basics-in-Kotlin/tree/master/Unit%203-%20Navigation/PATHWAY%201-Navigate%20between%20screens]로 했는데,</br>
    이 방법은 번들에 상태를 저장하는 추가 코드를 작성하고 이 상태를 검색하는 로직을 구현해야 한다. 또한 저장할 수 있는 데이터의 양이 적다.</br>
    Android Architecture components의 ViewModel을 통해 해결할 수 있다.</br>
    
    ![image](https://user-images.githubusercontent.com/52282493/132937127-017c178b-ae2f-4a53-8198-e7ed6ce41c76.png)

- `Model`</br>
    앱의 데이터 처리를 담당하는 구성요소.</br>
    앱의 Views 객체 및 앱 구성요소와 독립되어 있으므로 앱의 수명 주기 및 관련 문제의 영향을 받지 않는다.


- **Unscramble** 프로젝트</br>
    Unscrable 앱은 단어 맞추기 게임이다.</br>
    글자가 뒤섞인 단어를 하나씩 표시하여 해당 단어를 맞춰야한다. 단어를 맞히면 득점하고 틀리면 횟수 제한 없이 재시도 할 수 있다.</br>
    스킵으로 해당 단어를 건너뛸 수 있고, 왼쪽 상단에 몇 개의 단어가 남았는지 표시된다.

    - `by viewModels()`</br>
        viewModels의 대리자 클래스(속성 위임)

    - `Kotlin 속성 위임`</br>
        코틀린에는 변경 가능한 속성(var)에 자동으로 생성되는 기본 getter, setter 함수가 있다. 속성 값을 읽거나 값을 할당할 때 getter 및 setter 함수가 호출된다.</br>
        읽기 전용 속성(val)의 경우 기본적으로 getter 함수만 생성된다. 속성 값을 일을 떄 getter 함수가 호출된다.</br>
        코틀린에서 속성 위임을 사용하면 getter-setter 책임을 다른 클래스에 넘길 수 있다.</br>
        이 클래스는(대리자 클래스라고 한다.) 속성의 getter 및 setter 함수를 제공하고 변경사항을 처리한다.</br>
        대리자 속성은 다음과 같이 by절 및 대리자 클래스 인스턴스를 사용하여 정의된다.(var 사용 시 에러 발생)</br>

        ```kotlin
            // 앱에서 기본 GameViewModel 생성자를 사용하여 뷰 모델을 초기화하는 경우
            private val viewModel = GameViewModel()

            // 속성 위임 접근 방식을 사용하여 뷰 모델을 초기화
            private val viewModel: GameViewModel by viewModels()
        ```
        기기에서 구성이 변경되는 동안 앱이 viewModel 참조의 상태를 손실하게 된다.</br>
        이때 속성 위임 접근 방식을 사용해 viewModel 객체의 책임을 viewModels 라는 별도의 클래스에 위임한다.</br>
        즉, viewModel 객체에 액세스하면 이 객체는 대리자 클래스 viewModels에 의해 내부적으로 처리된다.</br>
        대리자 클래슨느 첫 번째 액세스 시 자동으로 viewModel 객체를 만들고 이 값을 구성 변경 중에도 유지했다가 요청이 있을 때 반환한다.

    - `지원 속성`</br>
        viewModel 내부에서는 데이터를 수정할 수 있어야 하므로 데이터는 private 및 var 이어야 한다.</br>
        viewModel 외부에서는 데이터를 읽을 수 있지만 수정할 수는 없어야 하므로 데이터는 public 및 val 이어야 한다. 이것을 구현하기 위해서 **지원 속성** 기능이 있다.</br>
        지원 속성을 사용하면 정확한 객체가 아닌 getter에서 무언가를 반환할 수 있다. 따라서 지원 속성을 구현하려면읽기 전용 버전의 데이터를 반환하도록 getter 메서드를 재정의한다.
        
        ```kotlin
            //지원 속성의 예

            /**
            * 수정 가능한 private mutable 변수 선언
            * 클래스 내에서 선언되어야 한다.
            /*
            private var _count = 0

            /*
            * public과 같은 전역으로 선언하고 getter 메서드를 재정의한다.
            * getter 메서드에 private 값을 반환한다.
            * count가 액세스 되면, get() 함수가 호출되고 _count 값을 반환한다.
            /*
            val count: Int
                get() = _count
        ```

        **ViewModel 클래스 내부**</br>
        - _count 속성이 private이며 값은 변경이 가능하다. 따라서 ViewModel 클래스 내에서만 액세스하고 수정할 수 있다. 이름은 private 속성 앞에 밑줄을 붙이는게 규칙이다.</br>

        **ViewModel 클래스 외부**</br>
        - count는 공개된 속성이며 UI 컨트롤러와 같은 다른 클래스에서 액세스 할 수 있다. get() 메서드만 재정의된다. 따라서 이 속성은 변경할 수 없으며 읽기 전용이다. 외부 클래스가 이 속성에 액세스하면 _count의 값을 반환하며, 이 값은 수정할 수 없다. 이에 따라 ViewModel에 있는 앱 데이터를 호출을 하면서도 안전을 보장할 수 있다.</br>

    - `init{}`</br>
        코틀린은 객체 인스턴스 초기화 중에 필요한 초기 설정 코드를 배치하는 장소로 이니셜라이저 블록(init 블록이라고도 함)을 제공한다.</br>
        이니셜라이저 블록에는 init 키워드 뒤에 중괄호 '{}'가 붙는다. 이 코드 블록은 객체 인스턴스가 처음 생성되어 초기화될 때 실행된다.

    - `CharArray.shuffle()`</br>
        배열의 요소들을 섞음.

    - `Array와 List의 차이`</br>
        Array는 List와 비슷하지만 초기화될 때 고정 크기를 가진다.</br>
        Array는 크기를 확장하거나 축소할 수 없다. 크기를 조절하려면 배열을 복사하여 처리해야한다.</br>
        반면, List에는 add() 함수와 remove() 함수가 있어 크기를 늘리고 줄일 수 있다.

    

## 3. Use LiveData with ViewModel