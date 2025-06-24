package com.tuhoc.bai10_gridview

import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuhoc.bai10_gridview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // setContentView(binding.gvMovies)

        val  list = mutableListOf<Movie>()
        list.add(Movie(R.drawable.jjk, "Jujutsu Kaisen"))
        list.add(Movie(R.drawable.akira, "Akira"))
        list.add(Movie(R.drawable.zootpia, "Zootopia"))
        list.add(Movie(R.drawable.the_wind, "the Wind Rises"))
        list.add(Movie(R.drawable.gintama, "Gintama"))
        list.add(Movie(R.drawable.beelzebub, "Beelzebub"))
        list.add(Movie(R.drawable.one_punch_man, "One Punch Man"))
        list.add(Movie(R.drawable.sakamoto_day, "Sakamoto Days"))
        list.add(Movie(R.drawable.sogeking_soma_p1, "Sokugeki Soma P1"))

        val customGV = MovieGridView(this, list)
        binding.gvMovies.adapter = customGV

        binding.gvMovies.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->
            val movie = list[position]
            Toast.makeText(this, "Selected: ${movie.title}", Toast.LENGTH_SHORT).show()

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}