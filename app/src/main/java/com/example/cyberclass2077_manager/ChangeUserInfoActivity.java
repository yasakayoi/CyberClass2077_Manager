package com.example.cyberclass2077_manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class ChangeUserInfoActivity extends AppCompatActivity {
    private ImageButton img_back_btn;
    private TextView btn_save;
    private EditText user_place;
    private Spinner user_status_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       final Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_data_setting_layout);
        img_back_btn = (ImageButton)findViewById(R.id.btn_dataSetting_back);
        btn_save = (TextView)findViewById(R.id.txt_userInfo_save);
        user_place = (EditText)findViewById(R.id.user_place);
        user_status_spinner=(Spinner)findViewById(R.id.sp_set_user_stats);
        int j = intent.getIntExtra("place_new",1);
        if(j!=1)
        {
            user_place.setText("Chongqing");
            user_status_spinner.setSelection(1);
        }


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

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = intent.getIntExtra("back_fragment",1);
                String place = user_place.getText().toString();
                String date =getResources().getString(R.string.the_place);

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

