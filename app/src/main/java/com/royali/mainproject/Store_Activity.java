package com.royali.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Store_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_);

        Button fruits = findViewById(R.id.fruits);
        Button vegetables = findViewById(R.id.vegetables);
        Button dairy = findViewById(R.id.dairy);
        Button meat = findViewById(R.id.meat);

        TextView storeName = findViewById(R.id.storeName);
        //getting store name data from FIND_STORE activity using getIntent
          final Intent getCh=getIntent();
        String ch=getCh.getStringExtra("Ch");
        storeName.setText("Welcome to " +ch);

        final StringBuilder str=new StringBuilder();

        /*Intent i=getIntent();
        if(i.hasExtra("fruitsQty"))
            str.append(i.getExtras().getString("fruitsQty"));
*/


        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCh.setClass(Store_Activity.this,Fruits_Activity.class);
                startActivity(getCh);
                //startActivity(new Intent(Store_Activity.this,Fruits_Activity.class));
            }
        });
        vegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getCh.setClass(Store_Activity.this,Vegetables_Activity.class);
                startActivity(getCh);
                //startActivity(new Intent(Store_Activity.this,Vegetables_Activity.class));
            }
        });
        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCh.setClass(Store_Activity.this,Meat_Activity.class);
                startActivity(getCh);
                //startActivity(new Intent(Store_Activity.this,Meat_Activity.class));
            }
        });
        dairy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCh.setClass(Store_Activity.this,DairyProducts_Activity.class);
                startActivity(getCh);
                //startActivity(new Intent(Store_Activity.this,DairyProducts_Activity.class));
            }
        });

        Button cart = findViewById(R.id.viewcartBtn);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent j=new Intent(Store_Activity.this,ViewCartActivity.class);
                getCh.setClass(Store_Activity.this,ViewCartActivity.class);
                getCh.putExtra("data",str.toString());
                startActivity(getCh);

               // startActivity(new Intent(Store_Activity.this,ViewCartActivity.class));
            }
        });

    }
}
