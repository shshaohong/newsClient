package com.edu.feicui.newsclient.biz;

import android.content.Context;

import com.android.volley.Response;
import com.edu.feicui.newsclient.utils.CommonUtils;
import com.edu.feicui.newsclient.utils.Url;
import com.edu.feicui.newsclient.utils.VolleyHttp;

/**
 * Created by Administrator on 2016-11-28.
 */

public class NewsManager {

    //发送请求获取新闻分类
    public static void getNewsType(Context context, Response.Listener<String> listener,Response.ErrorListener errorListener){
        String imei = CommonUtils.getIMEI(context);
        VolleyHttp http = new VolleyHttp(context);
        http.sendStringRequest(Url.GET_NEWS_TYPE +"?ver=0&imei=" + imei,listener,errorListener);
    }
}
