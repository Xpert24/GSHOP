package com.royali.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;



public class FindStore_Activity extends AppCompatActivity {
    int currentPos =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_store_);

        final Intent ch=getIntent();

        EditText postal = findViewById(R.id.postalAddress);
        Button findStore = findViewById(R.id.findStore);
        Button profileBtn = findViewById(R.id.profileBtn);
        final Spinner list =findViewById(R.id.storeList);

        findStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(FindStore_Activity.this, "Please Select a store", Toast.LENGTH_LONG).show();
                list.setVisibility(View.VISIBLE);


            }
        });

        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if(currentPos==position){
                    return;

                }

                else{
                    ch.setClass(FindStore_Activity.this,Store_Activity.class);
                    ch.putExtra("Ch", list.getSelectedItem().toString());
                    startActivity(ch);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
     profileBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(FindStore_Activity.this,MyProfile_Activity.class));
    }
});




    }




}
