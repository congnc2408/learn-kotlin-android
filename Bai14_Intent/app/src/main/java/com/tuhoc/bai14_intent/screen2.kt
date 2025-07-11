package com.tuhoc.bai14_intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuhoc.bai14_intent.databinding.ActivityScreen2Binding

class screen2 : AppCompatActivity() {
    private  lateinit var binding: ActivityScreen2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen2)
        binding = ActivityScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get data from intent
        val i = intent
        /*val fullName = i.getStringExtra("fullName")
        val sex = i.getStringExtra("sex")
        val phoneNumber = i.getStringExtra("phoneNumber")
        val married = i.getStringExtra("married")*/
        val bundle = i.extras
       if (bundle != null){
           val fullName = bundle?.getString("fullName")
           val sex = bundle?.getString("sex")
           val phoneNumber = bundle?.getString("phoneNumber")
           val married = bundle?.getString("married")
           binding.editTextId.setText(fullName+"\n" +sex+"\n" +phoneNumber+"\n"+married)
       }



        binding.btnBack.setOnClickListener {
            val  intent = Intent(this, Screen3 ::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}