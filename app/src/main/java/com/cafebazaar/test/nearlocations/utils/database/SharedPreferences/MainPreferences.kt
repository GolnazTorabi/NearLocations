package com.cafebazaar.test.nearlocations.utils.database.SharedPreferences

import android.content.Context
import android.content.SharedPreferences

class MainPreferences private constructor(context: Context) {
    private val sharedPreferencesApp: SharedPreferences =
        context.getSharedPreferences("sharedPreferencesApp", Context.MODE_PRIVATE)

    fun setLat(value: Double) {
        sharedPreferencesApp.edit().putDouble(LAT, value).apply()
    }

    fun getLat(defaultValue: Double): Double {
        return sharedPreferencesApp.getDouble(LAT, defaultValue)
    }

    fun setLng(value: Double) {
        sharedPreferencesApp.edit().putDouble(LNG, value).apply()
    }

    fun getLng(defaultValue: Double): Double {
        return sharedPreferencesApp.getDouble(LNG, defaultValue)
    }

    fun clear() {
        sharedPreferencesApp.edit().remove(LAT).apply()
        sharedPreferencesApp.edit().remove(LNG).apply()
    }

    companion object {
        private const val LAT = "LAT"
        private const val LNG = "LNG"
        private var appPreferences: MainPreferences? = null

        @JvmStatic
        fun getInstance(context: Context): MainPreferences {
            if (appPreferences == null) {
                appPreferences = MainPreferences(context)
            }
            return appPreferences!!
        }
    }

    fun SharedPreferences.Editor.putDouble(key: String, double: Double) =
        putLong(key, java.lang.Double.doubleToRawLongBits(double))

    fun SharedPreferences.getDouble(key: String, default: Double) =
        java.lang.Double.longBitsToDouble(
            getLong(
                key,
                java.lang.Double.doubleToRawLongBits(default)
            )
        )
}