package com.swing.soulscape.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.swing.soulscape.R
import com.swing.soulscape.db.models.PreferModel

class PreferListAdapter constructor(
    private val dataList: MutableList<PreferModel>,
    private val listener: (index : Int) -> Unit
) : RecyclerView.Adapter<PreferListAdapter.PreferListVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreferListVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_prefer_button_view, parent, false)
        return PreferListVH(view)
    }

    override fun onBindViewHolder(holder: PreferListVH, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class PreferListVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemTextView = itemView.findViewById<AppCompatTextView>(R.id.itemTextView)

        fun bind(preferModel: PreferModel) {
            itemTextView.text = preferModel.name
            itemView.setOnClickListener {
                listener(adapterPosition)
            }
        }
    }
}
