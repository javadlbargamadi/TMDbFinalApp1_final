package com.example.tmdbfinalapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbfinalapp.TMDbClass.TMDbClass
import kotlinx.android.synthetic.main.activity_main2.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

//--------------------------------------------------------------------------------------------------

    private fun setUpRecyclerView(tmdbClass: TMDbClass) {
        recyclerViewSearchResult.adapter = RecyclerViewAdapter(tmdbClass) {}
        recyclerViewSearchResult.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

//--------------------------------------------------------------------------------------------------

    private fun callRetrofit(movieName: String) {
        RetrofitProvider
            .provideRetrofit()
            .findMoviesContain(movieName)
            .enqueue(object : retrofit2.Callback<TMDbClass> {
                override fun onFailure(call: Call<TMDbClass>, t: Throwable) {
                    Log.e("Fuck", "onError")
                    print("onErrororrororroro")
                    Log.e("Result", t.message.toString())
                    Toast.makeText(this@MainActivity, "onFailure", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<TMDbClass>, response: Response<TMDbClass>) {
                    Log.e("Fuck", "onResponse")
                    print("onResponseeense")
                    Log.e("Result", "${response.body()?.totalResults ?: 0}")
                    Toast.makeText(this@MainActivity, "onResponse", Toast.LENGTH_LONG).show()
                    val responseResult = response.body()
                    if (responseResult != null) {
                        setUpRecyclerView(responseResult)
                    }
                }
            })
    }

//--------------------------------------------------------------------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnSearchForMovie.setOnClickListener { callRetrofit(edtUserMovieName.text.toString()) }
    }
}
