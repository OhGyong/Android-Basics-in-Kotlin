package com.example.android.unscramble.ui.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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
        binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment, container,false) // 데이터 바인딩 사용
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

        // 레이아웃에 data binding을 설정해놨던 것을 초기화 시켜준다.
        binding.gameViewModel = viewModel
        binding.maxNoOfWords = MAX_NO_OF_WORDS

        // LiveData는 생명 주기를 인식하며 식별 가능하기 때문에 레이아웃에 생명 주기 소유자를 전달해야한다.
        binding.lifecycleOwner = viewLifecycleOwner

        binding.submit.setOnClickListener { onSubmitWord() }
        binding.skip.setOnClickListener { onSkipWord() }

        // viewModel의 score를 UI에 연결
        viewModel.score.observe(viewLifecycleOwner,
                { newScore ->
                    binding.score.text = getString(R.string.score, newScore)
                })

        // LiveData의 UI를 연결
        viewModel.currentScrambledWord.observe(viewLifecycleOwner,
                { newWord -> // 두 번째 매개변수로 람다를 추가, newWord는 글자가 뒤섞인 새 단어값이 포함된다.
                    binding.textViewUnscrambledWord.text = newWord
                })

        // viewModel의 currentWordCount를 UI에 연결
        viewModel.currentWordCount.observe(viewLifecycleOwner,
                { newWordCount ->
                    binding.wordCount.text =
                            getString(R.string.word_count, newWordCount, MAX_NO_OF_WORDS)
                })
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
            if (!viewModel.nextWord()) {
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
                .setMessage(getString(R.string.you_scored, viewModel.score.value)) // 대화상자의 메시지 설정
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
}
