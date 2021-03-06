/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.databinding.FragmentPickupBinding
import com.example.cupcake.model.OrderViewModel

/**
 * 픽업 날짜 정하는 화면.
 */
class PickupFragment : Fragment() {

    private var binding: FragmentPickupBinding? = null

    /**
     * fragment-ktx 라이브러리의 by activityViewModel() 코틀린 속성 위임을 사용.
     * 공유 ViewModel의 참조를 클래스 변수로 가져오기.
     */
    private val sharedViewModel: OrderViewModel by activityViewModels()


    /**
     * 레이아웃을 확장하는 메서드
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentPickupBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }


    /**
     * 뷰가 만들어진 후 호출되는 메서드.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner // 생명 주기 소유자와 연결
            viewModel = sharedViewModel
            pickupFragment = this@PickupFragment
//            nextButton.setOnClickListener { goToNextScreen() }
        }
    }

    /**
     * next 버튼 클릭 시 fragment_summary로 이동하게 하는 메서드
     */
    fun goToNextScreen() {
        findNavController().navigate(R.id.action_pickupFragment_to_summaryFragment)
    }


    /**
     * cancel 버튼의 리스너 추가
     */
    fun cancelOrder() {
        sharedViewModel.resetOrder() // 취소 버튼시 데이터 초기화
        findNavController().navigate(R.id.action_pickupFragment_to_startFragment)
    }


    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}