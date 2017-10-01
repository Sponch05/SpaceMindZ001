package com.spacemindz.www.spacemindz001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class VendorMyItems extends AppCompatActivity {

    TextView itemTypeT;
    TextView itemNameT;
    TextView itemPriceT;
    DatabaseHandler data;
    public List<BackEnd> list;



    public VendorMyItems()
    {
       // itemTypeT = ( TextView) findViewById(R.id.tempView1);
        //itemNameT = ( TextView) findViewById(R.id.tempView2);
        //itemPriceT = ( TextView) findViewById(R.id.tempView3);
        data = new DatabaseHandler(this);
       // list =

    }

    ListView lv = (ListView) findViewById(R.id.viewL);


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_my_items);

        list = data.getWholeBack();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, list.toString());
    }



}
