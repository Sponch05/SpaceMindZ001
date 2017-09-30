package com.spacemindz.www.spacemindz001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLogin(View view)

    {
        Intent intent1 = new Intent(MainActivity.this, Register.class);
        startActivity(intent1);
    }
}
