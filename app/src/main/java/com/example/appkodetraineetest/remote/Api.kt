package com.example.appkodetraineetest.remote

import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import java.lang.reflect.Type

private const val BASE_URL = "https://stoplight.io/mocks/kode-education/trainee-test/25143926/"

/* Moshi converter object */
@JsonClass(generateAdapter = true)
data class Wrapper(@Json(name = "items") val list : List<Employee>)

val moshi = Moshi.Builder()
    .addLast(KotlinJsonAdapterFactory())
    .build()

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
    @Headers("Content-Type: application/json", "Prefer: code=200")
    @GET("users")
    suspend fun getEmployees(): Wrapper
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object Api {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}