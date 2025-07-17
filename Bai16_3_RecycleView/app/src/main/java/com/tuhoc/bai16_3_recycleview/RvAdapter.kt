package com.tuhoc.bai16_3_recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(private val ds: List<Int>)  : RecyclerView.Adapter<RvAdapter.itemViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): itemViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return itemViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: itemViewHolder,
        position: Int
    ) {
       val item = ds[position]
        holder.itemView.apply {
            findViewById<android.widget.ImageView>(R.id.imgView).setImageResource(item)

        }
        holder.itemView.setOnClickListener {
            // Handle item click if needed
        }
    }

    override fun getItemCount(): Int {
       return ds.size
    }

    class itemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}