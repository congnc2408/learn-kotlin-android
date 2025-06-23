package com.tuhoc.bai9_2_customspinner

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomSpinnerFruit(val activity: Activity, val lstFruit: List<Fruit>) : ArrayAdapter<Fruit>(activity,R.layout.list_item) {

    override fun getCount(): Int {
        return lstFruit.size
    }

    override fun getView(
        position: Int,// Position of the item in the list
        convertView: View?,// Recycled view to reuse if available
        parent: ViewGroup// Parent view that this view will be attached to
    ): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(
        position: Int,// Position of the item in the dropdown list
        convertView: View?,// Recycled view to reuse if available
        parent: ViewGroup// Parent view that this view will be attached to
    ): View? {
        return initView(position, convertView, parent)
    }

    //view function solution

    private fun initView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ) : View {
        val context = activity.layoutInflater
        // Inflate the custom layout for the spinner item
        val rowView = context.inflate(R.layout.list_item,parent,false)
        // Get the current fruit item

        val image = rowView.findViewById<ImageView>(R.id.imgFruit)
        val txtFruit = rowView.findViewById<TextView>(R.id.txtTitle)
        image.setImageResource(lstFruit[position].image)
        txtFruit.text = lstFruit[position].title
        return rowView
    }
}