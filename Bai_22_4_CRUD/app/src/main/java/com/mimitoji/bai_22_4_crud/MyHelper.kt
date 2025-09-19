package com.mimitoji.bai_22_4_crud

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context: Context): SQLiteOpenHelper(context, "TUHOC",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE TUHOC(_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PHONE TEXT)")
        db?.execSQL("INSERT INTO TUHOC(NAME,PHONE) VALUES('Anna','0123456789')")
        db?.execSQL("INSERT INTO TUHOC(NAME,PHONE) VALUES('David','0123456788')")
        db?.execSQL("INSERT INTO TUHOC(NAME,PHONE) VALUES('Lucas','0123456777')")
        db?.execSQL("INSERT INTO TUHOC(NAME,PHONE) VALUES('Victor','0123456666')")
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        TODO("Not yet implemented")
    }
}