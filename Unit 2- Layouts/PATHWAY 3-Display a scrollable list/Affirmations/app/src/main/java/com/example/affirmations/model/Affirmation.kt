package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// Affirmation 인스턴스를 만들 때 확인 문자열의 리소스 ID를 전달해야 한다. 이때 ID 값은 정수이다.
data class Affirmation(@StringRes val stringResourceId: Int,
                       @DrawableRes val imageResourceId: Int
)