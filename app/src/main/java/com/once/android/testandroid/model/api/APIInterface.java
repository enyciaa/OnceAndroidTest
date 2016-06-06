package com.once.android.testandroid.model.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * API interface
 * Contains all the methods and variables for the API
 */
public interface APIInterface {

    /**
     * Base URL for api
     */
    String TARGET_URL = "https://api.myjson.com/bins/";


    @GET("2hjg2/")
    Call<ResponseBody> getListData();

}
