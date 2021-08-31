package com.example.wordappstarter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordappstarter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  recyclerView: RecyclerView
    private var isLinearLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater) // 바인딩 객체 추가
        setContentView(binding.root) // 뷰 계층의 루트를 화면에 세팅


        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this) // layoutManager로 항목을 정렬처리
        recyclerView.adapter = LetterAdapter()

        chooseLayout()
    }

    private fun chooseLayout(){
        if(isLinearLayoutManager){
            recyclerView.layoutManager = LinearLayoutManager(this)
        } else{
            recyclerView.layoutManager = GridLayoutManager(this, 4)
        }
        recyclerView.adapter = LetterAdapter()
    }

    private fun setIcon(menuItem: MenuItem?){
        if(menuItem == null)
            return

        menuItem.icon =
            if(isLinearLayoutManager)
                ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this,R.drawable.ic_linear_layout)
    }

    /**
     * 옵션 메뉴를 확장하여 추가 설정을 실행
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)

        return true
    }

    /**
     * 메뉴의 버튼이 선택될 때 이벤트 처리를 한다. 실제로 chooseLayout()을 호출
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