package com.edu.feicui.newsclient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.edu.feicui.newsclient.R;
import com.edu.feicui.newsclient.adapter.NewsTypeAdapter;
import com.edu.feicui.newsclient.biz.NewsDBManager;
import com.edu.feicui.newsclient.biz.NewsManager;
import com.edu.feicui.newsclient.entity.SubType;
import com.edu.feicui.newsclient.parser.NewsParser;
import com.edu.feicui.newsclient.utils.CommonUtils;
import com.edu.feicui.newsclient.view.HorizontalListView;
import com.edu.feicui.newsclient.xlistview.XListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016-11-28.
 */

public class MainFragment extends Fragment {
    @BindView(R.id.hl_type)
    HorizontalListView hlType;
    @BindView(R.id.type_move_right)
    ImageView ivTypeMove;
    @BindView(R.id.xl_listView)
    XListView xListView;

    private NewsDBManager newsDBManager;
    private NewsTypeAdapter newsTypeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        ButterKnife.bind(this,view);

        newsTypeAdapter = new NewsTypeAdapter(getActivity());
        newsDBManager = new NewsDBManager(getActivity());
        hlType.setAdapter(newsTypeAdapter);

        loadNewsType();

        return view;
    }
    //加载新闻分类
    private void loadNewsType(){
        //先判断数据库中是否有缓存的数据，如果有，则使用缓存的数据，如果没有，
        // 则判断是否有网络，有网络则去服务器端加载数据
        if(newsDBManager.getNewsSubType().size() == 0){

            if(CommonUtils.isNetConnect(getActivity())){

                NewsManager.getNewsType(getActivity(),newsTypeListener,errorListener);
            }else {
                List<SubType> list = newsDBManager.getNewsSubType();
                newsTypeAdapter.appendDataToAdapter(list,true);
                newsTypeAdapter.notifyDataSetChanged();
            }
        }


    }
    //获取新闻分类成功之后回调的接口
    private Response.Listener<String> newsTypeListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String json) {
            List<SubType> list = NewsParser.parserNewsType(json);
            newsTypeAdapter.appendDataToAdapter(list,true);
            newsTypeAdapter.notifyDataSetChanged();
        }
    };
    //获取新闻分类失败之后回调的方法
    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError volleyError) {

        }
    };
}
