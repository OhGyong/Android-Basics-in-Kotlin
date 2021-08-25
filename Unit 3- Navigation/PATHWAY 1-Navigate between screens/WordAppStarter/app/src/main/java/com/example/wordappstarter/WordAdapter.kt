package com.example.wordappstarter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

/**
 * WordApdater는 RecyclerView의 DetailActivity에서 단어 목록을 표시하는데 사용한다.
 */

class WordAdapter(private val letterId: String, context: Context) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private val filteredWords: List<String>

    /**
     * view에 표현할 단어 변수 초기화
     */
    init {
        val words = context.resources.getStringArray(R.array.words).toList()

        filteredWords = words
                .filter { it.startsWith(letterId, ignoreCase = true) }
                .shuffled()
                .take(5)
                .sorted()
    }

    class WordViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layout = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_view, parent, false)

        layout.accessibilityDelegate = LetterAdapter
        return WordViewHolder(layout)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val item = filteredWords[position]
        val context = holder.view.context

        holder.button.text = item

        holder.button.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${DetailActivity.SEARCH_PREFIX}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = filteredWords.size

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
            val customString = host?.context?.getString(R.string.look_up_word)
            val customClick =
                    AccessibilityNodeInfo.AccessibilityAction(
                            AccessibilityNodeInfo.ACTION_CLICK,
                            customString
                    )
            info?.addAction(customClick)
        }
    }

}


