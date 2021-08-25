package com.example.wordappstarter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordappstarter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater) // 바인딩 객체 추가
        setContentView(binding.root) // 뷰 계층의 루트를 화면에 세팅


        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this) // layoutManager로 항목을 정렬처리
        recyclerView.adapter = LetterAdapter()


    }
}