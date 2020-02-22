package com.royali.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Vegetables_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables_);

        /*Button fruirvegeBtn = findViewById(R.id.fruirvegeBtn);
        Button meatBtn = findViewById(R.id.meatBtn);
        Button dairyvegeBtn = findViewById(R.id.dairyvegeBtn);*/
        Button vegeAdd = findViewById(R.id.vegeAdd);
        final StringBuilder str=new StringBuilder();

        final TextView bellpeppper=findViewById(R.id.bellpeppperQty);
        final TextView zuchini=findViewById(R.id.zuchiniQty);
        final TextView broccoli=findViewById(R.id.broccoliQty);
        final TextView tomatoes=findViewById(R.id.tomatoesQty);
        final TextView cucumber=findViewById(R.id.cucumberQty);



        /*fruirvegeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Vegetables_Activity.this,Fruits_Activity.class));
            }
        });

        meatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Vegetables_Activity.this,Meat_Activity.class));
            }
        });

        dairyvegeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Vegetables_Activity.this,DairyProducts_Activity.class));
            }
        });*/

        final Intent u=getIntent();
        u.setClass(Vegetables_Activity.this,Meat_Activity.class);

        vegeAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String appleQty=bellpeppper.getText().toString();
                if(appleQty.length()>0)
                {
                    u.putExtra("bellpeppper",appleQty);
                    //str.append("bellpeppper Quanitity " + appleQty + "\n");
                    //SendData(Fruits_Activity.this,"apple",appleQty,ViewCartActivity.class);
                }

                String peachQty=zuchini.getText().toString();
                if(peachQty.length()>0) {
                    u.putExtra("zuchini",peachQty);
                    //SendData(Fruits_Activity.this,"peach",peachQty,ViewCartActivity.class);
                    //str.append("zuchini Quanitity " + peachQty + "\n");
                }

                String blueBerriesQty=broccoli.getText().toString();
                if(blueBerriesQty.length()>0) {

                    //SendData(Fruits_Activity.this,"blueberries",blueBerriesQty,ViewCartActivity.class);
                    u.putExtra("broccoli",blueBerriesQty);
                    //str.append("broccoli Quantity " + blueBerriesQty + "\n");
                }

                String bananaQty=tomatoes.getText().toString();
                if(bananaQty.length()>0) {
                    //SendData(Fruits_Activity.this,"banana",bananaQty,ViewCartActivity.class);
                    u.putExtra("tomatoes",bananaQty);
                    //str.append("tomatoes Quantity " + bananaQty + "\n");
                }

                String pineAppleQty=cucumber.getText().toString();
                if(pineAppleQty.length()>0) {
                    //SendData(Fruits_Activity.this,"pineapple",pineAppleQty,ViewCartActivity.class);
                    u.putExtra("cucumber",pineAppleQty);
                    //str.append("cucumber Quantity " + pineAppleQty + "\n");
                }

                startActivity(u);

            }
        });




    }
}
