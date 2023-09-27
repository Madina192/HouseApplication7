package com.example.houseapplication7.presentation.ui.camera

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.houseapplication7.R
import com.example.houseapplication7.data.models.Camera
import com.example.houseapplication7.databinding.ItemCameraBinding

open class CameraAdapter : Adapter<CameraAdapter.CameraViewHolder>() {

    private var list = mutableListOf<Camera>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(model: List<Camera>) {
        list = model as MutableList<Camera>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraViewHolder {
        return CameraViewHolder(
            ItemCameraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class CameraViewHolder(private val binding: ItemCameraBinding) :
        ViewHolder(binding.root) {
        fun onBind(camera: Camera) {
            with(binding) {
                tvName.text = camera.name
                Glide.with(ivCamera).load(camera).into(ivCamera)
                ivFavIcon.setOnClickListener {
                    if (camera.isFavourite) {
                        ivFavIcon.setImageResource(R.drawable.icon_star_empty)
                    } else {
                        ivFavIcon.setImageResource(R.drawable.icon_star_full)
                    }
                    camera.isFavourite = !camera.isFavourite
                }
            }
        }
    }
}