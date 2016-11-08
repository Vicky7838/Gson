package com.gson.languages.gson;

import android.util.Log;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;

/**
 * Created by vicky on 11/5/2016.
 */

public abstract class RequestCallback<T> implements ResponseListener<T> {
    @Override
    public void onSuccessResponse(T responseData) {
        Log.d(" onSuccessResponse", responseData.toString());
        onSuccessRestResponse(null, responseData);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        if (error.networkResponse != null && error.networkResponse.data != null) {
            try {
                if (error.networkResponse.headers != null) {
                    String errorString = new String(error.networkResponse.data, HttpHeaderParser.parseCharset(error.networkResponse.headers));
                    Log.d("onErrorResponse", errorString);
                    Log.d("onErrorResponse", errorString);
                    onErrorRestResponse(error);
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }
    public abstract void onSuccessRestResponse(Exception e, T result);

    public abstract void onErrorRestResponse(VolleyError error);
}
