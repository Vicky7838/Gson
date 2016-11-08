package com.gson.languages.gson;

import android.content.Context;

import com.android.volley.Request;

/**
 * Created by vicky on 11/5/2016.
 */

public class RestClient {
    VolleyManager mVolleyManager;

    public VolleyManager getmVolleyManager() {
        return mVolleyManager;
    }

    protected static final String PROTOCOL_CHARSET = "utf-8";
    protected static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", PROTOCOL_CHARSET);

    public RestClient(Context appContext) {
        mVolleyManager = new VolleyManager(appContext);
    }

    /**
     * added by sunny
     * Function to get languages from server which user an select to convert all app's text in that particular language
     * @param url
     * @param listener
     * @param request
     * @return
     */

    public RequestHandler getLanguage(String url, final RequestCallback<LanguageList> listener, String request)
    {
        GsonRequest gsonRequest = new GsonRequest(Request.Method.GET, url, LanguageList.class, request, listener);
        gsonRequest.putHeaders(CONSTANTS.KEY, CONSTANTS.KEY_VALUE);
        return new RequestHandler(mVolleyManager.addToRequestQueue(gsonRequest));
    }



}
