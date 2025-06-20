package com.tuhoc.lstview_movie

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(val activity: Activity, val list: List<OutData>) : ArrayAdapter<OutData>(activity, R.layout.list_item) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val context = activity.layoutInflater
        val rowView = context.inflate(R.layout.list_item, parent, false)
        val images = rowView.findViewById<ImageView>(R.id.imgView)
        val title = rowView.findViewById<TextView>(R.id.txtTille)
        val description = rowView.findViewById<TextView>(R.id.txtDesc)

        title.text = list[position].title
        description.text = list[position].description
        images.setImageResource(list[position].image)
        return rowView
    }
}