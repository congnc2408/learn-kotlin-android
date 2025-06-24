package com.tuhoc.bai10_gridview

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView

class MovieGridView (val activity: Activity, val list: List<Movie>) : ArrayAdapter<Movie>(activity,R.layout.layout_item) {
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val context = activity.layoutInflater
        val rowView = context.inflate(R.layout.layout_item,parent,false)
        val images = rowView.findViewById<ImageView>(R.id.imgMovie)
        val titles = rowView.findViewById<android.widget.TextView>(R.id.txt_title)

        images.setImageResource(list[position].image)
        titles.text = list[position].title
        return rowView
    }

    override fun getCount(): Int {
        return list.size
    }
}