package com.example.karumicounter

import android.content.Context

class CounterStorage(val context: Context) {

    private val sharedPreferences by lazy { context.getSharedPreferences("prefs", Context.MODE_PRIVATE) }

    fun save(counter: Int) {
        sharedPreferences.edit().putInt("counter", counter).apply()
    }

    fun getCounter(): Int? = sharedPreferences.getInt("counter", 0)

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}