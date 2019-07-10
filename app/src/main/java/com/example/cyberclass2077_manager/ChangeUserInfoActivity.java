package com.example.cyberclass2077_manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChangeUserInfoActivity extends AppCompatActivity {
    private ImageButton img_back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_data_setting_layout);
        img_back_btn = (ImageButton)findViewById(R.id.btn_dataSetting_back);


        img_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeUserInfoActivity.this,Fragment3CheckAccountlistActivity.class);
                intent.putExtra("fragment",2);
                finish();
                startActivity(intent);
            }
        });
    }

}

