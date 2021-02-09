package com.example.basedata;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {
    private TextView textView,textView2,textView3;
    @Override
    protected  void  onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);
        init();
        getIntentMain();
    }
    private void init()
    {
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

    }
    private void getIntentMain(){
        Intent intent = getIntent();
        if(intent != null){
            textView.setText(intent.getStringExtra(Constant.USER_NAME));
            textView2.setText(intent.getStringExtra(Constant.SEC));
            textView3.setText(intent.getStringExtra(Constant.EMAIL));
        }
    }

}
