package com.example.android.unscramble.ui.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.android.unscramble.R
import com.example.android.unscramble.databinding.GameFragmentBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * 게임 화면
 */
class GameFragment : Fragment() {

    private val viewModel: GameViewModel by viewModels() //GameViewModel 초기화
    private lateinit var binding: GameFragmentBinding // 바인딩 선언, onCreateView에서 binding을 사용하므로 lateinit 사용.

    /**
     * 바인딩을 사용하여 레이아웃 확장
     */
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = GameFragmentBinding.inflate(inflater, container, false)
        Log.d("GameFragment", "GameFragment created/re-created!")
        Log.d("GameFragment", "Word: ${viewModel.currentScrambledWord} " +
                "Score: ${viewModel.score} WordCount: ${viewModel.currentWordCount}")
        return binding.root
    }


    /**
     * view들을 바인딩하여 리스너를 설정하고, ui를 업데이트
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submit.setOnClickListener { onSubmitWord() }
        binding.skip.setOnClickListener { onSkipWord() }

        // UI 업데이트
        updateNextWordOnScreen()
        binding.score.text = getString(R.string.score, 0)
        binding.wordCount.text = getString(
                R.string.word_count, 0, MAX_NO_OF_WORDS)
    }


    /**
     * submit 버튼 클릭 리스너 메서드
     * 단어를 제출할 때 해당 단어와 원래 단어와 비교해 검증한다.
     * 단어가 옳으면 다음 단어로 이동하고 단어가 옳지 않으면 텍스트 필드에 오류를 표시하고 현재 단어를 유지한다.
     */
    private fun onSubmitWord() {

        val playerWord = binding.textInputEditText.text.toString()

        if (viewModel.isUserWordCorrect(playerWord)) {
            setErrorTextField(false)
            if (viewModel.nextWord()) {
                updateNextWordOnScreen()
            } else {
                showFinalScoreDialog()
            }
        } else {
            setErrorTextField(true)
        }
    }


    /**
     * skip 버튼의 클릭 리스너 메서드
     * 더 이상 남은 단어가 없는 경우(10개 넘어갈 경우) 최종 점수가 포함된 알림 대화상자 표시
     */
    private fun onSkipWord() {
        if (viewModel.nextWord()) {
            setErrorTextField(false)
            updateNextWordOnScreen()
        } else {
            showFinalScoreDialog()
        }
    }


    /**
     * 단어 목록에서 임의의 단어를 선택하여 섞는 메서드
     */
    private fun getNextScrambledWord(): String {
        val tempWord = allWordsList.random().toCharArray()
        tempWord.shuffle()
        return String(tempWord)
    }


    /**
     * 대화상자의 구성요소를 빌드하는 메서드
     */
    private fun showFinalScoreDialog() {
        MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.congratulations)) // 대화상자의 제목 설정
                .setMessage(getString(R.string.you_scored, viewModel.score)) // 대화상자의 메시지 설정
                .setCancelable(false) // 뒤로 키를 눌러 대화상자를 취소할 수 없도록 설정
                .setNegativeButton(getString(R.string.exit)){_, _ ->
                    exitGame() // 대화상자의 취소 버튼
                }
                .setPositiveButton(getString(R.string.play_again)){_, _->
                    restartGame() // 대화상자의 확인 버튼
                }
                .show() // 대화상자를 만들고 표시하는 기능
    }


    /**
     * 게임 재시작 메서드
     */
    private fun restartGame() {
        viewModel.reinitializeData()
        setErrorTextField(false)
        updateNextWordOnScreen()
    }


    /**
     * 앱을 종료하는 메서드
     */
    private fun exitGame() {
        activity?.finish()
    }


    /**
     * Activity와 Fragment가 소멸될 때 호출되는 메서드
     */
    override fun onDetach() {
        super.onDetach()
        Log.d("GameFragment", "GameFragment destroyed!")
    }


    /**
     * 텍스트 필드에 오류를 표시하는 메서드
     */
    private fun setErrorTextField(error: Boolean) {
        if (error) {
            binding.textField.isErrorEnabled = true
            binding.textField.error = getString(R.string.try_again)
        } else {
            binding.textField.isErrorEnabled = false
            binding.textInputEditText.text = null
        }
    }


    /**
     * 글자가 뒤섞인 새로운 단어를 표시하는 메서드
     */
    private fun updateNextWordOnScreen() {
        binding.textViewUnscrambledWord.text = viewModel.currentScrambledWord
    }
}
