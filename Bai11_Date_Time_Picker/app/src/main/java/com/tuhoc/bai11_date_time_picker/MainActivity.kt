package com.tuhoc.bai11_date_time_picker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuhoc.bai11_date_time_picker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    val today = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val startHour = today.get(Calendar.HOUR_OF_DAY)
        val startMinute = today.get(Calendar.MINUTE)

        //set the time  when click on the button
        binding.ibtnTime.setOnClickListener {
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener{ timePicker, hourOfDay, minute ->
                binding.txtTime.setText("$hourOfDay:$minute")
            },
                startHour,
               startMinute,
                false).show()
        }
        binding.ibtnCalendar.setOnClickListener {
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
                binding.txtDate.setText("$dayOfMonth/${month + 1}/$year")
            },
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH)).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}