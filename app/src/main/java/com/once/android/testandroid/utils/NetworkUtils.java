package com.once.android.testandroid.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.once.android.testandroid.model.api.LoggerInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Utility methods for Retrofit
 */
public final class NetworkUtils {

    /**
     * Constructor
     * private so class can't be initialised
     */
    private NetworkUtils() {
    }


    /**
     * Get network status
     */
    public static NetworkInfo getConnectionStatus(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        return activeNetwork;
    }


    /**
     * Generic retrofit factory
     */
    public static <S> S createRetrofitService(Class<S> serviceClass, String targetUrl) {
        return createRetrofitService(serviceClass, targetUrl, null);
    }


    /**
     * Generic retrofit factory
     */
    public static <S> S createRetrofitService(Class<S> serviceClass, String targetUrl, final String accessToken) {
        // Create Retrofit service
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(targetUrl);
        builder.addConverterFactory(GsonConverterFactory.create());

        // Add request and response interceptors
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor())
                .build();
        builder.client(client);

        // Build service
        Retrofit retrofit = builder.build();
        S service = retrofit.create(serviceClass);
        return service;
    }

}
