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
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                binding.etPassword.removeTextChangedListener(this)
                val mapping = mapOf("q" to "й")
                var newStr = ""
                var newC = ""
                for ((key, value) in mapping) {
                    newStr = key
                    newC = value
                }
                val text = s.toString().replace(newStr, newC)
                s.replace(0, s.length, text)

                binding.etPassword.addTextChangedListener(this)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        })


    }

}