package com.example.appkodetraineetest.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

private const val BASE_URL = "https://stoplight.io/mocks/kode-education/trainee-test/25143926/"

/* Moshi converter object */
private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

/* Retrofit object with moshi converter from JSON to Kotlin classes */
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

/**
 *  Public interface that has [getEmployees] method
 */
interface ApiService {
    /**
     * Get employees list
     * @param [prefer] Prefer header field
     * @returns ArrayList of Employee
     * */
    @Headers("Content-Type: application/json")
    @GET("users")
    suspend fun getEmployees(@Header("Prefer") prefer: String): ArrayList<Employee>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object Api {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}