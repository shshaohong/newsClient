package com.edu.feicui.newsclient.utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016-11-28.
 */

public class VolleyHttp {
    private Context context;

    private static RequestQueue requestQueue;

    public VolleyHttp(Context context){
        this.context = context;
        if(this.requestQueue == null){
            this.requestQueue = Volley.newRequestQueue(context);
        }

    }

    public void sendStringRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener){
        StringRequest request = new StringRequest(url,listener,errorListener);
        requestQueue.add(request);
    }
}
