package com.tuhoc.bai19_1_alertdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuhoc.bai19_1_alertdialog.databinding.ActivityMainBinding
import com.tuhoc.bai19_1_alertdialog.databinding.CustomLayoutBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTest.setOnClickListener {
//         val dialog = AlertDialog.Builder(this)
//             .setTitle("Alert Dialog")
//             .setMessage("This is an alert dialog example.")
//             .setPositiveButton("OK") { dialog, _ ->
//                 dialog.dismiss()
//             }
//             .setNegativeButton("Cancel") { dialog, _ ->
//                 dialog.dismiss()
//             }
//             .create()
//            dialog.show()
            showDialogNormal()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showDialogNormal() {
        val build = AlertDialog.Builder(this)

        val view  = layoutInflater.inflate(R.layout.custom_layout,null)
        build.setView(view)
//        val btnClose = view.findViewById<ImageButton>(R.id.btnClose)
//        val btnJoin = view.findViewById<Button>(R.id.btnJoin)
//        btnClose.setOnClickListener {
//            dialog.dismiss()
//        }
//        btnJoin.setOnClickListener {
//            Toast.makeText(this,"Joined",Toast.LENGTH_SHORT).show()
//        }
        val dialogBinding = CustomLayoutBinding.inflate(LayoutInflater.from(this))
        build.setView(dialogBinding.root)
        dialogBinding.btnJoin.setOnClickListener{
            Toast.makeText(this,"Joined",Toast.LENGTH_SHORT).show()
        }
        dialogBinding.btnClose.setOnClickListener { dialog.dismiss() }
        dialog = build.create()
        dialog.show()

    }
}