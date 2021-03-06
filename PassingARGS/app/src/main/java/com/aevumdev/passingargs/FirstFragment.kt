package com.aevumdev.passingargs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.aevumdev.passingargs.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

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

        binding.buttonFirst.setOnClickListener {
            val name = binding.editTextTextPersonName.editableText.toString()
            val age = binding.editTextNumber.editableText.toString()
            if (name.isEmpty()){
                binding.editTextTextPersonName.error = "Empty input"
                return@setOnClickListener
            }
            if (age.isEmpty()){
            binding.editTextNumber.error = "Empty input"
            return@setOnClickListener
            }
            val pers = Person(name,age.toInt())
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(name, age.toInt(), pers)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}