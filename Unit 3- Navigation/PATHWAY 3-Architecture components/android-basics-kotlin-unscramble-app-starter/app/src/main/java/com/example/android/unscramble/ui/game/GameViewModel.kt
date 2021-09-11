package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() { // ViewModel은 추상 클래스

    private var score = 0
    private var currentWordCount = 0

    private var wordsList: MutableList<String> = mutableListOf() // 문제로 사용한 단어 리스트
    private lateinit var currentWord: String // 현재 단어

    /**
     * private로 _currentScrambledWord의 이 클래스에서만 수정할 수 있도록 처리하고
     * 외부 클래스에서 이 변수를 사용할 때 currentScrambledWord의 get() 메서드를 통해 처리한다.
     */
    private lateinit var _currentScrambledWord: String
    val currentScrambledWord: String
        get() = _currentScrambledWord

    /**
     * 전역 변수 선언 이후에 init을 실행해야 에러 안남
     */
    init {
        Log.d("GameFragment", "GameViewModel created")
        getNextWord()
    }


    /**
     * 게임 중 같은 단어가 두 번 표시되지 않도록 설정
     * 랜덤으로 섞인 단어가 원래의 단어랑 같을 경우 처리
     */
    private fun getNextWord() {
        currentWord = allWordsList.random() // allWordList에서 랜덤으로 단어를 가져옴
        val tempWord = currentWord.toCharArray() // 가져온 단어를 문자열 배열로 변환
        tempWord.shuffle() // 문자열 배열로 변환한 것을 shuffle()로 글자 순서를 섞어준다.

        // 섞인 단어가 원래으니 단어랑 일치하지 않도록 처리
        while (tempWord.toString().equals(currentWord, false)) {
            tempWord.shuffle()
        }

        // 게임 중 같은 단어가 두 번 표시되지 않도록 처리
        if (wordsList.contains(currentWord)) {
            getNextWord() // 포함되면 getNextWord()를 다시 호출하여 단어가 겹치지 않도록 처리.
        } else {
            _currentScrambledWord = String(tempWord) // 섞은 단어를 표시하도록 바꿔주고
            ++currentWordCount // 단어 개수를 늘린다.
            wordsList.add(currentWord) // 단어를 리스트에 추가한다.
        }
    }

    /**
     * ViewModel 내의 데이터를 처리하고 수정하는 도우미 메서드
     */
    fun nextWord(): Boolean {
        return if (currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }


    /**
     * ViewModel이 소멸되기 직전에 호출되는 메서드
     */
    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")

    }

}