package com.example.recyclerretrofit2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TodosModel(val userId: Int?, val id: Int?, val title: String?, val completed: Boolean?) : Parcelable