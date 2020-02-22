package com.royali.mainproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ViewCartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);

        final RadioButton del = findViewById(R.id.deliveryBtn);
        final RadioButton pickup = findViewById(R.id.pickupbtn);

        final TextView cart=findViewById(R.id.cart);

        final Intent getdata=getIntent();

        StringBuilder str=new StringBuilder();

        double appleP = 2.00, bananaP = 1.50 , blueberriesP = 3.00, peachP = 2.50 , pineappleP = 5.50,
                milkP = 4.50 , eggP = 3.50 , chesseP = 2.50 , yogurtP = 3.20 , whippingP = 5.60,
                chickenP= 10.00 , porkP= 7.80, salmonP = 6.50, baconP = 3.40, thighP= 15.00 ,
                bellP = 3.00, tomatoesP = 2.30, zuchiniP = 5.70 , cucumberP = 4.50 , broccoliP = 3.30;

        int apple = 0,peach= 0,blueBerries= 0, banana= 0,pineApple= 0,bellpeppper= 0,zuchini= 0,broccoli= 0,milk= 0,eggs= 0,cheese= 0,
                yogurt= 0, wipping= 0,chicken= 0 , pork= 0, salmom= 0, bacon= 0,thigh= 0,tomatoes= 0,cucumber = 0;


        if(getdata.hasExtra("apple"))
        {
            str.append("apple :"+getdata.getExtras().getString("apple")+"\n");
            apple=Integer.parseInt(getdata.getExtras().getString("apple"));

        }
        if(getdata.hasExtra("peach"))
        {
            str.append("peach:"+getdata.getExtras().getString("peach")+"\n");
             peach=Integer.parseInt(getdata.getExtras().getString("peach"));
        }
        if(getdata.hasExtra("blueBerries"))
        {
            str.append("blueBerries: "+getdata.getExtras().getString("blueBerries")+"\n");
             blueBerries=Integer.parseInt(getdata.getExtras().getString("blueBerries"));
        }
        if(getdata.hasExtra("banana"))
        {
            str.append("banana: "+getdata.getExtras().getString("banana")+"\n");
             banana=Integer.parseInt(getdata.getExtras().getString("banana"));
        }
        if(getdata.hasExtra("pineApple"))
        {
            str.append("pineApple:"+getdata.getExtras().getString("pineApple")+"\n");
             pineApple=Integer.parseInt(getdata.getExtras().getString("pineApple"));
        }
        if(getdata.hasExtra("bellpeppper"))
        {
            str.append("bellpeppper: "+getdata.getExtras().getString("bellpeppper")+"\n");
             bellpeppper=Integer.parseInt(getdata.getExtras().getString("bellpeppper"));
        }
        if(getdata.hasExtra("zuchini"))
        {
            str.append("zuchini: "+getdata.getExtras().getString("zuchini")+"\n");
             zuchini=Integer.parseInt(getdata.getExtras().getString("zuchini"));
        }
        if(getdata.hasExtra("broccoli"))
        {
            str.append("broccoli:"+getdata.getExtras().getString("broccoli")+"\n");
             broccoli=Integer.parseInt(getdata.getExtras().getString("broccoli"));
        }
        if(getdata.hasExtra("tomatoes"))
        {
            str.append("tomatoes: "+getdata.getExtras().getString("tomatoes")+"\n");
             tomatoes=Integer.parseInt(getdata.getExtras().getString("tomatoes"));
        }
        if(getdata.hasExtra("cucumber"))
        {
            str.append("cucumber: "+getdata.getExtras().getString("cucumber")+"\n");
             cucumber=Integer.parseInt(getdata.getExtras().getString("cucumber"));
        }
        if(getdata.hasExtra("chicken"))
        {
            str.append("chicken: "+getdata.getExtras().getString("chicken")+"\n");
             chicken=Integer.parseInt(getdata.getExtras().getString("chicken"));
        }
        if(getdata.hasExtra("pork"))
        {
            str.append("pork: "+getdata.getExtras().getString("pork")+"\n");
             pork=Integer.parseInt(getdata.getExtras().getString("pork"));
        }
        if(getdata.hasExtra("salmom"))
        {
            str.append("salmom: "+getdata.getExtras().getString("salmom")+"\n");
             salmom=Integer.parseInt(getdata.getExtras().getString("salmom"));
        }
        if(getdata.hasExtra("bacon"))
        {
            str.append("bacon: "+getdata.getExtras().getString("bacon")+"\n");
             bacon=Integer.parseInt(getdata.getExtras().getString("bacon"));
        }
        if(getdata.hasExtra("thigh"))
        {
            str.append("thigh: "+getdata.getExtras().getString("thigh")+"\n");
             thigh=Integer.parseInt(getdata.getExtras().getString("thigh"));
        }
        if(getdata.hasExtra("milk"))
        {
            str.append("milk: "+getdata.getExtras().getString("milk")+"\n");
             milk=Integer.parseInt(getdata.getExtras().getString("milk"));
        }
        if(getdata.hasExtra("cheese"))
        {
            str.append("cheese: "+getdata.getExtras().getString("cheese")+"\n");
             cheese=Integer.parseInt(getdata.getExtras().getString("cheese"));
        }
        if(getdata.hasExtra("wipping"))
        {
            str.append("wipping: "+getdata.getExtras().getString("wipping")+"\n");
             wipping=Integer.parseInt(getdata.getExtras().getString("wipping"));
        }
        if(getdata.hasExtra("yogurt"))
        {
            str.append("yogurt:"+getdata.getExtras().getString("yogurt")+"\n");
             yogurt=Integer.parseInt(getdata.getExtras().getString("yogurt"));
        }
        if(getdata.hasExtra("eggs"))
        {
            str.append("eggs: "+getdata.getExtras().getString("eggs")+"\n");
             eggs=Integer.parseInt(getdata.getExtras().getString("eggs"));
        }







        /*if(getdata.hasExtra("Banana"))
        {
            str.append(getdata.getExtras().getString("banana"));
        }
        if(getdata.hasExtra("blueBerries"))
        {
            str.append(getdata.getExtras().getString("blueberries"));
        }
        if(getdata.hasExtra("peach"))
        {
            str.append(getdata.getExtras().getString("peach"));
        }
        if(getdata.hasExtra("pineApple"))
        {
            str.append(getdata.getExtras().getString("pineapple"));
        }*/

        double total= apple * appleP + banana * bananaP + blueBerries * blueberriesP + peach * peachP + pineApple* pineappleP +
                milk* milkP + eggs * eggP + cheese* chesseP + yogurt * yogurtP + wipping * whippingP +
                chicken* chickenP + pork* porkP +salmom * salmonP +bacon * baconP + thigh* thighP +
                bellpeppper * bellP + tomatoes * tomatoesP + zuchini* zuchiniP + cucumber* cucumberP + broccoli* broccoliP;



        str.append("Total: $" +Double.toString(total) );

        getdata.putExtra("cost",Double.toString(total));
        cart.setText(str);


        Button procced = findViewById(R.id.proccedbtn);

        procced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(del.isChecked()){
                    getdata.setClass(ViewCartActivity.this,DeliveryActivity.class);
                    startActivity(getdata);
                    //startActivity(new Intent(ViewCartActivity.this,DeliveryActivity.class));
                }
                if(pickup.isChecked()){

                    Toast.makeText(ViewCartActivity.this,"Please pickup your order after 30 minutes",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
