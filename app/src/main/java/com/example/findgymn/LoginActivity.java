package com.example.findgymn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void toHome(View v){
        startActivity(new Intent(this,HomeActivity.class));
    }
    public void toSignUp(View view){
        startActivity(new Intent(this,SignUpActivity.class));
    }
}
