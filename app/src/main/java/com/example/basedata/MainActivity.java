package com.example.basedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText edName,edSec,edEmail;
private DatabaseReference mDataBase;
private String USER_KIRA = "User";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        edName = findViewById(R.id.edName);
        edSec = findViewById(R.id.edSec);
        edEmail = findViewById(R.id.edEmail);
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KIRA);
    }
    public void onClickSave(View view){
      String id = mDataBase.getKey();
      String name = edName.getText().toString();
        String sec = edSec.getText().toString();
        String email = edEmail.getText().toString();
        User newUser = new User(id,name,sec,email);
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(sec) && !TextUtils.isEmpty(email))
        {
            mDataBase.push().setValue(newUser);
            Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();
        }
else {

            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickRead(View view){
        Intent intent = new Intent(MainActivity.this, ReadActivity.class);
        startActivity(intent);
    }
}