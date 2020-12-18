package com.jst.retrofitwithcoroutine.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.jst.retrofitwithcoroutine.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val word = "Hello world"
        textview.text = "正在翻译……"
        viewModel.translateSuccessResult.observe(viewLifecycleOwner){
            textview.text = "原词:    $word \n翻译:    $it"
        }
        viewModel.translateSuccess(word)



        val word1 = "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII"
        textview2.text = "正在翻译……"
        viewModel.translateFailedResult.observe(viewLifecycleOwner){
            textview2.text = "原词:    $word1 \n翻译:    $it"
        }
        viewModel.translateFailed(word1)
    }

}
