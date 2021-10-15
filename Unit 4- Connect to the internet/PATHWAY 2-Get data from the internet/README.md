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

## 3. Load and display images from the internet