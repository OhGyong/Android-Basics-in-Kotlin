package com.example.android.marsphotos.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.android.marsphotos.databinding.FragmentOverviewBinding
import com.example.android.marsphotos.databinding.GridViewItemBinding

/**
 * MainActivity에 표시되는 화면.
 * 백엔드 서버에서 받은 데이터를 표시하는 프래그먼트이다.
 * OverviewViewModel 객체 참조를 한다.
 */
class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by viewModels()

    /**
     * 데이터 바인딩으로 레이아웃을 확장하고, lifecycleOwner를 OverviewFragment로 설정한다.
     * LiveData를 관찰하도록 설정하고 어댑터를 사용하여 리사이클러 뷰를 설정한다.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)
//        val binding = GridViewItemBinding.inflate(inflater)

        /**
         * 바인딩 객체에 생명 주기 소유자를 설정
         *
         */
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel
        binding.photosGrid.adapter = PhotoGridAdapter()
        return binding.root
    }
}
