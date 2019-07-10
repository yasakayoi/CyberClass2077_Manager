package com.example.cyberclass2077_manager;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cyberclass2077_manager.pictureselector.PermissionUtils;

public class LoginActivity extends AppCompatActivity {
    //在这里声明控件的引用变量
    private EditText vUserNameEditor;
    private EditText vPassWordEditor;
    private Button vLoginButton;


    //在这里声明其他引用变量
    private final int PERMISSION_CODE_FIRST = 0x14;//权限请求码
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        initDependencies();
    }


    void initDependencies(){
        vUserNameEditor=(EditText)findViewById(R.id.et_username_login);
        vPassWordEditor=(EditText)findViewById(R.id.et_password_login);
        vLoginButton=(Button)findViewById(R.id.btn_login_login);


        vLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=vUserNameEditor.getText().toString();
                String passWord=vPassWordEditor.getText().toString();
                boolean checkPermissionFirst = PermissionUtils.checkPermissionFirst(LoginActivity.this, PERMISSION_CODE_FIRST,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA});
                if (checkPermissionFirst) {
                  if(true)
                  {
                      Toast.makeText(LoginActivity.this, "登录成功! 欢迎您，管理员yoi!", Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                      intent.putExtra("fragment",2);
                      startActivity(intent);
                      finish();
                    }
                  else {
                      Toast.makeText(LoginActivity.this, "登录失败! 用户名或密码错误", Toast.LENGTH_SHORT).show();
                  }
                }
                else {
                    Toast.makeText(LoginActivity.this,
                            String.format("请给予权限再登录"),
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }
}
