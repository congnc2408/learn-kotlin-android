package com.tuhoc.bai6viewbinding

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuhoc.bai6viewbinding.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addEvens()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun addEvens() {
        binding.btnClick.setOnClickListener {
            HobbiesListener()
        }
        binding.btnAuthorize.setOnClickListener {
            sexListener();
        }
    }
}

private fun MainActivity.sexListener() {
    if (binding.radMale.isChecked) {
        Toast.makeText(this, "Bạn đã chọn giới tính Nam", Toast.LENGTH_SHORT).show()
    }else if (binding.radFemale.isChecked){
        Toast.makeText(this, "Bạn đã chọn giới tính Nữ", Toast.LENGTH_SHORT).show()
    }else{
        Toast.makeText(this, "Bạn chưa chọn giới tính", Toast.LENGTH_SHORT).show()
    }
}

private fun HobbiesListener() {
    var s: String = ""
    if (binding.chkGame.isChecked) {
        s += binding.chkGame.text.toString()+", "
    }
    if (binding.chkMusic.isChecked) {
        s += binding.chkMusic.text.toString()+", "
    }
    if (binding.chkSport.isChecked) {
        s += binding.chkSport.text.toString()+", "
    }
    if (binding.chkTravel.isChecked) {
        s += binding.chkTravel.text.toString()+", "
    }
    if (binding.chkShopping.isChecked) {
        s += binding.chkShopping.text.toString()+", "
    }
    binding.edtHobbies.setTag(s)
}
