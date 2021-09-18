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

    - `Dialog(대화상자)`</br>
        대화상자는 사용자에게 결정을 내리거나 추가 정보를 입력하라는 메시지를 표시하는 작은 창이다.(Web에서의 모달 or 팝업?)</br>

        ![image](https://user-images.githubusercontent.com/52282493/132944414-76ca1404-7d36-4466-b9aa-19d6d64595e0.png) </br>
        1. 알림 대화상자
        2. 제목(선택사항)
        3. 메시지
        4. 텍스트 버튼

    - `MaterialAlertDialogBuilder`</br>
        **MaterialAlertDialog**를 만들기 위해서는 MaterialAlertDialogBuilder 클래스를 사용하여 대화상자의 구성요소를 단계별로 빌드해야한다.</br>
        Fragment의 requireContext() 메서드를 사용하여 콘텐츠를 전달하는 MaterialAlertDialogBuilder 생성자를 호출한다.

        ```kotlin
            // 예시
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.congratulations)) // 대화상자의 제목 설정
                .setMessage(getString(R.string.you_scored, viewModel.score)) // 대화상자의 메시지 설정
                .setCancelable(false) // 뒤로 키를 눌러 대화상자를 취소할 수 없도록 설정
                .setNegativeButton(getString(R.string.exit)){_, _ ->
                    exitGame() // 대화상자의 취소 버튼
                }
                .setPositiveButton(getString(R.string.play_again)){_, _->
                    restartGame() // 대화상자의 확인 버튼
                }
                .show() // 대화상자를 만들고 표시하는 기능
        ```

    - `후행 람다 구문(high-order functions and lambadas)`</br>
        함수에서 전달되는 마지막 인수가 함수이면 괄호 바깥에 람다 표현식을 배치할 수 있는 것을 말한다.</br>

        ```kotlin
            //예시
                .setNegativeButton(getString(R.string.exit)) { _, _ ->
                    exitGame()
        ```
    }

    - `Material Text Field를 사용하여 오류 메시지 추가하기`


    

