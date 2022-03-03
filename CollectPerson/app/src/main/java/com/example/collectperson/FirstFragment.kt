package com.example.collectperson

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.collectperson.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val viewModel: PersonViewModel by activityViewModels()

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
        binding.addBtn.setOnClickListener {
            val name = binding.editTextTextPersonName.text.trim().toString()
            if (name.isEmpty()) {
                binding.editTextTextPersonName.error = "No name"
                return@setOnClickListener
            }
            val ageStr = binding.editTextNumber.text.trim().toString()
            if (ageStr.isEmpty()) {
                binding.editTextNumber.error = "No age"
                return@setOnClickListener
            }
            val addressStr = binding.editTextTextPostalAddress.text.trim().toString()
            if (addressStr.isEmpty()) {
                binding.editTextTextPostalAddress.error = "No address"
                return@setOnClickListener
            }
            val shoeStr = binding.editTextNumber2.text.trim().toString()
            if (ageStr.isEmpty()) {
                binding.editTextNumber2.error = "No shoe size"
                return@setOnClickListener
            }
            val person = Person(0, name, ageStr.toInt(), addressStr, shoeStr.toInt())
            val addedID = viewModel.addPerson(person)
            val snack = Snackbar.make(it,"added new Person to list",Snackbar.LENGTH_LONG)
            snack.  setAction("undo", View.OnClickListener { viewModel.UndoLast(addedID) })
            snack.show()
        }
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}