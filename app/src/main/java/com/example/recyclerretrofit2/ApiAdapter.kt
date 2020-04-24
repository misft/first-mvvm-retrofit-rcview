package com.example.recyclerretrofit2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rc_main_text.view.*

class ApiAdapter(private val mData : List<TodosModel>) :
    RecyclerView.Adapter<ApiAdapter.MainViewHolder>() {

    class MainViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        var layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rc_main_text, parent, false)

        return MainViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        var res = mData[position]

        holder.view.tx.text = res.title
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}