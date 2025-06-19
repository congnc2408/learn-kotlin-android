package com.tuhoc.bai8_1_listview

import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuhoc.bai8_1_listview.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Initialize View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //add event listener for button
        addEvents()
        //test listview
        var blueC = Color.parseColor("#2196F3")
        binding.lvCountries.setBackgroundColor(blueC)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun addEvents() {
        viewToCounties()

    }

    private fun viewToCounties() {
        // Get the resources
        var arrCountries = resources.getStringArray(R.array.countries)
        // Set the adapter for the ListView
        binding.lvCountries.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrCountries)

        // Set the click listener for the ListView
        binding.lvCountries.setOnItemClickListener{ parent, view, i, id ->
            // Get the selected item

            // Show a toast message with the selected item
            Toast.makeText(this, "Selected: "+ arrCountries[i], Toast.LENGTH_SHORT).show()
        }

    }
}
