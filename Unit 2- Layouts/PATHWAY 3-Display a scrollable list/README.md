# PATHWAY 3: Display a scrollable list
[PATHWAY 3 사이트](https://developer.android.com/courses/pathways/android-basics-kotlin-unit-2-pathway-3)

## 1. Affirmations app introduction
이번 PATHWAY에서는 기운을 복돋는 메시지나 문구 목록을 보여줄 수 있는 명언 앱을 개발할 것이다.</br>
앱을 개발하기 위해서 데이터를 목록과 배열로 나타내고, 스크롤을 할 수 있는 텍스트와 이미지의 목록을 표시하는 법을 배운다.

## 2. Use Lists in Kotlin
[코틀린에서 List 사용하기](https://developer.android.com/codelabs/basic-android-kotlin-training-lists?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-lists#0)

- `List 데이터 유형`</br>
    List는 특정 순서가 있는 항목의 모음이다.</br>
    일반적인 'List'는 생성 후 수정할 수 없지만 'MutableList'는 생성 후 수정할 수 있다(요소를 추가하거나 삭제, 업데이트 가능).</br>
    List를 사용할 때는 포함될 수 있는 요소 유형을 명시적으로 지정해야 한다.</br>
    요소 유형을 표시할때 꺾쇠괄호롤 묶어 추가하면 된다.</br>
    예를들면 정수 목록으로 List<'Int'>, 문자열 목록으로 List<'String'>, 객체 인스턴스 목록으로 List<'클래스 명'>으로 표현할 수 있다.</br>
        ```kotlin
        /*
        * 1. listOf<>() 또는 mutableListOf<>()로 생성하기
        * 2. List<> 또는 mutableList<>로 변수의 데이터 유형을 미리 지정하여 생성하기
        */

        // List로 생성
        val entress = listOf<Int>()
        val entress: List<Int> = listOf()

        // mutableList로 생성
        val entress = mutableListOf<Int>()
        val entress: MutableList<Int> = mutableListOf()
        ```

- `listOf()`</br>
    List 값을 만듬 → listOf(1, 2, 3, 4, 5) => [1, 2, 3, 4, 5]

- `mutableListOf()`</br>
    mutableList 값을 만듬 → mutableListOf(1, 2, 3, 4, 5) => [1, 2, 3, 4, 5]

- `List.size`</br>
    List의 크기를 나타내는 함수로 List의 요소 개수를 반환한다.

- `List의 index 개념`

- `List.first(), List.last()`</br>
    first()는 List의 첫 번째 요소를 반환하고 last()는 List의 마지막 요소를 반환한다.
    
- `List.contains()`</br>
    contains(value)는 주어진 value가 List안에 있는지 확인해준다. 있으면 true를 반환하고 없으면 false를 반환한다.

- `List.reversed()`</br>
    List의 요소들을 역순으로 하는 새 List를 반환한다.

- `List.sorted()`</br>
    List의 요소들을 오름차순으로 정렬한 새 List를 반환한다.

- `List.add()`</br>
    List에 요소를 추가하는 함수이며, 성공하면 true 실패하면 false를 반환한다.</br>
    참고로 List가 아닌 MutableList로 데이터 유형을 지정하여 변수를 생성해야 가능하다.

- `List.addAll()`</br>
    .add()를 사용하여 요소를 하나씩 넣지 않고 한 번에 여러 요소를 추가할 수 있다. → List.addAll(listOf('value'))

- `List.remove()`</br>
    List에서 해당 요소를 삭제하는 함수이다. 해당 요소가 없을 경우 false를 반환한다.

- `List.removeAt()`</br>
    remove('value')와 달리 value에 index값을 넣어 List에서 해당 index를 삭제한다.

- `List.clear()`</br>
    List의 모든 요소를 삭제한다.

- `List.isEmpty()`</br>
    List가 비어 있는지 확인한다.</br>
    목록이 비어있으면 true, 요소가 하나라도 있으면 false를 반환한다.

- `while 문`</br>

- `for 문`

- `String.length`</br>
    String 변수의 문자 수를 확인할 수 있다.

### 다양한 조합의 음식을 주문하여 출력하는 코드작성
[예제코드](https://github.com/OhGyong/Android_Study/tree/master/Android%20Kotlin%20Basics%20in%20Kotlin/Unit%202-%20Layouts/PATHWAY%203-Display%20a%20scrollable%20list/PATHWAY%203-2%20code)

- `toString()`</br>
    코틀린에서는 모든 클래스가 자동으로 toString() 메서드를 상속을 하게된다.</br>
    toString() 메서드는 객체 인스턴스를 출력하면 자동으로 호출된다.

- `vararg (가변인자)`</br>
    매개변수로 인자의 개수를 유동적으로 받을 수 있게한다.</br>
    인자가 유동적으로 변경되기 때문에 불필요한 오버로딩을 하는 코드가 필요없다.

- `joinToString()`</br>
    리스트로 구성된 자료를 하나의 문자열로 표현

- `빌더 패턴`</br>
    빌더 패턴은 단계별 접근 방식으로 복잡한 객체를 빌드할 수 있는 프로그래밍의 디자인 패턴이다.

## 3. Use RecyclerView to display a scrollable list
[RecyclerView를 사용하여 스크롤이 되는 목록 표현하기](https://developer.android.com/codelabs/basic-android-kotlin-training-recyclerview-scrollable-list?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-recyclerview-scrollable-list#0)

- `RecyclerView 소개`</br>
    화면에서 스크롤된 뷰를 재사용하거나 재활용하여 목록이 큰 경우에도 매우 효율적으로 작동하도록 설계되었다.</br>
    화면에서 목록 항목이 스크롤되어 넘어가면 다음 목록 항목에 뷰를 재사용하여 새로운 콘텐츠로 채워진다.</br>
    이러한 동작은 처리 시간을 크게 단축하고 원할한 스크롤이 되도록 도와준다.</br>
    ![image](https://user-images.githubusercontent.com/52282493/129466921-5643a3d0-6cb1-4c54-aa13-d5e995d9fa9d.png)

- `패키지 설명`</br>
    패키지는 클래스나 인터페이스들을 한 곳에 모아두는 곳을 의미한다.</br>
    코드의 여러 부분별로 서로 다른 패키지를 만들어 데이터 작업에 사용하는 클래스와 UI를 서로 다른 패키지로 빌드하는 클래스로 구분할 수 있다.</br>
    여러 클래스를 만들어서 다른 패키지의 코드를 사용할 수 있다. 이것을 위해서 클래스를 코드에 import를 하는 것이 표준 관행이다.<br>
    앱의 클래스가 많지 않더라도 패키지를 사용하여 기능별로 클래스를 그룹화하는 것이 좋다.</br>
    패키지의 이름은 고유하기만 하다면 어떤 이름이든 상관없다. 패키지 이름은 구체적인 순서로 구성되며 이름의 각 부분은 소문자로 표시하고 마침표(.)로 구분한다. 예를 들어 'com.example' 다음에 앱의 이름을 사용하는 것이 일반적이다.

- `model 패키지`</br>
    개발자는 데이터를 모델링하거나 표현하는 클래스의 패키지 이름으로 model을 사용하는 경우가 많다.

- `데이터를 제공할 패키지 생성(데이터 준비)`</br>
    data 패키지 생성 후에 Datasource라는 클래스를 생성

- `RecyclerView를 만들고 사용하기 위한 내용`</br>
    ![image](https://user-images.githubusercontent.com/52282493/129467901-fbf0a98b-3f45-452e-add5-979be331326b.png)</br>
    RecyclerView를 사용하기 위해서 많은 부분이 관련된다.
        - **item**</br>
            표시할 목록의 단일 데이터 항목. 보여줄 단일 객체 하나를 나타낸다.
        - **Adapter**</br>
            Adapter는 RecyclerView에서 표시할 수 있도록 데이터를 가져와 준비한다. 즉, 데이터를 RecyclerView 에서 사용할 수 있는 형식으로 조정하는 설계 패턴이다.</br>
            앱이 실행되면 RecyclerView가 Adapter를 사용하여 화면에 데이터를 표시하는 방법을 파악한다.</br>
            RecyclerView는 목록의 첫 번째 데이터 항목을 위한 새 목록 항목 뷰를 만들도록 어댑터에 요청한다.</br>
            뷰가 생성된 후에 항목을 그리기 위한 데이터를 제공하도록 Adapter에 요청한다.</br>
            이 과정은 RecyclerView가 화면에 채워야 할 뷰가 더 이상 필요하지 않을 때까지 반복된다.
        - **ViewHolder**</br>
            확인을 표시하기 위해 사용하거나 재사용할 RecyclerView 용 풀이다.</br>
            RecyclerView는 항목 뷰와 직접 상호작용하지 않는 대신 ViewHolders를 처리한다.</br>
            ViewHolder는 ReclcyerView의 단일 항목 목록 뷰를 나타내며 가능한 경우 재사용할 수 있다.</br>
            ViewHolder 인스턴스는 목록 항목 레이아웃 안에 개별 뷰의 참조를 보유한다.</br>
            이렇게 하면 새로운 데이터로 목록 항목 뷰를 더 쉽게 업데이트 할 수 있다.</br>
            ViewHolder는 RecyclerView가 화면에서 뷰를 효율적으로 이동하기 위해 사용하는 정보도 추가한다.
        - **RecyclerView**</br>
            화면에 표시되는 뷰.

- `ConstraintLayout과 FrameLayout 선택`</br>
    ConstraintLayout은 한 레이아웃에 하위 뷰 여러개를 배치할 때 가장 적합하고 유연하다.</br>
    FrameLayout은 단일 하위 뷰를 사용할 때 적합하다.

- `RecyclerView의 표현`</br>
    RecyclerView는 선형 목록이나 그리드와 같은 다양한 방식으로 항목을 표시하도록 지원한다.</br>
    항목 정렬은 LayoutManager에서 처리한다.

- `android:scrollbars`</br>
    세로(vertical) 또는 가로(horizontal) 속성을 부여하여 스크롤바를 추가할 수 있다.

- `Context`</br>
    Application, Activity, Fragment의 현재 상태를 의미한다.</br>
    문자열 리소스에 관한 정보나 기타 앱 관련 정보는 Context 객체 인스턴스에 저장되어있다.</br>
    일반적으로 리소스, 데이터베이스, 기타 시스템 서비스에 액세스하는데 사용된다.
    

- `중첩 클래스`</br>
    클래스 내부에 다른 클래스를 정의하는 것

- `RecyclerView의 Adapter 메서드 재정의`</br>
    onCreateViewHolder(), getItemCount(), onBindViewHolder() 3개의 메서드 재정의

- `LayoutInflater.from()`</br>
    LayoutInflater는 XML 레이아웃을 뷰 객체의 계층 구조로 확장하는 방법을 알고 있다.

- `recyclerView.setHasFixedSize()`</br>
    recyclerView의 크기가 고정되어 있는 경우에 RecyclerView의 성능을 개선하기 위한 설정이다.</br>
    콘텐츠를 변경해도 RecyclerView의 레이아웃 크기가 변경되지 않는다.

[Affirmations 프로젝트](https://github.com/OhGyong/Android_Study/tree/master/Android%20Kotlin%20Basics%20in%20Kotlin/Unit%202-%20Layouts/PATHWAY%203-Display%20a%20scrollable%20list/Affirmations)


## Display a list of images using cards
[Affirmations 프로젝트에 이미지 추가하기](https://developer.android.com/codelabs/basic-android-kotlin-training-display-list-cards?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-display-list-cards#0)

- `리소스 주석`</br>
@ 기호를 통해 리소스 주석을 사용할 수 있다.
- `LinearLayout`</br>
뷰를 세로나 가로로 정렬하여 표현할 때 LinearLayout이 적합하다.
- `android:importantForAccessibility`</br>
해당 위젯을 순전히 장식용도로 사용할 때 no 속성을 부여하여 사용한다.
- `'imageView'.setImageResource`
- `android:textAppearance`</br>
textAppearance는 텍스트별 스타일을 정의할 수 있는 속성이다.
- `MaterialCardView(Card 뷰)`</br>
레이아웃 별로 구분을 줄 수 있는 뷰로, 컨테이너의 스타일을 일관되게 유지하면서 간편하게 뷰 그룹을 포함할 수 있다.

https://user-images.githubusercontent.com/52282493/129556781-bf5a63ff-825d-46ba-9cac-a25856a8d0e6.mp4