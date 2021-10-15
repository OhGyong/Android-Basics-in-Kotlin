package com.example.android.marsphotos

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load

/**
 * 앱 전반에 사용하는 Binding Adapter
 */
class BindingAdapter {

    @BindingAdapter("imageUrl")
    fun bindImage(imgView: ImageView, imgUrl: String?){
        imgUrl?.let{

            // URL 문자열을 Uri 객체로 변환하고 HTTPS 스키마 사용설정하면서 객체를 빌드.
            val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()

            // imgUri 객체에서 imgView로 이미지를 로드, Coil의 load(){}를 사용한 것.
            imgView.load(imgUri){
                placeholder(R.drawable.loading_animation)
                error(R.drawable.ic_broken_image)
            }
        }
    }
}