package com.aevumdev.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.aevumdev.calculator.databinding.ActivityMainBinding
import com.aevumdev.calculator.bcd as bcd1

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.btnEqual.setOnClickListener {
            calculate()
        }
        binding.inputA.setOnKeyListener { view, i, keyEvent ->
            calculate()
            false
        }
        binding.inputB.setOnKeyListener { view, i, keyEvent ->
            calculate()
            false
        }
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                calculate()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun calculate() {
        val inputA = binding.inputA.text.trim().toString()
        val inputB = binding.inputB.text.trim().toString()
        if (inputA.isEmpty()){
            binding.inputA.error = "Enter Number"
            return
        }
        if (inputB.isEmpty()){
            binding.inputB.error = "Enter Number"
            return
        }
        doCal(inputA, inputB)
        val r = doCal(inputA, inputB)
        binding.output.text = r.toString()
    }

    private fun doCal(inputA: String, inputB: String) : Double {
        val spinner = binding.spinner
        when (spinner.selectedItem){
            "+" -> { return inputA.toDouble()+inputB.toDouble()}
            "-" -> { return inputA.toDouble()-inputB.toDouble()}
            "/" -> { return inputA.toDouble()/inputB.toDouble()}
            "x" -> { return inputA.toDouble()*inputB.toDouble()}
        }
        return 0.0
    }

}