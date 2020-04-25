package com.example.recyclerretrofit2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // Membuat variable MutableLiveData
    private var todos = MutableLiveData<List<TodosModel>>()

    // Membuat variable LiveData
    public fun getTodos() : LiveData<List<TodosModel>> {
        return todos
    }

    // Membuat fungsi untuk mengubah value dari todos
    public fun updateTodos() {
        todos.value = MainRepository().getTodos().value
    }
}