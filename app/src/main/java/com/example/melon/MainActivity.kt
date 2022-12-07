package com.example.melon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val retrofit = Retrofit.Builder()
			.baseUrl("http://mellowcode.org")
			.addConverterFactory(GsonConverterFactory.create())
			.build()

		val retrofitService = retrofit.create(RetrofitService::class.java)

		retrofitService.getMelonItemList().enqueue(object : Callback<ArrayList<MelonItem>>{
			override fun onResponse(
				call: Call<ArrayList<MelonItem>>,
				response: Response<ArrayList<MelonItem>>
			) {
				if(response.isSuccessful) {
					val melonItemList = response.body()
					melonItemList!!.forEach {
						Log.d("testm", it.song)
					}
				}
			}

			override fun onFailure(call: Call<ArrayList<MelonItem>>, t: Throwable) {
				Log.d("testm", "쿼리 실패" + t.message)
			}
		})
	}
}