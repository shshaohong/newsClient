package com.edu.feicui.newsclient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.edu.feicui.newsclient.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administr
 * ator on 2016-11-24.
 */

public class RightMenuFragment extends Fragment {
    //没登陆的
    @BindView(R.id.ll_unLogin)
    LinearLayout unLayout;
    @BindView(R.id.iv_right_unimg)
    ImageView univRightImg;
    @BindView(R.id.tv_unlijidenglu)
    TextView untvRightText;

    //登陆了的
    @BindView(R.id.ll_Login)
    LinearLayout Layout;
    @BindView(R.id.iv_right_img)
    ImageView ivRightImg;
    @BindView(R.id.tv_lijidenglu)
    TextView tvRightText;

    @BindView(R.id.iv_weixin)
    ImageView ivWeixin;
    @BindView(R.id.iv_qq)
    ImageView inqq;
    @BindView(R.id.iv_pengyouquan)
    ImageView ivPengyouquan;
    @BindView(R.id.iv_weibo)
    ImageView ivWeibo;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right_menu,container,false);
        ButterKnife.bind(this,view);
        return view;
    }
}
