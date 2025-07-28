package com.tuhoc.bai18tablayout

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.tuhoc.bai18tablayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = ViewPageAdapter(supportFragmentManager, lifecycle)
        binding.pagerDemo.adapter = adapter
        TabLayoutMediator(binding.tabDemo,binding.pagerDemo){tab,pos ->
            when(pos){
                0 -> tab.text = "MV1"
                1 -> tab.text = "MV2"
                2 -> tab.text = "MV3"
                3 -> tab.text = "MV4"
                4 -> tab.text = "MV5"
                else -> tab.text = "Unknown"
            }
        }.attach()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}