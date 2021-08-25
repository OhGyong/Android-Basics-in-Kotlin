# PATHWAY 1: Navigate between screens
[PATHWAY 1 사이트](https://developer.android.com/courses/pathways/android-basics-kotlin-unit-3-pathway-1)

## 1. Welcome to Unit 3: Navigation
이전 Unit들에서는 Layout이 한 개인 앱들을 개발하고 공부했다면 이번에는 탐색할 수 있는 여러 개의 화면이 있는 앱을 만들어 볼 것이다.

## 2. Collections in Kotlin]
컬렉션, 코틀린에서의 람다 및 고차 함수에 관해 학습한다.</br>
[코틀린 컬렉션, 고차함수 소개 페이지](https://developer.android.com/codelabs/basic-android-kotlin-training-collections?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-3-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-collections#0)

- `컬렉션`</br>
단어 목록이나 직원 기록 모음과 같은 관련 항목 그룹이다. 컬렉션의 항목은 순서가 지정되거나 지정되지 않을 수 있으며 고유하거나 고유하지 않을 수 있다. 컬렉션의 유형으로 List, set, map이 있다.
- `set(집합)`</br>
List와 달리 중복될 수 없고 순서는 중요하지 않은 컬렉션이다.</br>
contains()를 통해 집합에 해당 요소가 있는지 확인할 수 있으며, 수학의 집학처럼 교집합 또는 합집합과 같은 연산을 intersect(), union()을 통해 할 수 있다.
- `'List'.toSet()`</br>
toSet()은 List를 set으로 변환하는 함수이다.
- `setOf(), mutableSetOf()`</br>
집합을 정의하는 함수이다.
- `map(맵 or 사전)`</br>
특정 키가 부여된 값을 쉽게 찾을 수 있도록 설계된 'key-value' 쌍의 집합이다. key는 고유하며 각 key는 하나의 value에 매핑되지만, value는 중복될 수 있다.
- `mutableMapOf`</br>
map 데이터를 생성할 수 있는 함수이다.
- `forEach()`</br>
forEach()를 사용하면 자동으로 모든 항목을 탐색한 후 항목별로 작업을 실행할 수 있다.
- `it`</br>
특수 식별자
- `filter()`</br>
컬렉션에서 표현식을 기반으로 일치하는 항목을 반환하는 함수이다.
- `람다식`</br>
이름이 없으며 곧바로 표현식으로 사용할 수 있는 함수를 람다식이라고 한다. 
- `함수 유형`</br>
람다와 같은 유형의 동작을 사용할 수 있도록 코틀린에서는 함수 유형이라는 것이 제공된다.</br>
입력 매개변수와 반환 값을 기반으로 함수를 정의 할 수 있다.</br>
    ```
    함수 유형 예시: (Int) -> Int
    ```
위 예시를 설명하면 Int 유형의 매개변수를 사용하고 Int 유형의 값을 반환한다는 뜻이다.</br>
괄호의 안은 매개변수를 나타내고 화살표의 오른쪽은 반환 유형을 나타낸다.
    ```
    람다 표현식 예시: {a:Int -> a * 3}
    ```
    위 식은 정수 입력 값에 3을 곱하는 람다 표현식이다. 매개변수가 먼저 나오고 ->가 나온 다음 함수의 본문이 나온다.</br>
    람다 표현식 예시를 분석하면 함수 유형은 (Int) -> Int 이고 값은 람다 표현식 {a:Int -> a * 3} 이다.</br>
    람다는 일반 변수에 저장할 수도 있는데, 아래의 그림을 참고하자.</br>

    ![image](https://user-images.githubusercontent.com/52282493/129927798-4cfd74e3-8365-4b10-bb69-76d5f67f9919.png)</br>

- `고차 함수`</br>
함수(람다)를 다른 함수로 전달하거나 다른 함수에서 함수를 반환하는 것을 의미한다.</br>
map, filter, forEach 함수는 모두 매개변수를 사용했기 때문에 고차 함수의 예라고 볼 수 있다.
- `sortedWith()`</br>
문자열 길이를 기준으로 목록을 정렬하는 함수. 람다식을 이용하여 두 문자열의 길이를 비교하는 코드를 작성한다.</br>
    ```
    sortedWith() 예시 : 'List 변수'.sortedWidth{str1: String, str2: String -> str1.length-str2.length}
    ```
    위의 sortedWith()에 전달된 람다식에는 String 형의 str1, str2 두 개의 매개변수가 있다.</br>
    -> 다음에는 str1.length-str2.length 함수 본문이 나온다.</br>
    첫 번째 문자열과 두 번째 문자열 길이의 차이를 반환하여 낮은 순서대로 문자열을 정렬한다.
- `startsWidt()`</br>
filter() 함수를 사용할 때 startWidt()로 지정된 단어로 시작하는 항목을 찾아낼 수 있다.
- `shuffleed()`</br>
코틀린 컬렉션을 사용하면 shuffled() 함수를 사용하여 항목을 무작위로 섞어 반환한다.
- `take()`</br>
컬렉션에서 항목의 원하는 개수 만큼만 반환하도록 한다.

## 3. Activities and intents
[Activty와 인텐트 설명](https://developer.android.com/codelabs/basic-android-kotlin-training-activities-intents?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-3-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-activities-intents#0)

- `인텐트`</br>
실행할 작업을 나타내는 객체이다. 암시적 인텐트와 명시적 인텐트 두 가지 유형이 있다.</br>
명시적 인텐트는 매우 구체적이며 실행할 활동을 정확하게 알 수 있고 자체 앱의 화면인 경우가 많다.</br>
암시적 인텐트는 좀 더 추상적이면서 시스템에 링크 열기나 이메일 작성, 전화 걸기와 같은 작업 유형을 알려주고 시스템은 요청 처리 방법을 파악해야 한다.
- `rangeTo().toList()`</br>
해당범위의 값을 List화 시켜준다.</br>
    ``` kotlin
    val list = ('A').rangeTo('Z').toList()
    ```
    위 예제 코드를 출력하면 [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z] 이렇게 된다.
- `accessibilityDelegate`</br>
- `Intent()`</br>
extras를 통하여 다른 구성요소에 데이터를 전달할 수 있다.</br>
Extra는 Bundle 객체이며 Bundle은 여러 가지 타입의 값을 저장할 수 있는 클래스이다.
- `intent.putExtra`</br>
다른 Activity에 데이터를 전달하는 메서드
- `intent.extras`</br>
extras는 Bundle 유형으로 intent에 전달된 모든 extras에 액세스하는 방법
- `속성의 ?`</br>
null을 허용할 수 있다는 처리를 ?를 통해서 표현한다.(값이 없을 수 있다.)
- `companion object (컴패니언 객체)`</br>
클래스의 특정 인스턴스 없이 상수를 구분하여 사용할 수 있게 하는 기능
- `Uri (Uniform Resuorce Identifier)`</br>
URL(Uniform Resource Locator)와 달리 형식에 관한 좀 더 일반적인 용어이다.</br>
![image](https://user-images.githubusercontent.com/52282493/130318539-83c60c8e-88d4-4b24-ae5d-61e9eee665d7.png)
- `intent.ACTION_VIEW`</br>
ACTION_VIEW는 URI를 사용하는 일반적인 인텐트이다. </br>
시스템에서 사용자의 웹브라우저에서 URI를 열어 인텐트를 처리할 수 있다.
- `startActivity()`</br>
startActivity()를 intent 등을 사용하여 호출하면서 해당 화면을 실행시킨다.
- `app bar (앱 바)`
앱의 상단에 표시되는 부분을 말한다.</br>
앱 이름을 표시할 수 있고, 메뉴를 추가하는 등의 맞춤 설정을 할 수 있다.
- `메뉴 추가하는 방법`</br>
메뉴를 표현할 아이콘들을 drawable 파일에 다운로드 받는다.</br>
res 폴더에 Resource Type을 Menu로 하여 리소스 파일을 추가한다.</br>
java 파일에 메뉴를 추가하는 코드를 작성한다.
- `GridLayoutManager()`
- `ContextCompat`</br>
Resource에서 값을 가져오거나 퍼미션을 확인(사용)할 때 SDK 버전을 고려하지 않아도 설게된 클래스이다.
- `onCreateOptionMenu()와 onOptionsItemSelected()`</br>
앱이 메뉴를 사용하기 위해서는 onCreateOptionMenu()와 onOptionsItemSelected() 두 개의 메서드가 필요하다.</br>
    - onCreateOptionMenu() : 메뉴를 생성한다. 옵션 메뉴를 확장하여 추가 설정을 실행한다.
    - onOptionsItemSelected() : 메뉴의 버튼이 선택될 때 이벤트 처리를 한다. 실제로 chooseLayout()을 호출한다.

https://user-images.githubusercontent.com/52282493/130782002-a7f0b596-631b-4192-bbbc-74a7524850e2.mp4


## 4. Stages of the activity lifecycle
[Activity 생명 주기 소개](https://developer.android.com/codelabs/basic-android-kotlin-training-activity-lifecycle?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-3-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-activity-lifecycle#0)

Activity 생명 주기는 Activity가 생성되는 시점에 시작하여 활동이 소멸되어 시스템에서 Activity 리소스가 회수될 때까지의 싸이클이다.</br>
앱을 사용하는 유저들은 Activity 간에 화면을 이동하게 되는데 이동 간에 Activity 생명 주기는 다양한 상태로 전환된다.</br>

개발자는 생명 주기를 파악하고 있어야 한다. Activity가 생명 주기에 올바르게 응답하지 않으면 앱에 버그가 발생하여 사용자의 동작에 혼란을 주거나 앱의 안드로이드 시스템 리소스를 너무 많이 사용하게 될 수 있다.</br>

안드로이드 수명 주기를 파악하고 수명 주기 상태 변경에 올바르게 응답하는 것은 좋은 AOS 개발자가 되기 위한 중요 요소이다.</br>
![image](https://user-images.githubusercontent.com/52282493/130782783-91831f05-b63e-46aa-b680-c2275e7fbd18.png)


'DessertClick'라는 앱을 개발하면서 생명 주기에 대해 알아보자.

우선 앱이 실행되면 onCreate(), onStart(), onResume() 순으로 호출이 된다.</br>
기기에서 뒤로 버튼을 탭하면 onPause(), onStop(), onDestroy()가 순서대로 호출된다.

사용자가 안드로이드 기기와 상호작용을 할 때, 홈으로 이동하거나 전화 통화나 새 앱을 실행하는 경우 해당 앱은 중단 처리를 한다.</br>
Activity를 종료하지 않고 홈으로 이동하는 등으로 화면에 표시되지 않는다면 이것은 Activity가 백그라운드에 배치된 것이다.</br>
앱이 백그라운드 상태일 때는 시스템 리소스와 배터리 수명을 보존하기 위해 일반적으로 활동적으로 실행되지 않아야 한다.</br>
Activity 생명 주기와 그 콜백을 사용하여 백그라운드로 이동하는 시점을 알 수 있기 때문에 진행 죽인 Activity 활동을 중지 시킬 수 있다.</br>
그 뒤에 앱이 포그라운드로 전활 될 때에도 작업을 다시 실행할 수 있다.
    - onCreate() - 앱을 만든다.
    - onStart() - Activity를 시작하고 화면에 표시되게 한다.
    - onResume() - Activity 포커스를 제공하고 사용자가 상호작용할 수 있도록 Activity를 준비한다.
    - onPause() - Activity 포커스를 상실한다.
    - onStop() - 앱을 표시하지 않는다.
    - onDestroy() - Activity를 완전히 종료하고 메모리 정리를한다.

- `onCreate()`</br>
모든 Activity에서 구현해야 하는. view binding 등 Activity의 일회성 초기화를 한다.</br>
Activity가 초기화 된 뒤에(Activity 객체가 메모리에 만들어질 때) 한 번 호출된다.</br>
onCreate() 메서드를 재정의 할 때 super 클래스로 생성해야 한다. 즉, super.onCreate()를 즉시 호출해야 한다.
onCreate()가 실행되면 Activity가 생성됨으로 간주된다. 
- `Log`</br>
Log 클래스는 Logcat에 메시지를 쓴다. Logcat은 메시지를 기록하는 콘솔이다.</br>
    - Log.d() : 디버그 메시지를 작성한다. 
    - Log.i() : 정보 메시지를 작성한다.
    - Log.e() : 오류 메시지를 작성한다.
    - Log.w() : 경고 메시지를 작성한다.
    - Log.v() : 자세한 메시지를 작성한다.</br>   
    모든 메서드에 두 개의 메개변수가 들어간다.</br>
    첫 번째 매개변수는 로그 태그이다. MainActivity 같은 클래스 이름을 삽입하여 로그 메시지를 더 쉽게 찾을 수 있다.</br>
    두 번째 매개변수는 로그 메시지이다. 문자열을 입력하면 된다.
- `onStart()`</br>
onStart() 생명 주기 메서드는 o() 직후에 호출된다. onStart()가 실행되면 Activity가 화면에 표시된다.</br>
onCreate()는 Activity를 초기화 하는데 한 번만 호출 되지만, onStart()는 Activity의 생명 주기에서 여러 번 호출될 수 있다.</br>
onStart()는 상응되는 onStop() 생명 주기 메서드와 페어링된다.</br>
사용자가 앱을 시작한 후 기기의 홈 화면으로 돌아오면 활동이 중지되고 더 이상 화면에 표시되지 않는다.
- `onResume()`</br>
활동 포커스를 제공하고 사용자가 수 있도록 Activity를 준비한다.
- `onPause()`</br>
앱이 백그라운드 상태일 때 호출되며, 이 때 사용자의 포커스가 상실된다.
- `onStop()`</br>
onPause() 이후에 호출되며, 더 이상 앱이 표시되지 않는다.
- `onDestroy()`</br>
onDestroy()의 실행은 Activity가 완전히 종료되었으며 가비지 컬렉션이 될 수 있음을 의미한다.</br>
onDestroy()가 호출이 되면 시스템은 가비지 컬렉션같은 리소스들이 삭제될 수 있음을 인식하고 메모리 정리를 시작한다.</br>
onCreate()가 맨 처음 앱을 초기화 할 때 한 번만 호출이 되었던 것처럼 onDestory()는 리소스가 정리 될 때 한 번만 초기화된다.
- `onRestart()`</br>
앱이 백그라운드에 상태에 있다가 포그라운드로 돌아올 때 onCreate()가 실행되지 않고 onRestart()가 호출된다.</br>
onCreate()와 유사한 부분은 Activity가 표시되기 전에 호출이 된다는 점이다.
- `가비지 컬렉션`</br>
더 이상 사용하지 않을 객체의 자동 정리를 나타낸다.
- `finsih()`</br>
Activity의 종료를 하게 하는 메서드이다.</br>
스마트 폰 기기의 뒤로가기 버튼을 누른 것처럼 활용할 수 있다.
- `대화형 생명주기`</br>
앱이 완전히 화면에 표시되고 사용자 포커스를 보유하는 생명 주기 부분을 말한다.
- `기기의 회전 시 데이터 손실`</br>
기기 상태가 매우 급격하게 변경되어 시스템이 변경사항을 확인하는 가장 쉬운 방법이 Activity를 완전히 종료하고 다시 빌드하는 것이다.</br>
기기를 가로에서 세로 또는 세로에서 가로로 회전하는 경우 onDestroy() 메서드가 호출되기 때문에 데이터가 손실된다.
- `onSaveInstanceState()`
Activity가 소멸되면 필요할 수 있는 데이터를 저장하는 데 사용하는 콜백이다.</br>
생명 주기 콜백 이미지에서 onSaveInstanceState()는 활동이 중지된 후 (onStop() 메서드가 호출된 후) 호출된다.</br>
즉, 앱이 백그라운드로 전환될 때마다 호출된다.</br>
![image](https://user-images.githubusercontent.com/52282493/130796004-0e4cb8b3-3da5-4c3f-9afa-403b2adfb7b0.png)