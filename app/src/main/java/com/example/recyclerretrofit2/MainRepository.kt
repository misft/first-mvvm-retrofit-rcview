package com.example.recyclerretrofit2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {
    // Membuat class ApiClient baru
    private var apiClient : ApiClient = ApiClient()

    // Membuat fungsi untuk mendapatkan data dari server
    // Yang nantinya fungsi ini akan dieksekusi oleh ViewModel
    // Untuk mengubah value dari MutableLiveData
    public fun getTodos() : LiveData<List<TodosModel>> {
        var todosList : MutableLiveData<List<TodosModel>> = MutableLiveData()

        // Membuat pemanggilan Api dengan menggunakan class ApiClient
        // Memanggil class ApiClient lalu mengakses method ApiCall lalu
        // Mengimplementasikan method getTodos() yang ada pada ApiInterface
        apiClient.apiCall().getTodos().enqueue(object : Callback<List<TodosModel>> {
            // Jika pemanggilan API gagal
            override fun onFailure(call: Call<List<TodosModel>>, t: Throwable) {
                Log.d("African Coffin Dance: ", "${t.toString()}")
            }
            // Jika pemanggilan API berhasil
            override fun onResponse(
                call: Call<List<TodosModel>>,
                response: Response<List<TodosModel>>
            ) {
                // Kita ubah nilai dari MutableLiveData menjadi response yang didapatkan
                // oleh server
                todosList.value = response.body()!!
            }
        })
        return todosList
    }
}
