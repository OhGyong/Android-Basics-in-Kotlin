# PATHWAY 1: Introduction to the Navigation component
[PATHWAY 1 사이트](https://developer.android.com/courses/pathways/android-basics-kotlin-unit-3-pathway-2)

## 1. Android Jetpack: Introducing Navigation Component

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




## 3. Navigation: Overview - MAD Skills