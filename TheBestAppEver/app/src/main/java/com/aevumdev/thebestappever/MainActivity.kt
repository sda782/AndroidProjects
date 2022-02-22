package com.aevumdev.thebestappever

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.text.set
import com.aevumdev.thebestappever.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.btnLowercase.setOnClickListener {
            val text = binding.textEdit.text.trim().toString()
            if (text.isEmpty()){
                binding.textEdit.error = "No Input!"
                return@setOnClickListener
            }
            binding.textView.text = text.lowercase()
        }

        binding.btnUppercase.setOnClickListener {
            val text = binding.textEdit.text.trim().toString()
            if (text.isEmpty()){
                binding.textEdit.error = "No Input!"
                return@setOnClickListener
            }
            binding.textView.text = text.uppercase()
        }

        binding.btnReverse.setOnClickListener {
            val text = binding.textEdit.text.trim().toString()
            if (text.isEmpty()){
                binding.textEdit.error = "No Input!"
                return@setOnClickListener
            }
            binding.textView.text = text.reversed()
        }

        binding.btnCap.setOnClickListener {
            val text = binding.textEdit.text.trim().toString()
            if (text.isEmpty()){
                binding.textEdit.error = "No Input!"
                return@setOnClickListener
            }
            binding.textView.text = text.replaceFirstChar {it.uppercase()}
        }
    }
}