package com.rosewhat.translate.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModelProvider
import com.rosewhat.translate.databinding.ActivityMainBinding
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        changeText()


    }

    private fun changeText() {
        binding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
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