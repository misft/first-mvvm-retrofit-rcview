package com.example.recyclerretrofit2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.json.JSONStringer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {
    private var apiClient: ApiClient = ApiClient()
    private var todosList = MutableLiveData<List<TodosModel>>()

    public fun getTodos() : LiveData<List<TodosModel>> {
        apiClient.apiCall().getTodos().enqueue(object : Callback<List<TodosModel>> {
            override fun onFailure(call: Call<List<TodosModel>>, t: Throwable) {
                Log.d("African Coffin Dance: ", "${t.toString()}")
            }
            override fun onResponse(
                call: Call<List<TodosModel>>,
                response: Response<List<TodosModel>>
            ) {
                todosList.value = response.body()
            }
        })
        return todosList
    }
}
