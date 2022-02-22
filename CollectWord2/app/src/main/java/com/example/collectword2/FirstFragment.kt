package com.example.collectword2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.collectword2.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private var worldList = ArrayList<String>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddWord.setOnClickListener {
            val text = binding.inputWord.text.trim().toString()
            if (text.isEmpty()){
                binding.inputWord.error = "Empty input"
                return@setOnClickListener
            }
            worldList.add(text)
            val toastText = "Added $text"
            val duration = Toast.LENGTH_SHORT

            Toast.makeText(this.context, toastText, duration).show()

            binding.inputWord.text.clear()
        }
        binding.buttonFirst.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(worldList.toTypedArray())
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
