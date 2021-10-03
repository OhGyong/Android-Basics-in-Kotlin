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

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.databinding.FragmentSummaryBinding
import com.example.cupcake.model.OrderViewModel

/**
 * 주문 사항을 요약해서 보여주는 화면.
 */
class SummaryFragment : Fragment() {

    private var binding: FragmentSummaryBinding? = null

    /**
     * fragment-ktx 라이브러리의 by activityViewModel() 코틀린 속성 위임을 사용.
     * 공유 ViewModel의 참조를 클래스 변수로 가져오기.
     */
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSummaryBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            summaryFragment = this@SummaryFragment
//            sendButton.setOnClickListener { sendOrder() }
        }
    }

    /**
     * 주문 요약 텍스트를 메일로 보내는 메서드
     */
    fun sendOrder() {

        // 주문 수량을 파악할 변수
        val numberOfCupcakes = sharedViewModel.quantity.value ?: 0 // elvis 연산자

        // string.xml 텍스트 가져오기
        val orderSummary = getString(
                R.string.order_details,
                resources.getQuantityString(R.plurals.cupcakes, numberOfCupcakes, numberOfCupcakes),
                sharedViewModel.flavor.value.toString(),
                sharedViewModel.date.value.toString(),
                sharedViewModel.price.value.toString()
        )

        // 암시적 인텐트 사용
        val intent = Intent(Intent.ACTION_SEND)
                .setType("text/plain")
                .putExtra(Intent.EXTRA_SUBJECT, getString(R.string.new_cupcake_order)) // 이메일 제목
                .putExtra(Intent.EXTRA_TEXT, orderSummary) // 이메일 본문

        // 인텐트로 Activity 실행 전에 처리할 수 있는 앱이 있는지 확인
        if (activity?.packageManager?.resolveActivity(intent, 0) != null) {
            startActivity(intent)
        }
    }


    /**
     * cancel 버튼의 리스너 추가
     */
    fun cancelOrder() {
        sharedViewModel.resetOrder() // 취소 버튼시 데이터 초기화
        findNavController().navigate(R.id.action_summaryFragment_to_startFragment)
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