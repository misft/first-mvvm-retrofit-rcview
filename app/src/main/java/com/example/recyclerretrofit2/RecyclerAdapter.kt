package com.example.recyclerretrofit2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rc_main_text.view.*

// Struktur pada kelas ini akan selalu mengikuti panduan dari
// https://developer.android.com/guide/topics/ui/layout/recyclerview
// Kalian cuma perlu mengadaptasi agar penamaan variable dan objectnya sesuai dengan project kalian

class RecyclerAdapter(private val mData : List<TodosModel>) :
    RecyclerView.Adapter<RecyclerAdapter.MainViewHolder>() {

    class MainViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        // Kita harus buat layout dulu di folder layout
        // Lalu, kita inflate disini supaya dirender oleh recyclerview
        // Secara otomatis
        var layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rc_main_text, parent, false)

        return MainViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        var res = mData[position]

        // Mengakses TextView dengan menggunakan ID dari TextView
        // Lalu mengubah value textnya
        holder.view.tx.text = res.title
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}