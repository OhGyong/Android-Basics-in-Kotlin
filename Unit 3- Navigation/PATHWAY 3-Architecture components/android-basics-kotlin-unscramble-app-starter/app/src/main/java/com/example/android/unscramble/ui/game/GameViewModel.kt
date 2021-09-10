package com.example.android.unscramble.ui.game

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() { // ViewModel은 추상 클래스

    private var score = 0
    private var currentWordCount = 0

    /**
     * private로 _currentScrambledWord의 이 클래스에서만 수정할 수 있도록 처리하고
     * 외부 클래스에서 이 변수를 사용할 때 currentScrambledWord의 get() 메서드를 통해 처리한다.
     */
    private var _currentScrambledWord = "test"
    val currentScrambledWord: String
        get() = _currentScrambledWord

}