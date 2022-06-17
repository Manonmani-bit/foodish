package com.example.foodish.network

import androidx.databinding.library.BuildConfig
import com.example.foodish.network.api.APIInterface
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Retrofit hub is where network layer is initialized
 */
object RetrofitHub {

    private var retrofit: Retrofit

    private const val TIMEOUT_CONNECTION = 180000L

    private const val TIMEOUT_READ = 180000L
    private const val BASE_URL = "https://api.thecatapi.com/"
    private var builder: OkHttpClient.Builder

    init {
         builder = OkHttpClient().newBuilder()
            .addInterceptor(getLoggingInterceptor())
            .addInterceptor(getHeaderInterceptor())
            .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.MILLISECONDS)
            .readTimeout(TIMEOUT_READ, TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(true)


        val client = builder.build()


        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BASE_URL)
            .build()

    }

    /**
     * Logs request and response and their respective headers and bodies (if present).
     *
     * @return HttpLoggingInterceptor
     */
    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level =  if (BuildConfig.BUILD_TYPE.contentEquals("debug"))
            HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return httpLoggingInterceptor
    }

    /**
     * Account API collection
     */
    val apiInterface by lazy { retrofit.create(APIInterface::class.java) }

    /**
     * Interceptor which adds the header property.
     *
     * @return Interceptor
     */
    private fun getHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original: Request = chain.request()
            val request: Request.Builder = original.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .method(original.method, original.body)
            chain.proceed(request.build())
        }
    }
}