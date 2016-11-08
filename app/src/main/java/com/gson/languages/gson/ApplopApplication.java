package com.gson.languages.gson;

import android.app.Application;

/**
 * Created by vicky on 11/5/2016.
 */

public class ApplopApplication extends Application{
    public static RestClient restClient;



    private void init(){
        restClient=new RestClient(this);
    }

    public static RestClient getRestClient() {
        return restClient;
    }
}
