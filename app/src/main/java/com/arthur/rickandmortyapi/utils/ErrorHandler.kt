package com.arthur.rickandmortyapi.utils

import android.content.Context
import android.widget.Toast

class ErrorHandler(private val context: Context) {

    fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}