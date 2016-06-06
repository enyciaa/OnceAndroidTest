package com.once.android.testandroid.model.api;

import android.util.Log;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Intercepts all OkHTTP Requests originating from the application
 * Intercepts all OkHTTP Responses going to the application
 * And Logs requests and responses
 */
public class LoggerInterceptor
        implements
        Interceptor {

    /**
     * Constructor
     */
    public LoggerInterceptor() {

    }


    /**
     * Intercepts requests and responses for this application
     * Logs the request and response
     *
     * @param chain
     * @return Response
     * @throws IOException
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        // Get original request
        Request request = chain.request();

        // Logs request
        long t1 = System.nanoTime();
        logRequest(request, chain);

        // Log response
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        logResponse(response, t1, t2);

        return response;
    }


    /**
     * Log request to console
     *
     * @param request
     * @param chain
     */
    private void logRequest(Request request, Chain chain) {
        String requestLog = String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers());
        Log.v("Test", "request log = " + requestLog);
    }


    /**
     * Log response to console
     *
     * @param response
     * @param t1
     * @param t2
     */
    private void logResponse(Response response, long t1, long t2) {
        String responseLog = String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers());
        Log.v("Test", "response log = " + responseLog);
    }

}
