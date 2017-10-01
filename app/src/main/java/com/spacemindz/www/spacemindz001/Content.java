package com.spacemindz.www.spacemindz001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Content extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
    }

    public void onClickKotas(View view)
      //On click to the kota category class
    {
        Intent intent1 = new Intent(this, KotasOnline.class);
        startActivity(intent1);
    }

    public void onClickCreatives(View view)
    //On click to the clothing category class
    {
        Intent intent1 = new Intent(this, KasiCreatives.class);
        startActivity(intent1);
    }
    public void onClickFruitAndVeg(View view)
    //On click to the vendors category class
    {
        Intent intent1 = new Intent(this, FruitAndVeg.class);
        startActivity(intent1);
    }
}
