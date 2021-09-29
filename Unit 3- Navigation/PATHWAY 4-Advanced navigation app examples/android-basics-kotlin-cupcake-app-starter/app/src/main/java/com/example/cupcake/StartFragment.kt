package com.example.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.databinding.FragmentStartBinding
import com.example.cupcake.model.OrderViewModel

/**
 * 앱에 표시되는 첫 번째 화면.
 */
class StartFragment : Fragment() {

    private var binding: FragmentStartBinding? = null

    /**
     * fragment-ktx 라이브러리의 by activityViewModel() 코틀린 속성 위임을 사용.
     * 공유 ViewModel의 참조를 클래스 변수로 가져오기.
     */
    private val sharedViewModel: OrderViewModel by activityViewModels()


    /**
     * 레이아웃을 확장하는 메서드.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    /**
     * 뷰가 만들어진 후 호출되는 메서드. 특정 뷰를 속성에 바인딩한다.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.startFragment = this

//        binding?.apply {
//            orderOneCupcake.setOnClickListener { orderCupcake(1) }
//            orderSixCupcakes.setOnClickListener { orderCupcake(6) }
//            orderTwelveCupcakes.setOnClickListener { orderCupcake(12) }
//        }
    }

    /**
     * 주문 버튼 클릭 시 fragment_flavor로 이동하게 하는 메서드
     */
    fun orderCupcake(quantity: Int) {
        sharedViewModel.setQuantity(quantity)

        // 맛이 설정되어 있지 않다면 기본 맛을 바닐라로 설정.
        if (sharedViewModel.hasNoFlavorSet()) {
            sharedViewModel.setFlavor(getString(R.string.vanilla))
        }
        findNavController().navigate(R.id.action_startFragment_to_flavorFragment) // fragment 이동
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