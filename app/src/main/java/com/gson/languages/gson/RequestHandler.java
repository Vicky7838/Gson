package com.gson.languages.gson;

import com.android.volley.Request;

/**
 * Created by vicky on 11/5/2016.
 */

public class RequestHandler {
    final private Request mRequest;
    public RequestHandler(Request request) {
        mRequest = request;
    }
    public void cancel() {
        mRequest.cancel();
    }
}
