package com.example.recyclerretrofit2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    lateinit var todos : MutableLiveData<List<TodosModel>>

    public fun getTodos() : LiveData<List<TodosModel>> {
        return todos
    }

    public fun updateTodos() {
        todos = MainRepository().getTodos() as MutableLiveData<List<TodosModel>>
    }
}