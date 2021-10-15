package com.example.android.marsphotos.network

import com.squareup.moshi.Json

/**
 * JSON 객체의 키, 값에 상응하도록 설정.
 */
data class MarsPhoto (
    val id: String,
    @Json(name = "img_src") val imgSrcUrl: String
)