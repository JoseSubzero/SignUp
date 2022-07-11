package com.example.signup

import android.content.Context

class Prefs (val context: Context) {

    val DATABASE = "MyDB"
    val FULL_NAME = "FullName"
    val USER_NAME = "UserName"
    val EMAIL = "Email"
    val PASSWORD = "Password"
    val RE_TYPE_PASSWORD = "ReTypePassword"
    val GENRE = "Genre"
    val storage = context.getSharedPreferences(DATABASE, Context.MODE_PRIVATE)

    fun saveFullname(name:String){
        storage.edit().putString(FULL_NAME, name).apply()
    }

    fun saveUsername(name: String){
        storage.edit().putString(USER_NAME, name).apply()
    }

    fun saveEmail(name:String){
        storage.edit().putString(EMAIL, name).apply()
    }

    fun savePassword(name: String){
        storage.edit().putString(PASSWORD, name).apply()
    }

    fun saveRetypepassword(name: String){
        storage.edit().putString(RE_TYPE_PASSWORD, name).apply()
    }

    fun saveGenre(genre: String){
        storage.edit().putString(GENRE, genre).apply()

    }
    fun getFullname():String{
        return storage.getString(FULL_NAME, "")!!
    }

    fun getUsername():String{
        return storage.getString(USER_NAME, "")!!
    }

    fun getEmail():String{
        return storage.getString(EMAIL, "")!!
    }

    fun getPassword():String{
        return storage.getString(PASSWORD, "")!!
    }

    fun getRetypePassword():String{
        return storage.getString(RE_TYPE_PASSWORD, "")!!
    }

    fun getGenre():String{
        return storage.getString(GENRE, "")!!

    }

    fun wipeData(){
        storage.edit().clear().apply()
    }
}