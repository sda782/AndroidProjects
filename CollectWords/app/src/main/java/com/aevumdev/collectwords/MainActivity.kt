package com.aevumdev.collectwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aevumdev.collectwords.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val Listofwords = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.btnSaveWord.setOnClickListener {
            val text = binding.inputField.text.trim().toString()
            if (text.isEmpty()){
                binding.inputField.error = "Empty input"
                return@setOnClickListener
            }
            Listofwords.add(text)
            binding.inputField.text.clear()
        }
        binding.btnShowWords.setOnClickListener {
            binding.textView.text = Listofwords.toString()
        }
        binding.btnClearWords.setOnClickListener {
            Listofwords.clear()
            binding.textView.text = ""
        }
    }
}