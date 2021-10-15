# PATHWAY 2: Get data from the internet
[PATHWAY 1 사이트](https://developer.android.com/courses/pathways/android-basics-kotlin-unit-4-pathway-2)

## 1. Introduction to HTTP/REST
앱과 인터넷 사이에 데이터와 상호작용하는 것은 중요한 기술이다.</br>
서버와 클라이언트가 사용할 HTTP 프로토콜로 서로 통신을 한다. 영상을 통해 HTTP와 REST관련 정보를 쌓을 수 있다.

## 2. Get data from the internet

- `REST`</br>
    REST는 REpresentational State Transfer의 약자이다.</br>
    대부분의 웹 서버는 REST 웹 아키텍처를 사용해 웹 서비스를 실행하는데, 이 아키텍처를 제공하는 웹 서비스를 RESTful 서비스라고 한다.

- `Retrofit`</br>
    RESTful API와 통신하기 위해 사용되는 라이브러리이다.</br>
    Retrofit 라이브러리는 백엔드와 통신한다. 이 라이브러리는 웹 서비스에 전달하는 매개변수를 기반으로 웹 서비스의 URI를 만든다.</br>
    ![image](https://user-images.githubusercontent.com/52282493/137473481-dd0fc6ce-b4c5-4df0-b7ce-56b9d8a8e634.png)

    Retrofit은 웹 서비스의 콘텐츠를 기반으로 앱의 네트워크 API를 만든다. 그리고 웹 서비스에서 데이터를 가져온 후 데이터를 디코딩하여 String 같은 객체 ㅕㅎㅇ식으로 반환하는 방법을 알고 있는 별도의 변환기 라이브러리를 통해 라우팅한다.

    - `Retrofit 종속성 추가`</br>
        ```groovy
            // Retrofit, Retrofit2 라이브러리 자체와 관련되어있다.
            implementation "com.squareup.retrofit2:retrofit:2.9.0"
            // Retrofit with Moshi Converter, Retrofit 스칼라 변환기와 관련되어있다. JSON 결과를  String으로 반환할 수 있다.
            implementation "com.squareup.retrofit2:converter-scalars:2.9.0"
        ```

    - `Retrofit.Builder()`</br>
        Retrofit 빌더 추가.</br>
        Retrofit에서는 웹 서비스의 기본 URI 및 변환기 팩토리가 있어야 웹 서비스 API를 빌드할 수 있다. 변환기는 웹 서비스에서 얻은 데이터로 해야 할 일을 Retrofit에 알린다.</br>
        그 중 Retrofit에서 웹 서비스의 JSON 응답을 가져와 String으로 반환하려고 하는 경우, Retrofit에서 문자열 및 기타 Primitive 유형을 지원하는 `ScalarsConverter`가 있으므로 `ScalarsConverterFactory`의 인스턴스를 사용하여 빌더에서 `addConverterFactory()`를 호출한다. 또한, `baseUrl()` 메서드를 사용하여 웹 서비스의 기본 URI를 추가하고 마지막으로 `build()`를 호출하여 Retrofit 객체를 만든다.</br>
        ```kotlin
            // 예시
            private val retrofit = Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl("url 넣는곳"))
                .build()
        ```

    - `Retrofit.create()`</br>


- `객체 선언과 싱글톤 패턴`</br>
    코틀린에서 객체 선언은 싱글톤 객체를 선언하는데 사용된다. 코틀린을 사용하면 싱글톤을 쉽게 선언할 수 있다.</br>
    싱글톤 패턴은 객체의 인스턴스가 하나만 생성되도록 보장하며, 이 객체의 전역 액세스 포인트 하나를 가진다.

    객체 선언의 초기화는 스레드로부터 안전하며 처음 액세스할 때 실행된다. 객체 선언에는 항상 **object** 키워드 뒤에 이름이 있다.</br>
    ```kotlin
        // 예시
        object DataProviderManager {
            fun registerDataProvider(provider: DataProvider) {
                // ...
            }
        ​
            val allDataProviders: Collection<DataProvider>
                get() = // ...
        }

        // To refer to the object, use its name directly.
        DataProviderManager.registerDataProvider(...)
    ```

    Retrofit 객체에서 create() 함수를 호출하는데는 리소스가 많이 들고, 앱에는 Retrofit API 서비스의 인스턴스가 하나만 필요하다.</br>
    따라서 객체 선언을 사용하여 나머지 앱의 나머지 부분에 서비스를 노출한다.

- `viewModelScope`</br>
    앱의 각 ViewModel을 대상으로 정의된 기본 제공 코루틴 범위이다. 이 범위에서 실행된 모든 코루틴은 ViewModel이 삭제되면 자동으로 취소된다.</br>
    ViewModelScope를 사용하여 코루틴을 실행하고 백그라운드에서 Retrofit 네트워크 호출을 실행한다.

    - `viewModelScope.launch`</br>
        코루틴 실행함수


- `안드로이드 인터넷 권한`</br>
    앱이 인터넷에 액세스하려면 INTERNET 권한이 필요하다.</br>
    AndroidManifest에 <'application'>에 <'uses-permission android:name="android.permission.INTERNET" '/>를 추가한다.

- `Exception(예외)`</br>
    Exception은 컴파일 시간이 아닌 런타임 시 발생할 수 잇는 오류로, 사용자에게 알리지 않고 앱을 갑자기 종료한다.</br>
    예외 처리는 앱이 갑자기 종료되지 않도록 하는 메커니즘이며 사용자 친화적인 방법으로 처리된다.

    - `try-catch`</br>
        try 블록 내부에서 예외가 발생한 것으로 예상되는 코드를 실행한다. 네트워크를 호출하는 코드를 try 블록에 작성을 한다.</br>
        catch 블록에는 앱이 갑자기 종료되는 것을 방지하는 코드를 작성한다. 예외가 발생할 경우 catch 블록이 실행되어 앱을 종료시키지 않는다.

- `JSON`</br>
    - JSON 응답은 대괄호로 표시된 배열이다.
    - JSON 객체는 중괄호로 묶여있다.
    - 각 JSON 객체에는 key-value 쌍의 집합이 포함된다. key와 value는 콜론으로 구분된다.
    - key는 따옴표로 묶여 있다.
    - 값은 숫자, 문자열, 부울, 배열, 객체(JSON 객체) 또는 null일 수 있다.

- `Moshi`</br>
    Retrofit과 같은 외부 라이브러리이며, Moshi 라이브러리는 JSON 문자열을 코틀린 객체로 변환하는 안드로이드 JSON 파서이다. Retrofit은 Moshi와 연동되는 변환기가 있다.

    - `Moshi.Builder()`</br>
        Moshi 빌더 추가.</br>
        Moshi의 주석이 코틀린과 원활하게 작동하려면 Moshi 빌더에서 KotlinJsonAdapterFactory를 추가한 다음 build()를 호출한다.</br>
        ```kotlin
            private val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        ```

- `@Json 주석`</br>
    JSON 응답의 key, value로 인해 코틀린 속성이 혼란스러워지거나 권장 코딩 스타일과 일치하지 않을 수 있다.</br>
    JSON 파일에서는 key 값은 _의 밑줄을 사용하지만 코틀린 규칙은 카멜표기법이다.

    데이터 클래스에 JSON 응답의 key, value와 다른 변수 이름을 사용하려면 @JSON 주석을 사용한다.</br>
    ```kotlin
        // 데이터 클래스의 변수명은 imgSrcUrl이고, @Json(name = "img_src")를 사용하여 변수를 JSON 속성 img_src에 매핑한다.
        @Json(name = "img_src") val imgSrcUrl: String
    ```

## 3. Load and display images from the internet