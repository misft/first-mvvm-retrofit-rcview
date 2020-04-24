package com.example.recyclerretrofit2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rcView : RecyclerView
    private val mainViewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcView = findViewById(R.id.rc_view)

        rcView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        mainViewModel.updateTodos()

        mainViewModel.getTodos().observe(this, Observer<List<TodosModel>> {
            rcView.adapter = ApiAdapter(it)
        })
    }
}
