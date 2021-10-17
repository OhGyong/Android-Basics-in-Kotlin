# PATHWAY 1: Introduction to the Navigation component
[PATHWAY 1 사이트](https://developer.android.com/courses/pathways/android-basics-kotlin-unit-3-pathway-2)

## 1. Android Jetpack: Introducing Navigation Component
Navigate는 다른 화면으로 이동한다는 것을 뜻한다. 안드로이드 개발에 있어서 절대적으로 기본적인 요소이다.</br>
Navigation 구성요소는 라이브러리, 플러그인, 툴을 모아놓은 것으로 안드로이드의 Navigation을 단순화 한 것이다.</br>
Bottom Navigation과 같은 패턴의 설정을 더 쉽게 만들게 하고 구성요소가 백스텍과 Fragment 트랜잭션을 처리하고 인수 전달을 입력하며 Navigation 기반으로 한 애니메이션과 딥링크(특정 주소나 값을 입력하면 앱이 실행되거나 앱의 특정 화면으로 이동시키는 기능)를 처리한다.</br>
Navigation 구성요소는 Activity와 Fragment에서 사용할 수 있다. 또한 다른 화면에서 실행될 수 있도록 라이브러리를 확장시킬 수 있다.</br>
Navigation 구성요소의 특징 중 하나는 세 가지 주요한 부분이 조화롭게 작동된다는 것이다.

- **Navigation Graph** </br>
    XML 파일 형태의 새로운 리소스 유형으로 Navigation과 관련된 정보를 포함하고 중심화한다. Navigation의 시각화가 가능하다. (안드로이드 3.3 이상부터)
- **NavHostFragment**</br>
    레이아웃을 추가할 Fragment 위젯이다. Navigation Graph에서 포함하는 다양한 Fragment 목적지를 교환하는 곳이다. 개별적으로 NavController를 가진다.
- **NavController**</br>
    자바나 코틀린 언어로 작업하여 Navigation이 작동되도록 한다.

Navigation 구성요소의 SafeArgs Plugin은 코드를 생성하여 안전한 유형의 Navigation과 인수를 전달하게 한다. SafeArgs Plugin을 사용하면 유용하게 Navigation을 사용할 수 있다.


## 2. Fragments and the Navigation component
[Fragment와 Navigation 구성요소 소개 페이지](https://developer.android.com/codelabs/basic-android-kotlin-training-fragments-navigation-component?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-3-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-fragments-navigation-component#0)

안드로이드 앱은 화면마다 별도의 Activity가 필요하지 않다.</br>
실제로 여러 일반적인 UI 패턴들을 보면 Fragment라는 섹션을 사용하는 단일 Activity의 앱을 확인할 수 있다.</br>

Fragment의 기본사항을 알아보고 이전에 만들었던 PATHWAY1에서의 WordAppStarter 앱을 Fragment로 변환해 볼 것이다.</br>
Jetpack Navigation 구성요소를 사용하고 Navigation 그래프라는 새로운 리소스 파일을 사용하여 단일 Activity에서 Fragment 간의 이동 방법을 학습한다.

- `Fragment`</br>
    Fragment는 재사용 가능한 UI의 부분이다. Fragment를 하나 이상의 Activity에 삽입하고 재사용할 수 있다.</br>
    Activity와 마찬가지로 생명주기를 갖고 있으며 사용자의 입력에 응답할 수 있다.</br>
    Activity가 화면에 표시될 때 Activity의 뷰 계층 구조 내에 항상 포함된다.</br>
    재사용성과 모듈성을 강조하므로 단일 Activity에서 여러 Fragment를 동시에 호스팅하는 것도 가능하다.</br>
    고품질의 뛰어난 앱을 만들기 위해서는 Fragment가 필수적이다.</br>

- `Fragment의 생명주기`</br>
    Activity와 마찬가지로 Fragment는 초기화되고 메모리에서 삭제될 수 있으며 화면에 표시되었다가 사라지고 다시 표시할 수 있다.</br>
    여러 상태의 생명주기가 있고 이러한 상태 전환에 응답할 수 있도록 안드로이드에서 재정의 할 수 있는 여러 메소드가 재공된다.</br>

    **Fragment의 생명주기 다섯 가지 Lifecycle.State 열거형 표시**</br>
    - INITIALIZED: Fragment의 새 인스턴스가 인스턴스화 되었다.
    - CREATED: 첫 번째 Fragment 생명주기 메서드가 호출된다. 이 상태에서 Fragment와 연결된 뷰도 만들어진다.
    - STARTED: Fragment가 화면에 표시되지만 포커스가 없으므로 사용자 입력에 응답할 수 없다.
    - RESUMED: Fragment가 표시되고 포커스가 있다.
    - DESTROYED: Fragment 객체의 인스턴스화가 취소되었다.

    **Fragment의 생명주기 이벤트에 응답하기 위한 재정의할 수 있는 메서드**</br>
    - onCreate(): Fragment가 인스턴스화 되었고, CREATED 상태이다. 하지만 이에 상응하는 뷰가 아직 만들어지지 않았다.
    - onCreateView(): 이 메서드에서 레이아웃을 확장한다. Fragment가 CREATED 상태로 전환된다.
    - onViewCreated(): 뷰가 만들어진 후 호출된다. 이 메서드에서 일반적으로 findViewById()를 호출하여 특정 뷰를 속성에 바인딩한다.
    - onStart(): Fragment가 STARTED 상태로 전환된다.
    - onResume(): Fragment가 RESUMED 상태로 전환되었고 이제 포커스를 보유한다.(사용자의 입력에 응답 가능)
    - onPause(): Fragment가 STARTED 상태로 다시 전환된다. UI가 사용자에게 다시 표시된다.
    - onStop(): Fragment가 CREATED 상태로 다시 전환된다. 객체가 인스턴스화 되었지만 더 이상 화면에 표시되지 않는다.
    - onDestroyView(): Fragment가 DESTROYED 상태로 전환되기 직전에 호출된다. 뷰는 메모리에서 이미 삭제되었지만 Fragment 객체는 존재한다.
    - onDestroy(): Fragment가 DESTROYED 상태로 전환된다.

    ![image](https://user-images.githubusercontent.com/52282493/131074312-6b5d4806-5413-4236-8978-656ca2b200de.png)

- **WordAppStarter with Fragment** 프로젝트

    - `Fragment에서의 바인딩`</br>
        Activity와 마찬가지로 레이아웃을 확장하고 개별 뷰를 바인딩해야 한다. Activity에서는 ActivityMainBinding()을 통해서 바인딩 객체를 추가할 수 있었다.</br>
        **Fragment에서는 어떻게 할 수 있을까?**</br>
        build.gradle 파일에서 buildFeatures 섹션에 viewBinding 속성을 추가하여 설정이 되면 안드로이드 스튜디오에서 각 레이아웃 파일에 맞는 바인딩 클래스들이 생성된다.</br>
        Fragment는 각 뷰에 맞는 바인딩 객체를 추가하기만 하면 된다. 하지만 onCreateView() 가 호출될 때까지 레이아웃을 확장할 수 없기 때문에 초깃값이 null 이어야 한다.</br>
        때문에 ?연산자를 추가하여 null을 허용해야 한다. 참고로 바인딩 객체가 만들어지는 시점(생명주기가 onCreate()로 시작될 때)이 속성을 실제로 사용할 수 있는 시점 사이에 기간이 있다.</br>
        Fragment의 뷰는 생명 주기 동안 여러 번 만들어지고 소멸될 수 있다는 사실에 유의해야 하며 다른 생명 주기 메서드 onDestroyView()에서도 값을 재설정해야 한다.

    - `!!`</br>
        null이 아님을 확신하는 경우 유형에 추가한다.
        
    - `get()`</br>
        변수 앞에 get()을 사용하여 이 속성이 'get-only'라는 것을 나타낸다.</br>
        값을 가져올 수 있지만 값이 할당되고 나면 다른 것에 할당할 수 없음을 의미한다.
        ```kotlin
            //예시
            private val binding get() = _binding!!
        ```
    - `setHasOptionMenu(true)`</br>
        Fragment에서 메뉴가 있음을 알리는 코드. Activity보다 Fragment의 메뉴가 우선이 된다.

    - `Fragment에서의 onCreateOptionMenu()`</br>
        Activity에서는 menuInflater라는 전역 속성을 사용하여 메뉴를 확장한다. 하지만 Fragment에서는 이 속성이 없다.</br>
        대신 Fragment에서는 menuInflater가 매개변수로 입력이되어 사용할 수 있으며 return 값을 필요로 하지 않는다.</br>
        ```kotlin
            // Activity 예시
            override fun onCreateOptionsMenu(menu: Menu?): Boolean {
                menuInflater.inflate(R.menu.layout_menu, menu)

                val layoutButton = menu?.findItem(R.id.action_switch_layout)
                setIcon(layoutButton)

                return true
            }

            // Fragment 예시
            override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
                inflater.inflate(R.menu.layout_menu, menu)

                val layoutButton = menu.findItem(R.id.action_switch_layout)
                setIcon(layoutButton)
            }
        ```

    - `Context`</br>
        애플리케이션 환경에 대한 전역 정보의 인터페이스이다.</br>
        Context는 구현을 위한 안드로이드 시스템에서 제공하는 추상 클래스이다. 애플리케이션 별로 리소스 및 클래스에 대한 액세스는 물론 Activity의 실행, 브로드 캐스트 및 Intent 수신과 같은 애플리케이션 레벨에 대한 호출을 허용한다. 예를 들면 startActivity(), getPackageName()과 같은 시스템 레벨의 정보를 얻을 수 있는 메서드를 쓸 수 있다.</br>
        Activity 객체는 Context의 객체를 상속받는다. 따라서 Activity가 애플리케이션의 특정자원, 애플리케이션의 환경 정보, 클래스에 대해 접근할 수 있게된다.

    - `Fragment의 Context`</br>
        Activity는 Context를 상속받지만 이와 달리 Fragment는 Context가 아니다. 따라서 this를 레이아웃 관리자의 Context로 전달할 수 없다.</br>
        하지만 Fragment는 context 속성을 사용할 수 있다.

    - `Fragment의 Intent`</br>
        Fragment에서는 intent 속성이 없으므로 일반적으로 상위 Activity의 인텐트에 액세스가 안된다.</br>
        이 경우 단순 intent가 아닌 activity.intent를 참조하여 사용할 수 있다.
    
    - `Jetpack Navigation 구성요소`
        안드로이드 Jetpack에서 제공하는 Navigation 구성요소를 통해 앱에서 간단하거나 복잡한 Navigation 구현을 처리할 수 있다.</br>
        Navigation 구성요소에서 Navigation을 구현하는데 사용할 세 가지 주요 부분이 있다.
        - **Navigation Graph**</br>
            Navigation Graph는 앱에서 Navigation을 시각적으로 보여주는 XML 파일이다.</br>
            파일은 개별 Activity 및 Fragment에 상응하는 대상과 하나의 대상에서 다른 대상으로 이동하려고 코드에서 사용할 수 있는 대상 사이의 작업으로 구성된다.</br>
            레이아웃 파일과 마찬가지로 안드로이드 스튜디오는 Navigation Graph에 대상과 적업을 추가하는 시작적 편집기를 제공한다.</br>
            ![navigation graph](https://user-images.githubusercontent.com/52282493/131501904-8135650e-bf64-43c7-b349-7f884937b114.PNG)
        - **NavHost**</br>
            NavHost는 Activity 내에서 Navigation Graph의 대상을 표시하는데 사용된다.</br>
            Fragment 간에 이동하면 NavHost에 표시되는 대상이 업데이트된다.</br>
            NavHostFragment에는 NavHost 내에서 유효한 Navigation을 정의하는 NavController를 얻을 수 있다.
        - **NavController**</br>
            NavController 객체를 사용하면 NavHost에 표시되는 대상 간의 Navigation을 제어할 수 있다.</br>
            Intent를 사용할 때 startActivity를 호출하여 새로운 Activity 화면으로 이동해야 했지만, NavController의 navigate() 메서드를 호출하여 표시되는 Fragment를 교체할 수 있다.
    
    - `Navigation 구성요소 추가하기`</br>
        build.gradle(Project)에는 buildscript > ext에서 nav_version을 2.3.1로 sync 해주고</br>
        build.gradle(App)에는 implementation "androidx.navigation:navigation-fragment-ktx:$nav_version", implementation "androidx.navigation:navigation-ui-ktx:$nav_version"을 sync 해준다.
    
    - `Safe Args 플러그인`</br>
        Fragment 간에 데이터를 전달할 때 유형 안전성을 지원하는 Gradle 플러그인인 Safe Args 항목을 추가해야 한다.</br>
        build.gradle(Project)에는 buildscript > dependencies에서 classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"을 sync 해주고</br>
        build.gradle(App)에는 plugins에 id 'androidx.navigation.safeargs.kotlin'dmf sync 해준다.

    - `app:defaultNavHost="ture"`</br>
        Fragment 컨테이너가 Navigation 계층 구조와 상호작용할 수 있다.</br>
        예를 들면 시스템 뒤로 버튼을 누르면 컨테이너는 새로운 Activity가 표시될 때와 마찬가지로 이전에 표시된 Fragment로 다시 이동한다.

    - `SupportFragmentManager.findFragmentById()`<br>
        Activity랑 상호작용하는 Fragment를 관리하는 클래스로, findFragmentById() 메서드를 통해 Fragment를 찾을 수 있다.
    
    - `setupActionBarWithNavController()`</br>
        App Bar에 현재 보여지고 있는 화면의 라벨로 보여준다.

    - `onSupportNavigateUp()`</br>
        위의 setupActionBarWithNavController()을 사용하여 생긴 뒤로가기 버튼의 이벤트 처리를 하기위해서 onSupportNavigateUp()을 오버라이드 해줘야한다.
    
    - `as`</br>
        as 연산자는 대상 값을 as로 지정한 타입으로 캐스트한다.</br>
        해당 타입으로 변경이 불가능하면 ClassCastException이 발생한다.
        
## 3. Navigation: Overview - MAD Skills
