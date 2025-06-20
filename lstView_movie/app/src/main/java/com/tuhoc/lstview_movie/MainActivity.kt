package com.tuhoc.lstview_movie

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuhoc.lstview_movie.databinding.ActivityMainBinding

private lateinit var viewBinding : ActivityMainBinding
private lateinit var customAdapter: CustomAdapter
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        var list = mutableListOf<OutData>()
        list.add(OutData(R.drawable.jjk, "Jujutsu Kaisen", "Jujutsu Kaisen is a Japanese manga series written and " +
                "illustrated by Gege Akutami. It follows Yuji Itadori, a high school student who joins a secret organization " +
                "to fight against cursed spirits."))
        list.add(OutData(R.drawable.akira, "Akira", "Akira is a Japanese cyberpunk manga series created by Katsuhiro Otomo. " +
                "Set in a post-apocalyptic Tokyo, it follows Kaneda and Tetsuo as they navigate a world of government conspiracies " +
                "and psychic powers."))
        list.add(OutData(R.drawable.zootpia, "Zootopia", "Zootopia is a 2016 American animated film produced by Walt Disney Animation Studios. " +
                "It follows Judy Hopps, a rabbit police officer, and Nick Wilde, a fox con artist, as they work together to solve a mystery in a city inhabited by anthropomorphic animals."))
        list.add(OutData(R.drawable.the_wind, "The Wind Rises", "The Wind Rises is a 2013 Japanese animated historical drama film directed by Hayao Miyazaki. " +
                "It tells the story of Jiro Horikoshi, the designer of the Mitsubishi A6M Zero " +
                "fighter aircraft used in World War II, and his dreams of aviation."))
        customAdapter = CustomAdapter(this, list)
        val lvMovie = findViewById<ListView>(R.id.lvMovie)
        lvMovie.adapter = customAdapter

        lvMovie.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, l ->
            Toast.makeText(this, "Selected: ${list[position].title}", Toast.LENGTH_SHORT).show()
           //val selectedMovie = list[position]
            // Handle item click, e.g., show a Toast or start a new Activity
            // Toast.makeText(this, "Selected: ${selectedMovie.title}", Toast.LENGTH_SHORT).show()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}