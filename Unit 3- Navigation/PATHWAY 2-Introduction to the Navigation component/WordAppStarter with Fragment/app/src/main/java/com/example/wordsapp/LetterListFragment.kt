package com.example.wordsapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.FragmentLetterListBinding

class LetterListFragment : Fragment() {

    private var _binding: FragmentLetterListBinding? = null // Fragment 뷰 바인딩 객체 생성, null로 초기화 시켜놔야 함
    private val binding get() = _binding!! // null이 아닌 바인딩 속성을 다시 지정 -> view로 사용

    private lateinit var recyclerView: RecyclerView // RecyclerView 객체 생성


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
    ): View? {
        // 레이아웃을 확장하여 뷰를 반환한다.
        _binding = FragmentLetterListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
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


}