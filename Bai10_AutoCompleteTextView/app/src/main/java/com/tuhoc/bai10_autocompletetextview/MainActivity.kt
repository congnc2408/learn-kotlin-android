package com.tuhoc.bai10_autocompletetextview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuhoc.bai10_autocompletetextview.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = resources.getStringArray(R.array.province)

        val adt = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

        binding.AutoProvince.setAdapter(adt)
        // Set the threshold to 1 to show suggestions after typing one character
        binding.AutoProvince.setOnFocusChangeListener{ view : View, hasFocus: Boolean ->
            if (hasFocus) {
                binding.AutoProvince.showDropDown()
            }
        }

        //test item seclected
        binding.AutoProvince.setOnItemClickListener({ parent, view, position, id ->
//            val selectedItem = parent.getItemAtPosition(position).toString()
//            binding.AutoProvince.setText(selectedItem, false)

            Toast.makeText(this, "Selected: ${parent.getItemAtPosition(position)}", Toast.LENGTH_SHORT).show()
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}