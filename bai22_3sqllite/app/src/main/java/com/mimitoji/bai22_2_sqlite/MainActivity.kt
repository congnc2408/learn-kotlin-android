package com.mimitoji.bai22_2_sqlite

import android.content.ContentValues
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mimitoji.bai22_2_sqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var helper = DBHelper(applicationContext)
        val db = helper.readableDatabase
        val rs = db.rawQuery("SELECT * FROM User", null)

        if (rs.moveToLast()){
            Toast.makeText(applicationContext,
                "Last User: ${rs.getString(1)}, Age: ${rs.getInt(2)}",
                Toast.LENGTH_LONG).show()
        }
        binding.btnSubmit.setOnClickListener {
            var cv = ContentValues()
            cv.put("name", binding.txtUsernameInput.text.toString())
            cv.put("age", binding.txtAgeInput.text.toString())
            db.insert("USER",null,cv)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}