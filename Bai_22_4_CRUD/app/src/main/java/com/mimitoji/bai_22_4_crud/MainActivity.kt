package com.mimitoji.bai_22_4_crud

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.mimitoji.bai_22_4_crud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var db : SQLiteDatabase
    lateinit var rs: Cursor
    lateinit var adapter: SimpleCursorAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var helper = MyHelper(applicationContext)
        db = helper.readableDatabase
        rs = db.rawQuery("SELECT * FROM TUHOC",null)
        if (rs.moveToFirst()){
            binding.edtUser.setText(rs.getString(1))
            binding.edtEmail.setText(rs.getString(2))
        }

        binding.btnFirst.setOnClickListener{
            if (rs.moveToFirst()){
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            }else{
                notfounddata();
            }
        }
        binding.btnEnd.setOnClickListener{
            if (rs.moveToLast()){
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            }else{
                notfounddata();
            }
        }

        binding.btnNext.setOnClickListener {
            if (rs.moveToNext()){
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            }else{
                notfounddata();
            }
        }
        binding.btnPrevious.setOnClickListener {
            if (rs.moveToPrevious()){
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            } else{
                notfounddata();
            }
        }

        adapter = SimpleCursorAdapter(applicationContext,
            android.R.layout.simple_expandable_list_item_2,
            rs,arrayOf("NAME","PHONE"),
            intArrayOf(android.R.id.text1,android.R.id.text2),0 )




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun notfounddata(){
        binding.edtUser.setText("")
        binding.edtEmail.setText("")
        Toast.makeText(applicationContext,"No data found!", Toast.LENGTH_SHORT).show()
    }
}