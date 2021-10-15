package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

/**
 * Moshi 빌더 객체 생성.
 */
private val moshi =  Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Retrofit 빌더 객체 생성.
 * Json 응답을 String으로 반환하기 위해 ScalarsConverterFactory.create()를 사용. → MoshiConverterFactory.create()로 변경
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * 인터페이스 선언 외부에서  Retrofit 서비스를 초기화.
 * 앱의 나머지 부부네서 액세스할 수 있는 공개 싱글톤 객체.
 * 앱이 MarsApi.retrofitService를 호출할 때마다 호출자는 최초 액게스 시 생성된 MarsApiService를 구현하는 것과 동일한 싱글톤 Retrofit 객체에 액세스한다.
 */
object MarsApi {
    val retrofitService : MarsApiService by lazy {

        // MarsApiService 유형의 지연 초기화 Retrofit 객체 속성 retrofitService 추가
        retrofit.create(MarsApiService::class.java)
    }
}

interface MarsApiService {

//    @GET("photos")
//    suspend fun getPhotos(): String // 웹 서비스에서 응답 문자열을 가져오는 함수, 정지함수 설정(코루틴 내에서 이 메서드를 호출할 수 있도록 설정)

    //  JSON 문자열을 반환하는 대신 JSON 배열에서 MarsPhoto 객체 목록을 반환하도록 Retrofit에 요청한다.
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto> // 정지함수 설정(코루틴 내에서 이 메서드를 호출할 수 있도록 설정)

}