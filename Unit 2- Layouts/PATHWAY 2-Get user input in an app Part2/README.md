# PATHWAY 2: Get user input in an app Part2
[PATHWAY 2 사이트](https://developer.android.com/courses/pathways/android-basics-kotlin-unit-2-pathway-2)

## 1. Change the app theme
[앱의 테마 변경](https://developer.android.com/codelabs/basic-android-kotlin-training-change-app-theme?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-change-app-theme#0)

- `테마(theme)`</br>
테마는 개별 View뿐 아니라 앱 구조 전체에 적용되는 스타일의 모음이다.

- `colors.xml에 색상 추가 및 themes.xml에 색상 사용`

- `스마트기기가 다크모드일 시 앱의 어두운 테마 설정`</br>
themes.xml 파일중에서 (night)라고 되어있는 것이 있다. 스마트 기기가 다크모드가 적용되면 해당 파일이 사용된다.

## 2. Change the app icon
[앱의 아이콘 변경](https://developer.android.com/codelabs/basic-android-kotlin-training-change-app-icon?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-change-app-icon#0)

- `mipmap 폴더`</br>
안드로이드 앱의 런처 아이콘 애셋을 배치해야 하는 위치이다.</br>
폴더 이름에 hdpi, mdpi 등과 같은 밀도 한정자가 있다.</br>
![image](https://user-images.githubusercontent.com/52282493/129024454-b45773cc-5329-4de8-b482-01fc6aac0e40.png)</br>
drawable 폴더에 있지 않고 mipmap 폴더에 한정자 별로 존재하는 이유는 다양한 크기의 앱 아이콘을 표시하기 위해서 이다.

- `벡터 드로어블`</br>
안드로이드의 벡터 그래픽 구현으로 휴대기기에서 유연하도록 만들어졌다.</br>
벡터 그래픽은 이미지를 정의하는 모양을 그리는 방법을 알고있다.</br>
색상 정보, 점, 선, 곡선으로 구성되어 화질 저하 없이 모든 화면 밀도의 어떤 캔버스 크기로도 조정할 수 있다는 장점이 있다.</br>
하지만 사진과 같은 경우에는 일련의 모양으로 설명하기 힘들기 때문에 이 경우 비트맵 에셋을 사용하는 것이 효율적이다.

## 3. Create a more polished user experience
[머티리얼 디자인에 관한 문서](https://material.io/components?platform=android)에서 구성요소를 사용하고 맞춤설정하는 방법에 관한 정보를 확인할 수 있다.</br>
각 구성요소의 일반적인 머티리얼 디자인 가이드라인과 안드로이드에서 사용할 수 있는 구성요소에 고나한 안드로이드 플랫폼용 안내도 있다.

- `머티리얼을 통한 EditText와 Switch 활용하기`</br>
com.google.android.material을 통해서 xml 파일에서 변경한다.

- `XML에 아이콘 추가하기`</br>
아이콘을 drawable 폴더에 추가하고 ImageView를 통해 불러온다.

- `스타일 만들기(styles.xml)`</br>
스타일은 단일 위젯 유형의 뷰 속성 값 모음이다.</br>
예를 들어 TextView 스타일의 글꼴 색상, 크기, 배경색 등을 지정할 수 있다.</br>
스타일로 속성들을 추출하면 레이아웃의 스타일을 여러 뷰에 쉽게 적용하고 단일 위치에 유지할 수 있다.</br>
스타일 이름을 원하는 대로 지정할 수 있지만 상위 머티리얼 스타일에서 상속하는 경우 유사한 방식으로 MaterialComponents를 앱 이름으로 바꿔 스타일 이름을 지정하는 것이 권장하는 방식이다.</br>
이 경우 변경사항이 고유한 네임스페이스로 이동되어 향후 머티리얼 구성요소에 새로운 스타일이 도입될 때 충돌이 발생할 가능성이 없어진다.
- `dimens.xml`</br>
공통적인 값을 치수로 표준화하여 앱을 쉽게 관리할 수 있게하는 리소스 파일.
- `Widget.MaterialComponents.TextInputLayout.OutlinedBox`</br>
MDS 라이브러리에서 제공되는 윤곽선 스타일
- `ScrollView`
- `handKeyEvent(View, keyCode)`</br>
keyCode 입력 매개변수가 KeyEvent.KEYCODE_ENTER와 같은 경우 터치 키보드를 숨기는 비공개 도우미 함수이다.
- `InputMethodManager`</br>
소프트 키보드를 표시할지 숨길지 제어하고 사용자가 어느 소프트 키보드를 표시할지 선택할 수 있도록 한다.
- `setOnKeyListener()`</br>
키 누름이 발생할 때 트리거되는 메서드. 입력 인수로 (view- 뷰, keyCode- 누른 키의 코드, keyEvent)를 사용한다.</br>
만약 사용하지 않는 입력 인수가 있다면 '_'를 입력한다.
- `벡터 드로어블 색 변경`</br>
'android:tint' 값을 변경시켜 색을 변경할 수 있다.