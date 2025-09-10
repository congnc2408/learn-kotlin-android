package com.mimitoji.bai22_2_sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "Userdb",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
            db?.execSQL("CREATE TABLE User (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT, " +
                    "age INTEGER)")
            db?.execSQL("INSERT INTO User (name, age) VALUES ('Alice', 30)")
            db?.execSQL("INSERT INTO User (name, age) VALUES ('Lucas', 30)")
            db?.execSQL("INSERT INTO User (name, age) VALUES ('Jayce', 30)")
            db?.execSQL("INSERT INTO User (name, age) VALUES ('Andy', 30)")
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        TODO("Not yet implemented")
    }
}