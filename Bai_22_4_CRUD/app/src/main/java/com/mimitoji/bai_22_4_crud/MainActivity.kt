package com.mimitoji.bai_22_4_crud

import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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
        db = helper.writableDatabase
        rs = db.rawQuery("SELECT * FROM TUHOC",null)
        binding.edtUser.requestFocus();


//        if (rs.moveToFirst()){
//            binding.edtUser.setText(rs.getString(1))
//            binding.edtPhone.setText(rs.getString(2))
//        }

        binding.btnFirst.setOnClickListener{
            if (rs.moveToFirst()){
                binding.edtUser.setText(rs.getString(1))
                binding.edtPhone.setText(rs.getString(2))
            }else{
                notfounddata();
            }
        }
        binding.btnEnd.setOnClickListener{
            if (rs.moveToLast()){
                binding.edtUser.setText(rs.getString(1))
                binding.edtPhone.setText(rs.getString(2))
            }else{
                notfounddata();
            }
        }

        binding.btnNext.setOnClickListener {
            if (rs.moveToNext()){
                binding.edtUser.setText(rs.getString(1))
                binding.edtPhone.setText(rs.getString(2))
            }else{
                notfounddata();
            }
        }
        binding.btnPrevious.setOnClickListener {
            if (rs.moveToPrevious()){
                binding.edtUser.setText(rs.getString(1))
                binding.edtPhone.setText(rs.getString(2))
            } else{
                notfounddata();
            }
        }

        adapter = SimpleCursorAdapter(applicationContext,
            android.R.layout.simple_expandable_list_item_2,
            rs,arrayOf("NAME","PHONE"),
            intArrayOf(android.R.id.text1,android.R.id.text2),0 )
        binding.lvUser.adapter = adapter;
        binding.btnReset.setOnClickListener {
            binding.searchV.visibility = View.VISIBLE
            binding.lvUser.visibility = View.VISIBLE
            adapter.notifyDataSetChanged()
            binding.searchV.queryHint = "Search...${rs.count}"
        }

        binding.searchV.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(p0: String?): Boolean {
                rs = db.rawQuery("SELECT * FROM TUHOC WHERE NAME LIKE '%${p0}' or PHONE LIKE '%${p0}%'", null)
                adapter.changeCursor(rs)
                return true;
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false;
            }

        });
        binding.btnInsert.setOnClickListener {
            var cv = ContentValues();
            cv.put("NAME",binding.edtUser.text.toString())
            cv.put("PHONE",binding.edtPhone.text.toString())
            val newRowId = db.insert("TUHOC",null,cv);
            rs.requery();
            adapter.notifyDataSetChanged()
//            if (newRowId == -1L) {
//                // Something went wrong, show an error message.
//                // Log the error for debugging.
//                Log.e("DB_ERROR", "Error inserting data.")
//                Toast.makeText(this, "Failed to add record!", Toast.LENGTH_SHORT).show()
//            } else {
//                // Insertion was successful.
//                // Show a success message.
//                Toast.makeText(this, "Add Record Success!", Toast.LENGTH_SHORT).show()
//            }
            var ad = AlertDialog.Builder(this)
            .setTitle("Add Record")
            .setMessage("Add Record Success!")

            //DialogInterface.OnClickListener
            .setPositiveButton ("Ok", {dialog,_ ->
                binding.edtUser.setText("")
                binding.edtPhone.setText("")
                binding.edtUser.requestFocus();
                binding.lvUser.visibility = View.VISIBLE
            })
            .create()
            .show();
        }

        binding.btnUpdate.setOnClickListener {
            var cv = ContentValues();
            cv.put("NAME",binding.edtUser.text.toString())
            cv.put("PHONE",binding.edtPhone.text.toString())
            val newRowId = db.update("TUHOC",cv,"_id=?",arrayOf(rs.getString(0)));
            rs.requery();
            adapter.notifyDataSetChanged()
//            if (newRowId == -1L) {
//                // Something went wrong, show an error message.
//                // Log the error for debugging.
//                Log.e("DB_ERROR", "Error inserting data.")
//                Toast.makeText(this, "Failed to add record!", Toast.LENGTH_SHORT).show()
//            } else {
//                // Insertion was successful.
//                // Show a success message.
//                Toast.makeText(this, "Add Record Success!", Toast.LENGTH_SHORT).show()
//            }
            var ad = AlertDialog.Builder(this)
                .setTitle("Update Record")
                .setMessage("Update Record Success!")

                //DialogInterface.OnClickListener
                .setPositiveButton ("Ok", {dialog,_ ->
                    binding.edtUser.setText("")
                    binding.edtPhone.setText("")
                    binding.edtUser.requestFocus();
                    binding.lvUser.visibility = View.VISIBLE
                })
                .create()
                .show();
        }

        binding.btnDelete.setOnClickListener {
            var cv = ContentValues();
            cv.put("NAME",binding.edtUser.text.toString())
            cv.put("PHONE",binding.edtPhone.text.toString())
            val newRowId = db.delete("TUHOC","_id=?",arrayOf(rs.getString(0)));
            rs.requery();
            adapter.notifyDataSetChanged()
            binding.searchV.queryHint = "Search...${rs.count}"
//            if (newRowId == -1L) {
//                // Something went wrong, show an error message.
//                // Log the error for debugging.
//                Log.e("DB_ERROR", "Error inserting data.")
//                Toast.makeText(this, "Failed to add record!", Toast.LENGTH_SHORT).show()
//            } else {
//                // Insertion was successful.
//                // Show a success message.
//                Toast.makeText(this, "Add Record Success!", Toast.LENGTH_SHORT).show()
//            }
            var ad = AlertDialog.Builder(this)
                .setTitle("Delete Record")
                .setMessage("Delete Record Success!")

                //DialogInterface.OnClickListener
                .setPositiveButton ("Ok", {dialog,_ ->
                    binding.edtUser.setText("")
                    binding.edtPhone.setText("")
                    binding.edtUser.requestFocus();
                    binding.lvUser.visibility = View.VISIBLE
                })
                .create()
                .show();
        }
    registerForContextMenu(binding.lvUser)
        //binding.lvUser.onItemClickListener(adapter.)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(100,11,1,"Delete")
        menu?.setHeaderTitle("Removing Data")

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.itemId ==11){
            Toast.makeText(this, "clicked!", Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }
    fun notfounddata(){
        binding.edtUser.setText("")
        binding.edtPhone.setText("")
        Toast.makeText(applicationContext,"No data found!", Toast.LENGTH_SHORT).show()
    }
}