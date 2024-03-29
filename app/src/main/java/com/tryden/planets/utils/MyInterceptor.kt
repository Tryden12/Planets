package com.tryden.planets.utils

import android.util.Log
import com.tryden.planets.utils.Constants.API_KEY_VALUE
import com.tryden.planets.utils.Constants.X_RAPIDAPI_HOST_NAME
import com.tryden.planets.utils.Constants.X_RAPIDAPI_HOST_VALUE
import com.tryden.planets.utils.Constants.X_RAPIDAPI_KEY_NAME
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

/**
 * This custom interceptor class is used in the NetworkModule to add headers to the base url.
 * Headers: API Key & Host Name
 */
class MyInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader(X_RAPIDAPI_KEY_NAME , API_KEY_VALUE)
            .addHeader(X_RAPIDAPI_HOST_NAME, X_RAPIDAPI_HOST_VALUE)
            .build()
        Log.d("MyInterceptor()", "request url: ${chain.request().url}")
        return chain.proceed(request)
    }
}