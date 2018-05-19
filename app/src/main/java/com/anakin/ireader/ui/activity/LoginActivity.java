package com.anakin.ireader.ui.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.anakin.ireader.R;


/**
 * 创建者     彭龙
 * 创建时间   2018/1/26 16:43
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText username;
    private EditText password;
    private Button login;
    private ImageView clear;
    private ProgressBar pb;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        username= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.password);
        login= (Button) findViewById(R.id.login);
        clear= (ImageView) findViewById(R.id.iv_delete);
        pb= (ProgressBar) findViewById(R.id.pb);
    }

    @Override
    public void initEvent() {
        super.initEvent();
        clear.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.login){
            gotoMainActivity();
        }else if(view.getId()==R.id.iv_delete){
            username.getText().clear();
        }
    }

    private void gotoMainActivity() {
        showDialog("正在登录");
        SystemClock.sleep(1000);
        forward(MainActivity.class);
    }

    /**
     * 转跳 有finish
     *
     * @param classObj
     */
    public void forward(Class<?> classObj) {
        Intent intent = new Intent();
        intent.setClass(this, classObj);
        startActivity(intent);
        finish();
    }

    public void showDialog(String title) {
        pb.setVisibility(View.VISIBLE);
    }

    public void dismissDialog() {
        pb.setVisibility(View.GONE);
    }
}
