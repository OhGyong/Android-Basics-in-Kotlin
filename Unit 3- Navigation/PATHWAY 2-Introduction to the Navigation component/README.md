# PATHWAY 1: Introduction to the Navigation component
[PATHWAY 1 사이트](https://developer.android.com/courses/pathways/android-basics-kotlin-unit-3-pathway-2)

## 1. Android Jetpack: Introducing Navigation Component
Navigate는 다른 화면으로 이동한다는 것을 뜻한다. 안드로이드 개발에 있어서 절대적으로 기본적인 요소이다.</br>
Navigation 구성요소는 라이브러리, 플러그인, 툴을 모아놓은 것으로 안드로이드의 Navigation을 단순화 한 것이다.</br>
Bottom Navigation과 같은 패턴의 설정을 더 쉽게 만들게 하고 구성요소가 백스텍과 Fragment 트랜잭션을 처리하고 인수 전달을 입력하며 Navigation 기반으로 한 애니메이션과 딥 링크를 처리한다.</br>
Navigation 구성요소는 Activity와 Fragment에서 사용할 수 있다. 또한 다른 화면에서 실행될 수 있도록 라이브러리를 확장시킬 수 있다.</br>
Navigation 구성요소의 특징 중 하나는 세 가지 주요한 부분이 조화롭게 작동된다는 것이다.
    - Navigation Graph : XML 파일 형태의 새로운 리소스 유형으로 Navigation과 관련된 정보를 포함하고 중심화한다. Navigation의 시각화가 가능하다. (안드로이드 3.3 이상부터)
    - NavHostFragment : 레이아웃을 추가할 Fragment 위젯이다. Navigation Graph에서 포함하는 다양한 Fragment 목적지를 교환하는 곳이다. 개별적으로 NavController를 가진다.
    - NavController : 자바나 코틀린 언어로 작업하여 Navigation이 작동되도록 한다.

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

    Fragment의 생명주기 다섯 가지 Lifecycle.State 열거형 표시</br>
    - INITIALIZED: Fragment의 새 인스턴스가 인스턴스화 되었다.
    - CREATED: 첫 번째 Fragment 생명주기 메서드가 호출된다. 이 상태에서 Fragment와 연결된 뷰도 만들어진다.
    - STARTED: Fragment가 화면에 표시되지만 포커스가 없으므로 사용자 입력에 응답할 수 없다.
    - RESUMED: Fragment가 표시되고 포커스가 있다.
    - DESTROYED: Fragment 객체의 인스턴스화가 취소되었다.

    Fragment의 생명주기 이벤트에 응답하기 위한 재정의할 수 있는 메서드</br>
    - onCreate(): Fragment가 인스턴스화 되었 CREATED 상태이다. 하지만 이에 상응하는 뷰가 아직 만들어지지 않았다.
    - onCreateView(): 이 메서드에서 레이아웃을 확장한다. Fragment가 CREATED 상태로 전환된다.
    - onViewCreated(): 뷰가 만들어진 후 호출된다. 이 메서드에서 일반적으로 findViewById()를 호출하여 특정 뷰를 속성에 바인딩한다.
    - onStart(): Fragment가 STARTED 상태로 전환된다.
    - onResume(): Fragment가 RESUMED 상태로 전환되었고 이제 포커스를 보유한다.(사용자의 입력에 응답 가능)
    - onPause(): Fragment가 STARTED 상태로 다시 전환된다. UI가 사용자에게 다시 표시된다.
    - onStop(): Fragment가 CREATED 상태로 다시 전환된다. 객체가 인스턴스화 되었지만 더 이상 화면에 표시되지 않는다.
    - onDestroyView(): Fragment가 DESTROYED 상태로 전환되기 직전에 호출된다. 뷰는 메모리에서 이미 삭제되었지만 Fragment 객체는 존재한다.
    - onDestroy(): Fragment가 DESTROYED 상태로 전환된다.

    ![image](https://user-images.githubusercontent.com/52282493/131074312-6b5d4806-5413-4236-8978-656ca2b200de.png)

- ***WordAppStarter with Fragment*** 프로젝트
    - `Fragment에서의 바인딩`</br>
        Activity와 마찬가지로 레이아웃을 확장하고 개별 뷰를 바인딩해야 한다. Activity에서는 ActivityMainBinding()을 통해서 바인딩 객체를 추가할 수 있었다.</br>
        **Fragment에서는 어떻게 할 수 있을까?**</br>
        build.gradle 파일에서 buildFeatures 섹션에 viewBinding 속성을 추가하여 설정이 되면 안드로이드 스튜디오에서 각 레이아웃 파일에 맞는 바인딩 클래스들이 생성된다.</br>
        Fragment는 각 뷰에 맞는 바인딩 객체를 추가하기만 하면 된다. 하지만 onCreateView() 가 호출될 때까지 레이아웃을 확장할 수 없기 때문에 초깃값이 null 이어야 한다.</br>
        때문에 ?연산자를 추가하여 null을 허용해야 한다. 참고로 바인딩 객체가 만들어지는 시점(생명주기가 onCreate()로 시작될 때)이 속성을 실제로 사용할 수 있는 시점 사이에 기간이 있다.</br>
        Fragment의 뷰는 생명 주기 동안 여러 번 만들어지고 소멸될 수 있다는 사실에 유의해야 하며 다른 생명 주기 메서드 onDestroyView()에서도 값을 재설정해야 한다.
        
    - `!!`</br>
        null이 아님을 확신하는 경우 유형에 추가한다.

## 3. Navigation: Overview - MAD Skills