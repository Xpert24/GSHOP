package com.royali.mainproject;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class DeliveryActivity extends AppCompatActivity {
    GroceryDBHandler db;
    SharedPreferences sp;
    double price=0;
    double discountedPrice=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        Button pay = findViewById(R.id.payBtn); // pay button

        //display user data for delivery
        TextView address=findViewById(R.id.dAdd);
        TextView phn=findViewById(R.id.dPhone);
        TextView total=findViewById(R.id.toalCost);
        String discount="";

        //using shared prefences to fetch user data
        sp= PreferenceManager.getDefaultSharedPreferences(this);

        double deliveryCharge=3.45; // variable for delivery charges
        double cost=0;


        // creating order table for user
        db=new GroceryDBHandler(this);

        Intent u=getIntent();
        final String email=sp.getString("email"," ");
        final Cursor c = db.showUserData(email);
        if(c.getCount()>0 && c.moveToFirst()){

            address.setText(c.getString(6));
            phn.setText(c.getString(4));
        }
        if(u.hasExtra("cost")) {
            cost = Double.parseDouble(u.getExtras().getString("cost"));
        }




        // adding delivery charges to total

        price=cost+deliveryCharge;
        discountedPrice=price-(price*0.1);

        if(c.getString(5)=="Yes") {
            total.setText(Double.toString(price)+"- 10% Discount $"+discountedPrice);
            price=discountedPrice;

        }
        else
        {
            total.setText("$" + Double.toString(price));
        }



        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addOrder(email,Double.toString(price),c.getString(6));
                db.close();

                startActivity(new Intent(DeliveryActivity.this,PaymentActivity.class));
            }
        });
    }


}
