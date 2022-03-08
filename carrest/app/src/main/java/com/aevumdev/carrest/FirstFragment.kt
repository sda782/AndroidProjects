package com.aevumdev.carrest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aevumdev.carrest.databinding.FragmentFirstBinding
import com.aevumdev.carrest.models.CarViewModel
import com.aevumdev.carrest.models.GenericAdapter
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val carsViewModel: CarViewModel by activityViewModels()

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

        carsViewModel.carsLiveData.observe(viewLifecycleOwner) { cars ->
            if (cars != null){
                val gAdapter = GenericAdapter(cars){ position ->
                    val snackText = cars[position].model
                    val snack = Snackbar.make(view,snackText,Snackbar.LENGTH_LONG)
                    snack.show()
                }
                binding.carsRV.layoutManager = LinearLayoutManager(activity)
                binding.carsRV.adapter = gAdapter
            }
        }
        carsViewModel.reload()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}