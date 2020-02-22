package com.royali.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DairyProducts_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_products_);
        // button to add dairy product to cart
        Button dairyAdd = findViewById(R.id.dairyAdd);

        final Intent u=getIntent();
        // editable text to get different quantity
        final TextView milk=findViewById(R.id.milkQty);
        final TextView cheese=findViewById(R.id.cheeseQty);
        final TextView wipping=findViewById(R.id.wippingQty);
        final TextView yougurt=findViewById(R.id.yougurtQty);
        final TextView eggs=findViewById(R.id.eggsQty);

        // adding method to button
        dairyAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //using intent getting data
                u.setClass(DairyProducts_Activity.this,ViewCartActivity.class);

                String milkQty=milk.getText().toString();
                if(milkQty.length()>0)
                {
                    u.putExtra("milk",milkQty);

                }

                String cheeseQty=cheese.getText().toString();
                if(cheeseQty.length()>0)
                {
                    u.putExtra("cheese",cheeseQty);
                   }

                String wippingQty=wipping.getText().toString();
                if(wippingQty.length()>0) {


                    u.putExtra("wipping",wippingQty);

                }

                String yogurtQty=yougurt.getText().toString();
                if(yogurtQty.length()>0) {

                    u.putExtra("yogurt",yogurtQty);

                }

                String eggsQty=eggs.getText().toString();
                if(eggsQty.length()>0) {

                    u.putExtra("eggs",eggsQty);
                }


                // displaying data in view cart
                startActivity(u);
            }
        });
    }
}
