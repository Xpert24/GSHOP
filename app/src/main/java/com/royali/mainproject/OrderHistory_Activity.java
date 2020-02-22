package com.royali.mainproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OrderHistory_Activity extends AppCompatActivity {
    GroceryDBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history_);
        db=new GroceryDBHandler(this);
        Cursor c=db.getOrders();

        StringBuilder str=new StringBuilder();

        TextView orderHistory=findViewById(R.id.orderHistory);


        if(c.getCount()>0){
            c.moveToFirst();

            str.append("User id"+c.getString(1));

            orderHistory.setText(str);

            }



    }


}