## 3. Use LiveData with ViewModel
[ViewModel과 함꼐 LiveData 사용하기](https://developer.android.com/codelabs/basic-android-kotlin-training-livedata?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-3-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-livedata#0)

- `LiveData`</br>
    수명 주기를 인식하는 식별 가능한 데이터 홀더 클래스이다. 다음은 LiveData의 특성이다.</br>
    - LiveData는 데이터를 보유한다. 모든 유형의 데이터에 사용할 수 있는 wrapper이다.
    - LiveData는 관찰 가능하다. 즉, LiveData 객체에서 보유한 데이터가 변경되면 UI에 알림이 제공된다.
    - LiveData는 생명 주기를 인식한다. LiveData에 UI를 연결하면 UI는 LifecycleOwner(Activity 또는 Fragment)와 연결된다. LiveData는 STARTED 또는 RESUMED와 같은 Activty 생명 주기 상태인 UI만 업데이트 한다.

- `MutableLiveData<>()`</br>
    변경 가능한 버전의 LiveData로 내부에 저장된 데이터의 값을 변경할 수 있다.</br>
    LiveDta 및 MutableLiveData는 일반 클래스이므로 이러한 클래스에 보유되는 데이터의 유형을 지정해야 한다.</br>

    LiveData 객체 내의 데이터에 액세스하려면 value 속성을 사용한다.</br>
    ``` kotlin
        // 예시
        _currentScrambledWord.value = String(tempWord)
    ```

- `LiveData 객체에 UI 연결하기`</br>
    LiveData는 생명 주기를 인식한다. 즉, Activity 생명 주기 상태인 UI만 업데이트한다.</br>
    Fragment의 UI는 'STARTED' 또는 'RESUMED' 상태인 경우에만 알림을 받는다.

    - `observe()`</br>
        LiveData의 메서드로 LiveData의 UI를 연결할 때 사용한다.</br>
        첫번쨰 매개변수로는 viewLifecycleOwner를 사용하고 두번째 매개변수로는 데이터를 넣는다.(데이터는 람다식으로 표현할 수 있음)

    - `viewLifecycleOwner`</br>
        Fragment의 뷰 생명 주기를 나타낸다. observe() 메서드의 매개변수로 사용한다.</br>
        observe()의 매개변수로 사용하였을 때, LiveData가 Fragment 생명 주기를 인식하고 Fragment가 활성 상태(STARTED 또는 RESUMED)일 때 UI에 알릴 수 있다.

- `plus()`</br>
    코틀린 함수로 값을 1 증가시킨다.

- `inc()`</br>
    null에 값을 안전하게 1씩 증가시킨다.

- `data binding과 LiveData 사용하기`</br>
    data binding을 사용하면 식별 가능한 LiveData 값이 변경될 때 바인딩된 레이아웃의 UI 요소에도 알림이 전송되며 레이아웃 내에서 UI를 업데이트할 수 있다.</br>
    view binding은 단반향 binding으로 뷰를 코드에 binding할 수 있지만, 코드를 뷰에 binding할 수는 없다.</br>
    다시 말하면 view binding을 사용하면 뷰에서 앱 데이터를 참조할 수 없다. 이것은 data binding을 통해 해결할 수 있다.

    - `data binding`</br>
        data binding은 Android Jetpack 라이브러리의 일부이다.</br>
        data binding은 선언적 형식을 사용하여 레이아웃의 UI 구성요소를 앱의 데이터 소스에 바인딩한다.</br>
        간단히 말하면, binding data (from code) to views + view binding (binding views to code).</br>

        data binding은 Activity에서 많은 UI 프레임워크 호출을 삭제할 수 있어 파일이 더욱 단순해지고 더 손쉬운 유지관리가 가능하다.</br>
        또한 앱 성능이 향상되며 메모리 누수 및 null pointer exception을 방지할 수 있다.

        ***사용법***</br>
        - `data binding 설정하기`</br>
            1. build.gradle(Module) 파일의 buildFeatures 섹션에서 dataBinding 속성을 설정한다.</br>
            ```groovy
                buildFeatures {
                viewBinding = true
                }
            ```

            2. build.gradle(Module) 파일에서 kotlin-kapt 플러그인을 적용해야 한다.</br>
            ```groovy
                plugins {
                    id 'com.android.application'
                    id 'kotlin-android'
                    id 'kotlin-kapt'
                }
            ```

            위의 두 단계를 마치면 앱의 모든 레이아웃 XML 파일용 binding 클래스를 자동으로 생성한다.

        - `레이아웃 파일을 data binding 레이아웃으로 변환하기`</br>
            data binding 레이아웃 파일은 약간 차이가 있으며 <'layout'>의 루트 태그로 시작하고 선택적 <'data'> 요소 및 view 루트 요소가 뒤따른다.</br>
            view 루트 요소는 루트가 binding 레이아웃 파일이 아닌 파일에 있는 요소이다.

            ```xml
                <!-->예시<-->
                <layout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:app="http://schemas.android.com/apk/res-auto"
                xmlns:tools="http://schemas.android.com/tools">

                <data>

                </data>

                <ScrollView
                    android:layout_width="match_parent"
                    android:layout_height="match_parent">

                    <androidx.constraintlayout.widget.ConstraintLayout
                        ...
                    </androidx.constraintlayout.widget.ConstraintLayout>
                </ScrollView>
                </layout>
            ```

            이후 Fragment 등에서 아래와 같이 data binding 인스턴스화를 한다.</br>
            ```kotlin
                // 예시
                binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment, container,false)
            ```

        - `data binding 변수 추가하기`</br>
            레이아웃 파일에서 <'data'> 태그 내에 <'variable'>이라는 하위 태그를 추가하고 name과 type을 지정한다.</br>

            ```xml
                <!-->예시<-->
                <data>
                <variable
                    name="gameViewModel"
                    type="com.example.android.unscramble.ui.game.GameViewModel" />
                </data>
            ```

        - `레이아웃에 생명 주기 소유자 전달`
            이후 Fragment 등, LiveData는 생명 주기를 인식하며 식별 가능하기 때문에 레이아웃에 생명 주기 소유자를 전달해야한다.
            ```kotlin
                binding.lifecycleOwner = viewLifecycleOwner
            ```

        

    