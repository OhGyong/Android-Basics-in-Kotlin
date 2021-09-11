package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() { // ViewModel은 추상 클래스


    /**
     * private로 _currentScrambledWord의 이 클래스에서만 수정할 수 있도록 처리하고
     * 외부 클래스에서 이 변수를 사용할 때 currentScrambledWord의 get() 메서드를 통해 처리한다.
     */
    private var _score = 0
    val score: Int
        get() = _score

    private var _currentWordCount = 0
    val currentWordCount: Int
        get() = _currentWordCount

    private lateinit var _currentScrambledWord: String
    val currentScrambledWord: String
        get() = _currentScrambledWord

    private var wordsList: MutableList<String> = mutableListOf() // 문제로 사용한 단어 리스트
    private lateinit var currentWord: String // 현재 단어


    /**
     * 전역 변수 선언 이후에 init을 실행해야 에러 안남
     */
    init {
        Log.d("GameFragment", "GameViewModel created")
        getNextWord()
    }


    /**
     * ViewModel이 소멸되기 직전에 호출되는 메서드
     */
    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")

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
            ++_currentWordCount // 단어 개수를 늘린다.
            wordsList.add(currentWord) // 단어를 리스트에 추가한다.
        }
    }


    /**
     * 게임 재시작 설정 메서드
     */
    fun reinitializeData() {
        _score = 0
        _currentWordCount = 0
        wordsList.clear()
        getNextWord()
    }


    /**
     * 점수를 높이는 메서드
     */
    private fun increaseScore() {
        _score += SCORE_INCREASE
    }


    /**
     * 단어를 맞췄을 때 점수를 증가시키고 true를 반환
     * 틀렸을 경우는 false 반환
     */
    fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }


    /**
     * ViewModel 내의 데이터를 처리하고 수정하는 도우미 메서드
     */
    fun nextWord(): Boolean {
        // 플레이한 단어 개수가 10개가 넘어가는지 체크
        return if (_currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }
}