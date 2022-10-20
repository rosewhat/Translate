package com.rosewhat.translate.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rosewhat.translate.R
import com.rosewhat.translate.databinding.FragmentHomeBinding
import java.lang.RuntimeException


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeText()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun changeText() {
        binding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                binding.etPassword.removeTextChangedListener(this)
                val mapping = mapOf(
                    "Й" to "Q",
                    "Ц" to "W",
                    "У" to "E",
                    "К" to "R",
                    "Е" to "T",
                    "Н" to "Y",
                    "Г" to "U",
                    "Ш" to "I",
                    "Щ" to "O",
                    "З" to "P",
                    "Х" to "[",
                    "Ъ" to "]",

                    "Ф" to "A",
                    "Ы" to "S",
                    "В" to "D",
                    "А" to "F",
                    "П" to "G",
                    "Р" to "H",
                    "О" to "J",
                    "Л" to "K",
                    "Д" to "L",
                    "Ж" to ";",
                    "Э" to "'",

                    "Я" to "Z",
                    "Ч" to "X",
                    "С" to "C",
                    "М" to "V",
                    "И" to "B",
                    "Т" to "N",
                    "Ь" to "M",
                    "Б" to ",",
                    "Ю" to ".",


                    )
                var text = s.toString()
                for ((a, b) in mapping) {
                    text = text.replace(a, b).replace(a.lowercase(), b.lowercase())
                }
                s.replace(0, s.length, text)
                binding.etPassword.addTextChangedListener(this)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        })

    }
}