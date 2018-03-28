package com.example.aris.navdrawersimpleweather.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by al-kahyatamar on 24.03.18.
 */

public class RetrofitClient
{
    private static Retrofit retrofit=null;
    public static Retrofit getClient(String baseUrl){
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
