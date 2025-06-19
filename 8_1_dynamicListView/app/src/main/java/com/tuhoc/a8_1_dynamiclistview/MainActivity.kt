package com.tuhoc.a8_1_dynamiclistview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuhoc.a8_1_dynamiclistview.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding:  ActivityMainBinding
class MainActivity : AppCompatActivity() {
    var lst: MutableList<String> = mutableListOf("Item 1", "Item 2", "Item 3")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Initialize View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lvDynamicText.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, lst)
        addEvents()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun addEvents() {
      //Add item
        binding.btnSubmit.setOnClickListener {
            SaveRequestTest()
        }
    }

    private fun SaveRequestTest() {
        var stringText :String = binding.edtInput.text.toString();
        if (stringText.isNotEmpty()) {
            lst.add(stringText)
            binding.lvDynamicText.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, lst)
            binding.edtInput.text.clear()
        }
    }
}


