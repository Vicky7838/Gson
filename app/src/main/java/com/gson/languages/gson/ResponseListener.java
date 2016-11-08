package com.gson.languages.gson;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by vicky on 11/5/2016.
 */

public interface ResponseListener<T> extends Response.Listener<T>, Response.ErrorListener {
    void onSuccessResponse(T responseData);
    void onErrorResponse(VolleyError error);
}
