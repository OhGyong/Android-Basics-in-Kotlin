package com.example.wordsapp

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.FragmentLetterListBinding

class LetterListFragment : Fragment() {

    private var _binding: FragmentLetterListBinding? = null // Fragment 뷰 바인딩 객체 생성, null로 초기화 시켜놔야 함
    private val binding get() = _binding!! // null이 아닌 바인딩 속성을 다시 지정 -> view로 사용

    private lateinit var recyclerView: RecyclerView // RecyclerView 객체 생성

    private var isLinearLayoutManager = true // 옵션 메뉴에서 grid로 할지 linear로 할지 정할 변수


    /**
     * Fragment가 인스턴스화 되었고, CREATED 상태이다.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    /**
     * 이 메서드에서 레이아웃을 확장한다. Fragment가 CREATED 상태로 전환된다.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 레이아웃을 확장하여 뷰를 반환한다.
        _binding = FragmentLetterListBinding.inflate(inflater, container, false) // FragmentLetterListBinding은 자동으로 생성된 바인딩 클래스
        return binding.root
    }

    /**
     * 뷰가 만들어진 후 호출된다. 이 메서드에서 일반적으로 findViewById()를 호출하여 특정 뷰를 속성에 바인딩한다.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        chooseLayout()
    }

    /**
     * Fragment가 DESTROYED 상태로 전환되기 직전에 호출된다. 뷰는 메모리에서 이미 삭제되었지만 Fragment 객체는 존재한다.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // 뷰가 없기 때문에 null로 초기화 시켜준다.
    }


    /**
     * 옵션 메뉴를 확장
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    /**
     * isLinearLayoutManager의 상태에 따라 레이아웃을 grid 또는 linear로 설정한다.
     */
    private fun chooseLayout() {
        when (isLinearLayoutManager){
            true -> {
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = LetterAdapter()
            }
            false ->{
                recyclerView.layoutManager = GridLayoutManager(context,4)
                recyclerView.adapter = LetterAdapter()
            }
        }

    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
    }

    /**
     * 옵션 메뉴 설정
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}