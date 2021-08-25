package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adpter.ItemAdapter
import com.example.affirmations.data.Datasource
import org.w3c.dom.Text
import javax.sql.DataSource

/**
 * Datasource에서 데이터를 가져와 각 Affirmation을 RecyclerView에 항목으로 표시할 수 있도록 형식을 지정
 * Datasource의 loadAffirmations()으로 반환된 내용을 Affirmation에서 사용하기 위해 Adapter에서 Affirmation 객체 인스턴스를 조정한다.(Affirmation 인스턴스를 가져와 목록 항목 뷰로 전환, 화면에 데이터를 표시하는 법 정의)
 * ItemAdapter 클래스를 사용하도록 recyclerView에 알린다.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = Datasource().loadAffirmations()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)
        recyclerView.setHasFixedSize(true)
    }
}