package com.gson.languages.gson;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by vicky on 11/5/2016.
 */

public class VolleyManager {
    private static VolleyManager mInstance;
    private RequestQueue mRequestQueue;
    private Context ctx;
    public final String REQUEST_QUEUE_TAG = "tag";


    public VolleyManager(Context context){
        ctx=context;
        mRequestQueue=getRequestQueue();

    }
    public static synchronized VolleyManager getInstance(Context context){
        if(mInstance==null){
            mInstance=new VolleyManager(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue==null){

            mRequestQueue= Volley.newRequestQueue(ctx);
        }
        return mRequestQueue;
    }
    public <T> Request<T> addToRequestQueue(Request<T> req)
    {
        req.setTag(REQUEST_QUEUE_TAG);
        return getRequestQueue().add(req);
    }

    public void cancelAllRequests() {
        mRequestQueue.cancelAll(REQUEST_QUEUE_TAG);
    }

}
