# PATHWAY 4: Add a button to an app
[PATHWAY 4 사이트](https://developer.android.com/courses/pathways/android-basics-kotlin-four)

## 1. Classes and object instance in Kotlin
[코틀린에서 객체 인스턴스 다루기](https://developer.android.com/codelabs/basic-android-kotlin-training-create-dice-roller-in-kotlin?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-four%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-create-dice-roller-in-kotlin#0)

- `IntRange` 시작점부터 끝점까지의 정수 범위를 나타내는 데이터 유형
- `코틀린에서 변수 선언 특징`</br>
코틀린에서는 데이터 변수를 선언할 때 데이터 형식을 지정하지 않아도 된다.</br>
val 또는 var로 정의해주면 시스템이 알아서 해석해준다.</br>
ex) val diceRange=1..6  → val dicRange: IntRange=1..6
- `random()` 주어진 범위의 랜덤 숫자를 생성하고 반환하는 함수
- `캡슐화 의미` 논리적으로 관련된 기능을 단일 위치로 묶을 수 있다는 의미 (논리적으로 관련된 모든 내용을 클래스로 구성하는 작업)
- `class 생성 및 명명 규칙` 클래스 이름은 대문자 카멜 표기법(파스칼 표기법)으로 작성
- `클래스의 객체 인스턴스 생성` 클래스에 ()를 붙여 클래스에서 새 객체 인스턴스를 만듬
- `메서드 의미` 클래스 내에서 정의된 함수를 메서드라고 함
- `함수에서 데이터를 반환하는 법` 함수가 반환하는 데이터 유형을 지정
- `함수가 입력의 인수를 허용하는 법` 함수명의 ()안에 인수로 받을 데이터를 설정
- `리팩터링 의미` 코드를 더 간결하고 효율적이며 읽고 이해하기 쉽게 변경하는 것

## 2. Create an interactive Dice Roller app
[버튼 클릭 시 번호가 랜덤으로 변하는 프로젝트](https://developer.android.com/codelabs/basic-android-kotlin-training-create-dice-roller-app-with-button?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-four%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-create-dice-roller-app-with-button#0)

- `Button 추가 및 배치`
- `tools:text`</br>
tools 속성을 사용하여 미리보기에서는 text를 보이게 하고 실행시에는 안보이게 동작
- `Activity 소개`</br>
Activity는 앱이 UI를 그리는 창을 제공한다.
- `MainActivity 소개`</br>
코틀린 프로그램에는 main() 함수가 있어야 하지만 안드로이드 앱에서는 main() 함수를 호출하는 대신 MainActivty의 onCreate() 메서드를 호출한다.
- `setContentView`</br>
시작 레이아웃을 설정
- `import 자동 가져오기 설정`
- `findViewById()`</br>
레이아웃에 있는 요소 탐색
- `리소스 ID의 형식`</br>
리소스 ID의 형식은 R.<'type'>.<'name'> 이다. ex) R.id.button, R.id.string.roll</br>
안드로이드는 자동으로 앱의 리소스에 ID 번호를 할당한다.
- `android.widget.Button`</br>
Button 클래스는 android.widget.Button에 정의되어 있다.
- `setOnClickListener()`</br>
클릭 리스너
- `Toast.makeText`</br>
토스트 사용법
- `TextView의 text 변경`</br>
'변수명'.text = "data"
- `코드 정렬`</br>
Ctrl+Alt+L를 사용하면 코드를 정렬할 수 있다.

## 3. Add conditional behavior in Kotlin
[코틀린에서 조건부 동작 추가하는 법](https://developer.android.com/codelabs/basic-android-kotlin-training-conditional-dice-roll-behavior?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-four%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-conditional-dice-roll-behavior#0)

- `if, else if, else`</br>
if문을 통한 조건에서 <, >, == 와 같은 연산자 쓰임새
- `when`</br>
swich-case문

## 4. Add images to the Dsice Roller app
[번호가 변하는 프로젝트에서 이미지로 변환하기](https://developer.android.com/codelabs/basic-android-kotlin-training-dice-roller-images?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-four%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-dice-roller-images#0)


- `이미지 추가`</br>
Resource Manager 아래의 +를 클릭하고  Import Drawables를 선택하여 추가하려는 이미지가 있는 파일 경로로 가서 import 해준다.
- `dp 단위 특징`</br>
밀도 독립형 픽셀(dp)을 단위로 사용하여 크기를 정의하면 픽셀 해상도가 다른 기기에서 이미지 크기가 적절하게 조정된다.
- `ImageView의 이미지 변경`</br>
'변수명'.setImageResource(R.id.요소 아이디)
- `ImageView의 contentDescription 설정`</br>
'변수명'.contentDescription, 해당 이미지가 무엇인지 설명할 텍스트를 지정해주어야 한다.

https://user-images.githubusercontent.com/52282493/128595316-13270794-24f9-4718-ac74-765100a8ce66.mp4

## 5. What can you build with these basics?

## 6. Project: Lemonade app
[Lemonade 프로젝트](https://developer.android.com/codelabs/basic-android-kotlin-training-project-lemonade?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-four%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-project-lemonade#0)

- `안드로이드 테스트 실행`</br>
안드로이드 스튜디오에서 java 폴더 안에 MainActivity가 속해있는 폴더 이외의 폴더가 test를 진행할 수 있는 파일