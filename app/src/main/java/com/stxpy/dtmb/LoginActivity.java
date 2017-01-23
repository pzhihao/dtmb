package com.stxpy.dtmb;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.stxpy.bean.LoginResultBean;
import com.stxpy.data.presenter.LoginPresenter;
import com.stxpy.data.view.ILoginView;
import com.stxpy.jni.Jtest;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {


    @BindView(R.id.login)
    Button login;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.pass)
    TextView pass;

    ProgressDialog p;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
//        loginPresenter.getLoginResult("tzj", "1");



    }

    @OnClick(R.id.login)
    public void onClick() {

        String username = name.getText().toString().trim();
        String password = pass.getText().toString().trim();

        if (!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(password)){
            loginPresenter.getLoginResult(username,password);
        }else{
            Toast.makeText(this, "用户名或密码不可为空！", Toast.LENGTH_SHORT).show();
        }


        Log.i("Main",username+"/"+password);


    }

    @Override
    public void getLoginCompleted(String s) {
        Log.i("LoginCompleted", s);


        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        finish();

    }

    @Override
    public void getLoginError(String errmsg) {
        Log.i("LoginError", errmsg);
        Toast.makeText(this, "登录失败:"+errmsg, Toast.LENGTH_SHORT).show();
        p.dismiss();
    }

    @Override
    public void getLoginbefore() {
        Log.i("Main", "登录之前");
        p = ProgressDialog.show(this, "", "登录中", true, false);
    }

    @Override
    public void getLoginafter() {
        Log.i("Main", "登录之后");
        p.dismiss();
    }
}
