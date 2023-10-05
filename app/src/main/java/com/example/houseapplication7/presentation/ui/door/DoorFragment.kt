package com.example.houseapplication7.presentation.ui.door

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.houseapplication7.databinding.FragmentDoorBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DoorFragment : Fragment() {
    private lateinit var binding: FragmentDoorBinding
    private val adapter = DoorAdapter()
    private val doorViewModel: DoorViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDoorBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
        addElements()
    }

    private fun addElements() {
        lifecycleScope.launch {
            doorViewModel.doorList.observe(requireActivity()) { response ->
                if (response != null) {
                    adapter.setList(response)
                }
            }
        }
    }
}