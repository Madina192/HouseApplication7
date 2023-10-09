package com.example.houseapplication7.presentation.ui.camera

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.houseapplication7.databinding.FragmentCameraBinding
import com.example.houseapplication7.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CameraFragment : Fragment() {
    private lateinit var binding: FragmentCameraBinding
    private val adapter = CameraAdapter()
    private val cameraViewModel: CameraViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCameraBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCamerasData()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getCamerasData() {
        cameraViewModel.getAllCameras()
        lifecycleScope.launch {
            cameraViewModel._cameraList.collect { state ->
                when (state) {
                    is UIState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.recyclerView.visibility = View.GONE
                    }

                    is UIState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
                        binding.recyclerView.adapter = adapter
                        adapter.notifyDataSetChanged()
                        state.data?.let { adapter.setList(it) }
                    }

                    is UIState.Empty -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), "Empty", Toast.LENGTH_SHORT).show()
                    }

                    is UIState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

}