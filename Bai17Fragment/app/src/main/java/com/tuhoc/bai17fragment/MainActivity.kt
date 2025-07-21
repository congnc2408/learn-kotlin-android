package com.tuhoc.bai17fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuhoc.bai17fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val subLemon = FragmentLemon()
        val subMango = FragmentMango()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flContainer, subLemon)
            commit()
        }

        binding.btnLemon.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flContainer, subLemon)
                commit()
            }
        }
        binding.btnMango.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flContainer, subMango)
                commit()
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}