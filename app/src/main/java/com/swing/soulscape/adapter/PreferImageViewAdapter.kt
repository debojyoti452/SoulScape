package com.swing.soulscape.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swing.soulscape.R
import com.swing.soulscape.db.models.PreferModel

class PreferImageViewAdapter constructor(
    private val imageList: List<PreferModel>
) :
    RecyclerView.Adapter<PreferImageViewAdapter.PreferImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreferImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_prefer_image_view, parent, false)
        return PreferImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: PreferImageViewHolder, position: Int) {
        val data = imageList[position]

        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    inner class PreferImageViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val imageView = itemView.findViewById<View>(R.id.preferItemImageView)

        fun bind(data: PreferModel) {
            data.image?.let { imageView.setBackgroundResource(it) }
        }
    }

}

