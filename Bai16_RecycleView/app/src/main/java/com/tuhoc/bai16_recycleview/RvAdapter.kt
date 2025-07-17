package com.tuhoc.bai16_recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuhoc.bai16_recycleview.databinding.LayoutItemBinding

class RvAdapter(var ds: List<OutData>, val onMovieClick: RvInterface) : RecyclerView.Adapter<RvAdapter.MovieViewHolder>(){
    //CLASS VIEW HOLDER
//    inner class MovieViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)
    inner class MovieViewHolder(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {
//        // You can access views directly using binding
        val imgView = binding.imgView
        val txtName = binding.txtName
        val txtDescription = binding.txtDescription
    }
    override fun getItemCount(): Int {
      return ds.size;
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
//        val binding = LayoutInflater.from(parent.context).inflate(R.layout.layout_item,parent,false)
        val binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MovieViewHolder,
        position: Int
    ) {
        val item = ds[position]
        holder.binding.apply {
            imgView.setImageResource(item.image)
            txtName.text = item.title
            txtDescription.text = item.description
        }
        holder.itemView.setOnClickListener {
            onMovieClick.OnClickView(position)
        }
//        holder.itemView.apply {
//            findViewById<android.widget.ImageView>(R.id.imgView).setImageResource(item.image)
//            findViewById<android.widget.TextView>(R.id.txt_Name).text = item.title
//            findViewById<android.widget.TextView>(R.id.txt_Description).text = item.description
//        }

//         Truy cập các View thông qua đối tượng binding của ViewHolder
//        holder.binding.imgView.setImageResource(item.image)
//        holder.binding.txtName.text = item.title
//        holder.binding.txtDescription.text = item.description
    }

}