package com.tuhoc.bai16_3_recycleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.tuhoc.bai16_3_recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        xuLy()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun xuLy() {
        var ds = mutableListOf<Int>()
        ds.add(R.drawable.jjk)
        ds.add(R.drawable.akira)
        ds.add(R.drawable.gintama)
        ds.add(R.drawable.zootpia)
        ds.add(R.drawable.sakamoto_day)
        ds.add(R.drawable.one_punch_man)
        ds.add(R.drawable.beelzebub)
        ds.add(R.drawable.sogeking_soma_p1)

        val adaptervv = RvAdapter(ds)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.adapter = adaptervv
    }
}