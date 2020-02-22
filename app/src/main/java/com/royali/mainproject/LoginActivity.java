package com.royali.mainproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;
import static android.support.v4.content.ContextCompat.startActivity;

public class LoginActivity extends AppCompatActivity {

    GroceryDBHandler db;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db=new GroceryDBHandler(this);


        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);

        Button signIn = findViewById(R.id.signIn);
        Button register = findViewById(R.id.register);
        sp= PreferenceManager.getDefaultSharedPreferences(this);
        editor=sp.edit();





        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean check=db.checkUser(username.getText().toString(),password.getText().toString());


                if(check) {
                  //  Toast.makeText(LoginActivity.this, "You are Logged in now!", Toast.LENGTH_LONG).show();

                    editor.putString("email",username.getText().toString());
                    editor.commit();
                    Intent u=new Intent(LoginActivity.this,MyProfile_Activity.class);
                    u.putExtra("User", username.getText().toString());
                    startActivity(u);

                    //u.setClass(LoginActivity.this,DeliveryActivity.class);
                    //startActivity(u);

                    u.setClass(LoginActivity.this,FindStore_Activity.class);

                    //startActivity(new Intent(LoginActivity.this, FindStore_Activity.class));
                    startActivity(u);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "You are registered now!", Toast.LENGTH_LONG).show();
                }
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

    }


}
