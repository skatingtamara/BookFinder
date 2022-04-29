package com.example.bookfinder.model

import android.util.Log
import androidx.lifecycle.ViewModel

class BookViewModel : ViewModel() {

    private var _book = "test"
    val book: String
        get() = _book

    private var _resultsNCDL = "Results from NCDL"
    val resultsNCDL: String
        get() = _resultsNCDL

    // Stores the user's book title
    fun setBook(userBook: String): Boolean {
        if(userBook.isNullOrBlank()) {
            return false
        }
        _book = userBook
        return true
    }

    // Pass the book title to

}