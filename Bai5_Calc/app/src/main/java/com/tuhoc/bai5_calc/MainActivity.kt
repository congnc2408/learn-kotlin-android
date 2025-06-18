package com.tuhoc.bai5_calc

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val edtA = findViewById<android.widget.EditText>(R.id.edtA)
        val edtB = findViewById<android.widget.EditText>(R.id.edtB)
        val edtResult = findViewById<android.widget.EditText>(R.id.edtResult)
        val btnAdd = findViewById<android.widget.Button>(R.id.btnAdd)
        val btnSub = findViewById<android.widget.Button>(R.id.btnSubtract)
        val btnMultiple = findViewById<android.widget.Button>(R.id.btnMultiply)
        val btnDivide = findViewById<android.widget.Button>(R.id.btndivide)
        val btnReset = findViewById<android.widget.Button>(R.id.btnReset)
        val btnLongClick = findViewById<android.widget.Button>(R.id.btnLongClick)
        val btnExit = findViewById<android.widget.Button>(R.id.btnExit)

        btnAdd.setOnClickListener {
            val a = edtA.text.toString().toInt()
            val  b = edtB.text.toString().toInt()
            val kq = a + b
            edtResult.setText(kq.toString())
        }
        btnReset.setOnClickListener {
            edtA.text.clear()
            edtB.text.clear()
            edtResult.text.clear()
            btnLongClick.visibility = View.VISIBLE // make button visible again
            Toast.makeText(this, "data reseted", Toast.LENGTH_SHORT).show()
        }
        btnSub.setOnClickListener {
            val a = edtA.text.toString().toInt()
            val  b = edtB.text.toString().toInt()
            val kq = a - b
            edtResult.setText(kq.toString())
        }

        btnExit.setOnClickListener {
            Toast.makeText(this, "Fuck you!!!!", Toast.LENGTH_SHORT).show()
            finish() // close the app
        }

        // create share action : 1 variable can be shared than 2 view
        var shareAction : View.OnClickListener? = null
        shareAction = View.OnClickListener{
            if (it == btnMultiple){
                val a = edtA.text.toString().toInt()
                val b = edtB.text.toString().toInt()
                val kq = a * b
                edtResult.setText(kq.toString())
                Toast.makeText(this, "Share action clicked", Toast.LENGTH_SHORT).show()
            }else if (it == btnDivide) {
                val a = edtA.text.toString().toDouble()
                val b = edtB.text.toString().toDouble()
                if (b != 0.0) {
                    val kq = a / b
                    edtResult.setText(kq.toString())
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                }
            }

        }
        btnMultiple.setOnClickListener (shareAction)
        btnDivide.setOnClickListener (shareAction)
        //long click action
        var btnLongClickAction: View.OnLongClickListener? = null
        btnLongClickAction = View.OnLongClickListener{
            if (it == btnLongClick){
                Toast.makeText(this, "Button Long Clicked", Toast.LENGTH_SHORT).show()
                btnLongClick.visibility = View.GONE // disvisible button
            }
            true // return true to indicate that the long click was handled
        }
        btnLongClick.setOnLongClickListener(btnLongClickAction)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}