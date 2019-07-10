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
       final Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_data_setting_layout);
        img_back_btn = (ImageButton)findViewById(R.id.btn_dataSetting_back);


        img_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = intent.getIntExtra("back_fragment",1);
                finish();
                if(i==2)
                {
                    Intent intent2 = new Intent(ChangeUserInfoActivity.this,Fragment3CheckAccountlistActivity.class);
                    startActivity(intent2);
                }
                else
                {
                    Intent intent2 = new Intent(ChangeUserInfoActivity.this,MainActivity.class);
                    intent2.putExtra("fragment",1);
                    startActivity(intent2);
                }
            }
        });
    }

}

