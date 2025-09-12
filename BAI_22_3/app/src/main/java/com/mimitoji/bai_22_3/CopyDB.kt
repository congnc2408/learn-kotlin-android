package com.mimitoji.bai_22_3

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import java.io.File
import java.io.FileOutputStream

class CopyDB (private  val context : Context) {

    companion object{
        private  val DB_NAME = "//assets/TUHOC.db"
    }
    fun openDB(): SQLiteDatabase{
        val dbFile = context.getDatabasePath(DB_NAME);
        val file = File(dbFile.toString());
        if (file.exists()){
            Log.e("TUHOC","DB exists");
        }else{
            copyDatabase(dbFile);
        }
        return SQLiteDatabase.openDatabase(dbFile.path,null,SQLiteDatabase.OPEN_READWRITE);
    }

    private fun copyDatabase(file: File?) {
        val openDB = context.assets.open(DB_NAME);
        val ouputStream = FileOutputStream(file);
        val buffer = ByteArray(1024);
        while (openDB.read() >0){
            ouputStream.write((buffer))
            Log.wtf("TUHOC","Copying....")
        }
        ouputStream.flush();
        ouputStream.close();
        openDB.close();
        Log.wtf("TUHOC","Copy done");
    }
}