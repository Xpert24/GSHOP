package com.royali.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    GroceryDBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db=new GroceryDBHandler(this);

      final EditText user = findViewById(R.id.user);

        final EditText email = findViewById(R.id.email);

        final EditText pswrd = findViewById(R.id.pswrd);
        final EditText address = findViewById(R.id.address);
        final EditText phNum = findViewById(R.id.phNum);

        final Button signUpbtn = findViewById(R.id.signUpbtn);


        signUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkNull(user)&&checkNull(pswrd)&&checkNull(email)&&checkNull(phNum)&&checkNull(address)) {
                    db.addUser(user.getText().toString(), pswrd.getText().toString(), email.getText().toString(), phNum.getText().toString(), address.getText().toString());
                    db.close();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                    Toast.makeText(RegisterActivity.this, "You are registered now!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Please fill out the empty fields", Toast.LENGTH_LONG).show();
                }
            }
        });




    }
    static boolean checkNull(EditText v)
    {
        String text=v.getText().toString();
        if(text.length()<=0)
            return false;
        else
            return true;

    }


}
