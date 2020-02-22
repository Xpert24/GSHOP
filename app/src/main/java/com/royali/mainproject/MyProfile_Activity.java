package com.royali.mainproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MyProfile_Activity extends AppCompatActivity {
    GroceryDBHandler db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_);
        db=new GroceryDBHandler(this);
        final TextView Pname = findViewById(R.id.Pname);
        final TextView pEmail = findViewById(R.id.pEmail);
        final TextView paddress = findViewById(R.id.paddress);
        final TextView phnNum = findViewById(R.id.phnNum);

        Button orderHistory =  findViewById(R.id.orderHistory);
       // Button orderReport = findViewById(R.id.orderReport);
        Button inviteBtn =  findViewById(R.id.inviteBtn);
        Button update=findViewById(R.id.updateBtn);

        Intent getUser=getIntent();
        String email=getUser.getExtras().getString("User");


        c = db.showUserData(email);
        StringBuilder str  = new StringBuilder();
        if(c.getCount()>0){
            c.moveToFirst();
            Pname.setText(c.getString(1));
            pEmail.setText(c.getString(3));
            paddress.setText(c.getString(6));
            phnNum.setText(c.getString(4));

        }
        orderHistory.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MyProfile_Activity.this,OrderHistory_Activity.class));
    }
});

        inviteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyProfile_Activity.this,InviteFriend_activity.class));
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                db.updateUser(c.getString(3),Pname.getText().toString(),pEmail.getText().toString(),phnNum.getText().toString(),paddress.getText().toString());

                Toast.makeText(MyProfile_Activity.this, "Your order has been updated!", Toast.LENGTH_LONG).show();
            }
        });


    }
}
