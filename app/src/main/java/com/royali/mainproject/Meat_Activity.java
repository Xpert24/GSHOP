package com.royali.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Meat_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meat_);


        /*Button vegemeatBtn = findViewById(R.id.vegemeatBtn);
        Button fruimeatBtn = findViewById(R.id.fruimeatBtn);
        Button dairymeatBtn = findViewById(R.id.dairymeatBtn);*/
        final Button meatAdd = findViewById(R.id.meatAdd);
        final Intent u=getIntent();

        final TextView chicken=findViewById(R.id.chickenQty);
        final TextView pork=findViewById(R.id.porkQty);
        final TextView salmom=findViewById(R.id.salmomQty);
        final TextView bacon=findViewById(R.id.baconQty);
        final TextView thigh=findViewById(R.id.thighQty);


       /* vegemeatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Meat_Activity.this,Vegetables_Activity.class));
            }
        });
        fruimeatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Meat_Activity.this,Fruits_Activity.class));
            }
        });
        dairymeatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Meat_Activity.this,DairyProducts_Activity.class));
            }
        });*/
        meatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u.setClass(Meat_Activity.this,DairyProducts_Activity.class);

                        String appleQty=chicken.getText().toString();
                        if(appleQty.length()>0)
                        {
                            u.putExtra("chicken",appleQty);
                            //str.append("bellpeppper Quanitity " + appleQty + "\n");
                            //SendData(Fruits_Activity.this,"apple",appleQty,ViewCartActivity.class);
                        }

                        String peachQty=pork.getText().toString();
                        if(peachQty.length()>0)
                        {
                            u.putExtra("pork",peachQty);
                            //SendData(Fruits_Activity.this,"peach",peachQty,ViewCartActivity.class);
                            //str.append("zuchini Quanitity " + peachQty + "\n");
                        }

                        String blueBerriesQty=salmom.getText().toString();
                        if(blueBerriesQty.length()>0) {

                            //SendData(Fruits_Activity.this,"blueberries",blueBerriesQty,ViewCartActivity.class);
                            u.putExtra("salmom",blueBerriesQty);
                            //str.append("broccoli Quantity " + blueBerriesQty + "\n");
                        }

                        String bananaQty=bacon.getText().toString();
                        if(bananaQty.length()>0) {
                            //SendData(Fruits_Activity.this,"banana",bananaQty,ViewCartActivity.class);
                            u.putExtra("bacon",bananaQty);
                            //str.append("tomatoes Quantity " + bananaQty + "\n");
                        }

                        String pineAppleQty=thigh.getText().toString();
                        if(pineAppleQty.length()>0) {
                            //SendData(Fruits_Activity.this,"pineapple",pineAppleQty,ViewCartActivity.class);
                            u.putExtra("thigh",pineAppleQty);
                            //str.append("cucumber Quantity " + pineAppleQty + "\n");
                        }

                        startActivity(u);
            }
        });



    }
}