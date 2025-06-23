package com.tuhoc.bai9_2_customspinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuhoc.bai9_2_customspinner.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // initialize custom spinner
        setupSpinnerFruit()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun setupSpinnerFruit() {
       var listFruit2 = mutableListOf<Fruit>()
        listFruit2.add(Fruit(R.drawable.fruit_orange, "Orange"))
        listFruit2.add(Fruit(R.drawable.apple_icon, "Apple"))
        listFruit2.add(Fruit(R.drawable.grape_icon, "Grape"))
        listFruit2.add(Fruit(R.drawable.lemon_icon, "Lemon"))
        listFruit2.add(Fruit(R.drawable.mango_icon, "Mango"))
        listFruit2.add(Fruit(R.drawable.mangosteen_icon, "Mangosteen"))
        listFruit2.add(Fruit(R.drawable.strawberry_icon, "Strawberry"))
        val Fruits = CustomSpinnerFruit(this, listFruit2)
        binding.spImg.adapter = Fruits

        binding.spImg.onItemSelectedListener = object :  AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity,
                    "You selected: ${listFruit2[position].title}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}