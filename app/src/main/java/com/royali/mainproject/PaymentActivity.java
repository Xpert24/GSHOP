package com.royali.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_payment);

        TextView cName = findViewById(R.id.cName);
        TextView Cnum = findViewById(R.id.Cnum);
        TextView cvv = findViewById(R.id.cvv);

        RadioButton cash = findViewById(R.id.cash);
        RadioButton card = findViewById(R.id.card);

        Button logout =findViewById(R.id.logoutBtn);

        if(cash.isChecked()){
            Toast.makeText(PaymentActivity.this,"Thank you! for choosing cash on delivery",Toast.LENGTH_LONG).show();

        }

        Button order = findViewById(R.id.order);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PaymentActivity.this,"Thank you! your order will arrive soon",Toast.LENGTH_LONG).show();
            }
        });

      logout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(PaymentActivity.this,LoginActivity.class));
          }
      });

    }


}
