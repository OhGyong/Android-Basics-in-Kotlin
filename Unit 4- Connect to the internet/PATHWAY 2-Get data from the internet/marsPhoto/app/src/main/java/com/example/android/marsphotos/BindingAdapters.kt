package com.example.android.marsphotos

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.marsphotos.network.MarsPhoto
import com.example.android.marsphotos.overview.MarsApiStatus
import com.example.android.marsphotos.overview.PhotoGridAdapter

/**
 * 앱 전반에 사용하는 Binding Adapter
 */


/**
 * MarsPhoto 객체 목록으로 PhotoGridAdapter를 초기화.
 * BindingAdapter를 사용하여 RecyclerView 데이터를 설정하면 데이터 결합이 자동으로 MarsPhoto 객체 목록의 LiveData를 관찰하고
 * MarsPhoto 목록이 변경되면 결합 어댑터가 자동으로 호출.
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MarsPhoto>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data) // 화성 사진 목록 데이터가 포함된 것을 호출
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {

        // URL 문자열을 Uri 객체로 변환하고 HTTPS 스키마 사용설정하면서 객체를 빌드.
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()

        // imgUri 객체에서 imgView로 이미지를 로드, Coil의 load(){}를 사용한 것. 후행람다 사용.
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("marsApiStatus")
fun bindStatus(
    statusImageView: ImageView,
    status: MarsApiStatus?
) {
    when (status) {
        MarsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        MarsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        MarsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}
