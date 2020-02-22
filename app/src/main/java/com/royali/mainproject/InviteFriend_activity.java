package com.royali.mainproject;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InviteFriend_activity extends AppCompatActivity {

    GroceryDBHandler db;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friend_activity);
        db=new GroceryDBHandler(this);
        final EditText userEmail=findViewById(R.id.userEmail);
        final EditText friendEmail=findViewById(R.id.friendEmail);
        Button send=findViewById(R.id.sendBtn);
        sp= PreferenceManager.getDefaultSharedPreferences(this);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkEmail(userEmail)||checkEmail(friendEmail))
                {
                    Toast.makeText(InviteFriend_activity.this, "Thanks for inviting your friend!", Toast.LENGTH_LONG).show();
                    String email=sp.getString("email"," ");
                    db.updateData("User_table","Discount","Yes",email,"Email");
                    db.close();


                }
            }
        });
    }
    static boolean checkEmail(EditText v)
    {
        String text=v.getText().toString();
        if(text.length()<=0||!text.contains("@")||!text.contains("."))
            return false;
        else
            return true;

    }
}
