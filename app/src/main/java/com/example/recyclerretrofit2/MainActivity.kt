package com.example.recyclerretrofit2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //Inisalisasikan RecyclerView
    private lateinit var rcView : RecyclerView
    //Menginisialisasi ViewModel
    private val mainViewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mendefinisikan RecyclerView dengan yang udah ada di layout
        rcView = findViewById(R.id.rc_view)

        // Memberikan properti layoutManager ke RecyclerView
        rcView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        // Mengesekusi fungsi untuk mengupdate MutableLiveData pada ViewModel
        // Yang fungsi tersebut menjalankan fungsi lagi yang ada di repository
        mainViewModel.updateTodos()

        // Mengamati perubahan yang ada pada model kita
        // Dan kita pasangkan adapter yang telah kita buat ke RecyclerView kita
        mainViewModel.getTodos().observe(this, Observer<List<TodosModel>> {
            rcView.adapter = RecyclerAdapter(it)
        })
    }
}
