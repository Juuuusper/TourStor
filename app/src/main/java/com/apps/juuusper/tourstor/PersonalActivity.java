package com.apps.juuusper.tourstor;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalActivity extends AppCompatActivity implements MyOneLineView.OnRootClickListener, MyOneLineView.OnArrowClickListener {

    /**
     * 头像处最外层容器
     */
    private LinearLayout headRoot;
    /**
     * 左边的头像
     */
    private ImageView myAvatar;
    /**
     * 上部的文字
     */
    private TextView myNickname;

    /**
     * 下部的文字
     */
    private TextView myAccount;

    /**
     * 右边的icon 通常是箭头
     */
    //private ImageView ivRightIcon2;


    Toolbar mToolbar;
    LinearLayout llRoot;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        // App Logo
//        mToolbar.setLogo(R.drawable.app_icon);
        // 主标题,默认为app_label的名字
        mToolbar.setTitle("我的");
        mToolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(mToolbar);//ToolBar上点击事件放在之后设置才会

        initView();
    }

    public void initView(){

        headRoot = (LinearLayout)findViewById(R.id.head_root);
        headRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "点击了头部", Toast.LENGTH_SHORT).show();
            }
        });
        llRoot = (LinearLayout) findViewById(R.id.ll_root);

        //使用示例，通过Java代码来创建MyOnelineView
        //icon + 文字 + 箭头
        llRoot.addView(new MyOneLineView(this)
                .initMine(R.drawable.ic_credit, "信用评分", "1236", true)
                .setOnRootClickListener(this, 1));

        llRoot.addView(new MyOneLineView(this)
                .initMine(R.drawable.ic_collection, "我的收藏", "", true)
                /*.setDividerTopColor(R.color.head_bottom_color)*/
                .showDivider(true,true)
                .setDividerTopHigiht(10)
                .setOnRootClickListener(this, 2));

        llRoot.addView(new MyOneLineView(this)
                .initMine(R.drawable.ic_bank_card, "银行卡", "", true)
                .setOnRootClickListener(this, 3));

        llRoot.addView(new MyOneLineView(this)
                .initMine(R.drawable.ic_setting, "设置", "444", true)
                .showDivider(true,true)
                .setDividerTopHigiht(10)
                .setOnRootClickListener(this, 4));

        llRoot.addView(new MyOneLineView(this)
                .initMine(R.drawable.ic_customer_service, "我的客服", "", true)
                .setOnRootClickListener(this, 5));

    }

    @Override
    public void onRootClick(View view) {

        int position = 0;
        switch ((int) view.getTag()) {
            case 1:
                position = 1;
                break;
            case 2:
                position = 2;
                break;
            case 3:
                position = 3;
                break;
            case 4:
                position = 4;
                break;
            case 5:
                position = 5;
                break;
            /*case 6:
                Toast.makeText(this, "规划中", Toast.LENGTH_SHORT).show();
                break;*/
        }

        Toast.makeText(this, "点击了第" + position + "行", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onArrowClick(View view) {

    }

   /* *//* -------------        头部点击               ------------*//*

    *//**
     * 整个一行被点击
     *//*
    public static interface OnRootClickListener {
        void onRootClick(View view);
    }


    *//**
     * 右边箭头的点击事件
     *//*
    public static interface OnArrowClickListener {
        void onArrowClick(View view);
    }

    //----------------------下面是一些点击事件

    public PersonalActivity setOnRootClickListener(final OnRootClickListener onRootClickListener, final int tag) {
        headRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headRoot.setTag(tag);
                onRootClickListener.onRootClick(headRoot);
            }
        });
        return this;
    }

    public PersonalActivity setOnArrowClickListener(final OnArrowClickListener onArrowClickListener, final int tag) {

        ivRightIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivRightIcon2.setTag(tag);
                onArrowClickListener.onArrowClick(ivRightIcon2);
            }
        });
        return this;
    }*/
}
