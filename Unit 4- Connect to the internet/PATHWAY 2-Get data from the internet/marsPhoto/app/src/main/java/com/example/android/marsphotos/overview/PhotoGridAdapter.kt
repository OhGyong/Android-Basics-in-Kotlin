package com.example.android.marsphotos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.MarsPhoto

class PhotoGridAdapter :
    ListAdapter<MarsPhoto, PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallback) {

    /**
     * RecyclerView.ViewHolder를 확장하는 MarsPhotoViewHolder의 내부 클래스 정의를 추가.
     * MarsPhoto를 레이아웃에 결합하기 위한 GridViewItemBinding 변수가 필요하기 때문에 이 변수를 MarsPhotoViewHolder에 전달.
     * MarsPhotoViewHolder에서 MarsPhoto 객체를 인수로 사용하고 binding.proferty를 이 객체로 설정.
     */
    class MarsPhotoViewHolder(private var binding: GridViewItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(MarsPhoto: MarsPhoto) {
            binding.photo = MarsPhoto
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }
    }

    /**
     * GridViewItemBinding을 확장하고 상위 ViewGroup 컨텍스트의 LayoutInflater를 사용하여 생성된 새 MarsPhotoViewHolder를 반환
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotoViewHolder {
        return MarsPhotoViewHolder(GridViewItemBinding.inflate(
                LayoutInflater.from(parent.context)))
    }

    /**
     * getItem()을 호출하여 현재 RecyclerView 위치와 연결된 MarsPhoto 객체를 가져온 다음 이 속성을 MarsPhotoViewHolder의 bind() 메서드에 전달
     */
    override fun onBindViewHolder(holder: MarsPhotoViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }

}