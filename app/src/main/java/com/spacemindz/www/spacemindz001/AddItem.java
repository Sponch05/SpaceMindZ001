package com.spacemindz.www.spacemindz001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class AddItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }


    public void addItemBtn() {
        EditText itemTypeT = (EditText) findViewById(R.id.itemTypeField);
        EditText itemNameT = (EditText) findViewById(R.id.nameField);
        EditText itemPriceT = (EditText) findViewById(R.id.itemPriceField);
        BackEnd items = new BackEnd();
        DatabaseHandler data = new DatabaseHandler(this);


        if (!itemNameT.getText().equals("") && !itemTypeT.getText().equals("") && !itemPriceT.getText().equals("")) {
            Toast.makeText(this, "Item : " + itemNameT.getText() + "Has been Saved", Toast.LENGTH_LONG).show();
            //items.setSellerId();
            items.setItemName(itemNameT.getText().toString());
            items.setItemPrice(Double.parseDouble(itemPriceT.getText().toString()));

            data.addBackEnd(items);


        }

    }
}
