package com.example.houseapplication7.presentation.ui.door

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.houseapplication7.R
import com.example.houseapplication7.databinding.ItemDoorBinding
import com.example.houseapplication7.domain.models.DoorModel

open class DoorAdapter : RecyclerView.Adapter<DoorAdapter.DoorViewHolder>() {

    private var list = listOf<DoorModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(model: List<DoorModel>) {
        list = model
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorViewHolder {
        return DoorViewHolder(
            ItemDoorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DoorViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class DoorViewHolder(private val binding: ItemDoorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(door: DoorModel) {
            with(binding) {
                tvName.text = door.name
                ivFavIcon.setOnClickListener {
                    if (door.isFavourite) {
                        ivFavIcon.setImageResource(R.drawable.icon_star_empty)
                    } else {
                        ivFavIcon.setImageResource(R.drawable.icon_star_full)
                    }
                    door.isFavourite = !door.isFavourite
                }
            }
        }
    }
}