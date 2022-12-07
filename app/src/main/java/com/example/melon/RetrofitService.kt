package com.example.melon

import retrofit2.Call
import retrofit2.http.*
import java.io.Serializable


class MelonItem(
	val id : Int, val title : String, val song : String, val thubnail : String
) : Serializable


interface RetrofitService {

	@GET("melon/list/")
	fun getMelonItemList(): Call<ArrayList<MelonItem>>

}
