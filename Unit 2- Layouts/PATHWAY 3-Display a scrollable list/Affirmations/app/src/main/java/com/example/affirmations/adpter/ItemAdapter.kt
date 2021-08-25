package com.example.affirmations.adpter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

/**
 * 확인 목록을 Adapter에 전달할 수 있도록 ItemAdapter의 생성자에 매개변수를 추가해야 한다.
 * ItemAdapter에는 문자열 리소스를 확인하는 방법에 관한 정보가 필요하고, 이러한 정보와 기타 정보는 ItemAdapter 인스턴스에 전달할 수 있는 Context 객체 인스턴스에 저장된다.
 * RecyclerView.Adapter에서 ItemAdapter를 확장하는 코드를 추가하여 어댑터 메서드를 재정의힌다.
 */
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    /**
     * RecyclerView가 뷰와 직접 상호작용하지 않고 ViewHolder를 통해 처리하기 때문에 생성자 매개변수로 view가 있다.
     */
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /**
     * RecyclerView의 새 ViewHolder 를 만들기 위해 레이아웃 관리자가 onCreateViewHolder를 호출한다.
     * parent 매개변수는 새 목록 항목 뷰가 하위 요소로 사용되어 연결되는 뷰 그룹이다. 상위 요소는 RecyclerView.
     * viewType 매개변수는 RecyclerView에 항목 뷰 유형이 여러 개 있을 수 있는데, 동일한 항목 뷰 유형을 가진 뷰만 재활용할 수 있게 한다.
     * adapterLayout이라는 변수에 목록 항목 뷰의 참조를 보유하게한 뒤, 루트 뷰가 adapterLayout인 새로운 ItemViewHolder 인스턴스를 반환한다.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // adapterLayout이 목록 항목 뷰의 참조를 보유하도록 설정(TextView 같은 하위 뷰를 찾을 수 있음)
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * 목록 항목 뷰의 콘텐츠를 바꾸기 위해 레이아웃 관리자가 호출한다.
     * holder 매개변수는 onCreateViewHolder() 메서드에서 생성된 ItemViewHolder 이다.
     * position 매개변수는 현재 항목 position을 나타내는 Int 이다.
     * position을 기반으로 데이터 세트에서 올바른 Affirmation 객체를 찾는다.
     * 올바른 데이터를 반영하도록 뷰 홀더가 참조하는 모든 뷰를 업데이트해야 한다.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position] // Affirmation 객체를 찾는다.
        holder.textView.text = context.resources.getString(item.stringResourceId) // 현재 context 의 text 를 Affirmation 문자열로 표시하도록 설정
        holder.imageView.setImageResource(item.imageResourceId)
    }


    /**
     * 데이터 세트의 크기를 반환하는 메서드
     * 데이터는 ItemAdapter 생성자인 dataset 속성에 있다.
     */
    override fun getItemCount() = dataset.size

//    아래 코드를 간결하게 표현한 것이 위의 코드
//    override fun getItemCount(): Int {
//        return dataset.size
//    }

}