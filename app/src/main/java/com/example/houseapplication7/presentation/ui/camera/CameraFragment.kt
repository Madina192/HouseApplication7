package com.example.houseapplication7.presentation.ui.camera

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.houseapplication7.databinding.FragmentCameraBinding

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        addElements()
    }

    private fun addElements() {
        cameraViewModel.getCameras().observe(requireActivity()) { cameras ->
            if (cameras != null) {
                adapter.setList(cameras)
                Log.e(ContentValues.TAG, "cameras: $cameras") //just to check
            }
        }
    }
}