package com.royali.mainproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fruits_Activity extends AppCompatActivity {

    GroceryDBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits_);
        db=new GroceryDBHandler(this);
        final TextView apple =findViewById(R.id.appleQty);
        final TextView banana =findViewById(R.id.bananaQty);
        final TextView blueBerries=findViewById(R.id.blueberriesQty);
        final TextView peach =findViewById(R.id.peachQty);
        final TextView pineApple=findViewById(R.id.pineappleQty);


        Button Add=findViewById(R.id.addToCart);

        final StringBuilder str=new StringBuilder();

        final Intent u=getIntent();
        u.setClass(Fruits_Activity.this,Vegetables_Activity.class);






        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String appleQty=apple.getText().toString();
                if(appleQty.length()>0)
                {
                    u.putExtra("apple",appleQty);

                }

                String peachQty=peach.getText().toString();
                if(peachQty.length()>0) {
                       u.putExtra("peach",appleQty);
                    }

                String blueBerriesQty=blueBerries.getText().toString();
                if(blueBerriesQty.length()>0) {

                    u.putExtra("blueBerries",blueBerriesQty);
                    //str.append("Blueberries Quantity " + blueBerriesQty + "\n");
                }

                String bananaQty=banana.getText().toString();
                if(bananaQty.length()>0) {
                    //SendData(Fruits_Activity.this,"banana",bananaQty,ViewCartActivity.class);
                    u.putExtra("banana",bananaQty);
                   //str.append("Banana Quantity " + bananaQty + "\n");
                }

                String pineAppleQty=pineApple.getText().toString();
                if(pineAppleQty.length()>0) {
                    //SendData(Fruits_Activity.this,"pineapple",pineAppleQty,ViewCartActivity.class);
                    u.putExtra("pineApple",pineAppleQty);
                   //str.append("Pineapple Quantity " + pineAppleQty + "\n");
                }


                //u.putExtra("fruitsQty",str.toString());
                startActivity(u);


            }
        });





    }

    public void SendData(Context thisActivity,String name,String data,Class TargetClass)
    {
        Intent u=new Intent(thisActivity,TargetClass);
        u.putExtra(name,data);
        startActivity(u);
    }
}
