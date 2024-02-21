package com.example.homework6_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val counter = MutableLiveData<Int>()
    val counterLv: LiveData<Int> get() = counter
    private var count = 0

    fun increment() {
        counter.value = count++
    }

    fun decrement() {
        counter.value = count--
    }
}