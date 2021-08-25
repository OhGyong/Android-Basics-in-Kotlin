package com.example.wordappstarter

import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

/**
 * LetterAdapter는 MainActivity의 RecyclerView에서 사용한다.
 * RecyclerView의 Adapter 메서드를 재정의하기 위해 상속받는다.
 */
class LetterAdapter : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>(){

    // A에서 Z까지 배열로 만든다.
    private val list = ('A').rangeTo('Z').toList()

    /**
     * RecyclerView가 view와 직접 상호작용하지 않고 매개변수 view를 사용하여 ViewHolder로 처리한다.
     */
    class LetterViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.button_item)
    }

    /**
     * 재정의할 메서드에 LetterViewHorder를 상속하여 뷰를 연결한다.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        layout.accessibilityDelegate = Accessibility
        return LetterViewHolder(layout)

    }

    /**
     * view의 콘텐츠를 바꾸는 메서드
     */
    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = list.get(position)
        holder.button.text = item.toString()
        holder.button.setOnClickListener {
            val context = holder.view.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.LETTER, holder.button.text.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    // Setup custom accessibility delegate to set the text read with
    // an accessibility service
    companion object Accessibility : View.AccessibilityDelegate() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onInitializeAccessibilityNodeInfo(
            host: View?,
            info: AccessibilityNodeInfo?
        ) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            // With `null` as the second argument to [AccessibilityAction], the
            // accessibility service announces "double tap to activate".
            // If a custom string is provided,
            // it announces "double tap to <custom string>".
            val customString = host?.context?.getString(R.string.look_up_words)
            val customClick =
                AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK,
                    customString
                )
            info?.addAction(customClick)
        }
    }
}
