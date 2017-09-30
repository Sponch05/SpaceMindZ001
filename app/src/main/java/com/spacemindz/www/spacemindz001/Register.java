package com.spacemindz.www.spacemindz001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    //Submit button to take user to Login screen
    {
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}
