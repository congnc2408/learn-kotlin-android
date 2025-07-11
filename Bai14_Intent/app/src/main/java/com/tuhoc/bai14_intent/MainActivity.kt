package com.tuhoc.bai14_intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuhoc.bai14_intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindinng: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        bindinng = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindinng.root)

        bindinng.btnGo.setOnClickListener {
            val i = Intent(this, screen2::class.java)
            /*i.putExtra("fullName","Nguyễn Chí Công")
            i.putExtra("sex","Male")
            i.putExtra("phoneNumber", "0123456789")
            i.putExtra("married","Alone")*/
            val bundle = Bundle()
            bundle.putString("fullName", "Nguyễn Chí Công")
            bundle.putString("sex","Male")
            bundle.putString("phoneNumber", "0123456789")
            bundle.putString("married","Alone")
            i.putExtras(bundle)
            startActivity(i)
        }

        bindinng.btnGo2.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(i)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}