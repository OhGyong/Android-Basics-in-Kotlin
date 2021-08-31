package com.example.wordsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.FragmentWordListBinding

class WordListFragment : Fragment() {

    /**
     * companion 객체 생성
     */
    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    private var _binding: FragmentWordListBinding? = null // 바인딩 객체 null 초기화
    private val binding get() = _binding!! // null이 아닌 바인딩 객체 변수 선언

    private lateinit var recyclerView: RecyclerView // RecyclerView 객체 생성

    private lateinit var letterId: String

    /**
     * Fragment가 인스턴스화 되었고, CREATED 상태이다.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            letterId = it.getString(LETTER).toString()
        }
    }

    /**
     * 이 메서드에서 레이아웃을 확장한다. Fragment가 CREATED 상태로 전환된다.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    /**
     * 뷰가 만들어진 후 호출된다. 이 메서드에서 일반적으로 findViewById()를 호출하여 특정 뷰를 속성에 바인딩한다.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = WordAdapter(letterId, requireContext())

        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
    }

    /**
     * Fragment가 DESTROYED 상태로 전환되기 직전에 호출된다. 뷰는 메모리에서 이미 삭제되었지만 Fragment 객체는 존재한다.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // 뷰가 없기 때문에 null로 초기화 시켜준다.
    }

}