package com.tuhoc.bai6_my_wife

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuhoc.bai6_my_wife.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addEvens();

        binding.btnExit.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun addEvens() {
        binding.radTingyun.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                binding.imgWife.setImageResource(R.drawable.tinyun4star)
            }else{
                binding.imgWife.setImageResource(R.drawable.fugue)
            }
        }
        binding.radFugue.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked){
                binding.imgWife.setImageResource(R.drawable.tinyun4star)
            }else{
                binding.imgWife.setImageResource(R.drawable.fugue)
            }
        }
    }
}