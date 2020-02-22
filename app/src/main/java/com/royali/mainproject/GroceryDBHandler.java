package com.royali.mainproject;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.support.v4.content.ContextCompat.startActivity;

public class GroceryDBHandler extends SQLiteOpenHelper {

    final static String DATABSE_NAME ="Grocery.db";
    final  static int DATABASE_VERSION=1;
    final  static  String TABLE1_NAME="User_table";

    final  static String T1COL1="id";
    final  static String T1COL2="UserName";
    final  static String T1COL3="Password";
    final  static String T1COL4="Email";
    final  static String T1COL5="CellNumber";
    final  static String T1COL6="Discount";
    final  static String T1COL7="Address";


    final  static  String TABLE2_NAME="Store_table";
    final  static String T2COL1="StoreId";
    final  static String T2COL2="Name";
    final  static String T2COL3="Address";
    final  static String T2COL4="Margin";

    final  static  String TABLE3_NAME="Item_Table";
    final  static String T3COL1="ItemId";
    final  static String T3COL2="ItemName";
    final  static String T3COL3="ItemMRP";

    final  static  String TABLE4_NAME="Order_Table";
    final  static String T4COL1="OrderId";
    final  static String T4COL2="UserId";
    final  static String T4COL3="TotalPrice";
    final  static String T4COL4="Address";


    final  static  String TABLE5_NAME="OrderDetails_Table";
    final  static String T5COL1="OrderDetailId";
    final  static String T5COL2="OrderId";
    final  static String T5COL3="ItemId";
    final  static String T5COL4="ItemQuantity";
    final  static String T5COL5="Cost";







    public GroceryDBHandler(Context context)
    {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+ TABLE1_NAME + "(" + T1COL1+ " INTEGER PRIMARY KEY," + T1COL2 + " TEXT," +
                T1COL3+ " TEXT," + T1COL4 +" TEXT," + T1COL5 + " TEXT," + T1COL6 + " TEXT," +T1COL7 +" TEXT)";
        db.execSQL(query);

        String query2="CREATE TABLE "+TABLE2_NAME+"("+T2COL1+" INTEGER PRIMARY KEY,"+T2COL2+" TEXT,"+
                T2COL3+" TEXT,"+T2COL4+" TEXT)";
        db.execSQL(query2);

        String query3="CREATE TABLE "+TABLE3_NAME+"("+T3COL1+" INTEGER PRIMARY KEY,"+T3COL2+" TEXT,"+
                T3COL3+" TEXT)";
        db.execSQL(query3);

        String query4="CREATE TABLE "+TABLE4_NAME+"("+T4COL1+" INTEGER PRIMARY KEY,"+T4COL2+" TEXT,"+
                T4COL3+" TEXT,"+T4COL4+" TEXT)";
        db.execSQL(query4);

        String query5="CREATE TABLE "+TABLE5_NAME+"("+T5COL1+" INTEGER PRIMARY KEY,"+T5COL2+" TEXT,"+
                T5COL3+" TEXT,"+T5COL4+" TEXT,"+T5COL5+" TEXT)";
        db.execSQL(query5);




    }

    public boolean addUser(String un,String pwd,String email,String CellNum,String Address){
        SQLiteDatabase SqLiteDatabase=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(T1COL2,un);
        values.put(T1COL3,pwd);
        values.put(T1COL4,email);
        values.put(T1COL5,CellNum);
        values.put(T1COL6,"No");
        values.put(T1COL7,Address);

        long r= SqLiteDatabase.insert(TABLE1_NAME,null,values);

        if(r>0){
            return true;
        }
        else{
            return  false;
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE3_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE4_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE5_NAME);
        onCreate(db);

    }

    public boolean checkUser(String email,String userPassword){

        if(email.length()>0 && userPassword.length()>0) {

            SQLiteDatabase db = this.getReadableDatabase();
            String query = "SELECT * FROM " + TABLE1_NAME + " WHERE " + T1COL4 + " = '" + email + "' AND " + T1COL3 + " = '" + userPassword + "'"; //columns to fetch
            // selection criteria
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst() && cursor.getCount() > 0)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    public Cursor showUserData(String email)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * from " + TABLE1_NAME+" WHERE "+T1COL4+" = '"+email+"'";
        Cursor c = sqLiteDatabase.rawQuery(query,null);
        return  c;
    }

    public void updateUser(String email,String val1,String val2,String val3,String val4)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String query="UPDATE "+TABLE1_NAME+" SET "+ T1COL2 +" = '"+val1+"'"+ " WHERE " + T1COL4+" = '"+email+"'";
        String query1="UPDATE "+TABLE1_NAME+" SET "+ T1COL4 +" = '"+val2+"'"+ " WHERE " + T1COL4+" = '"+email+"'";
        String query2="UPDATE "+TABLE1_NAME+" SET "+ T1COL5 +" = '"+val3+"'"+ " WHERE " + T1COL4+" = '"+email+"'";
        String query3="UPDATE "+TABLE1_NAME+" SET "+ T1COL7 +" = '"+val4+"'"+ " WHERE " + T1COL4+" = '"+email+"'";
        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL(query1);
        sqLiteDatabase.execSQL(query2);
        sqLiteDatabase.execSQL(query3);


    }

    public void updateData(String TableName,String Column,String Value,String id,String idColumn)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String query="UPDATE "+TableName+" SET "+ Column +" = '"+Value+"'"+ " WHERE " + idColumn+" = '"+id+"'";
        sqLiteDatabase.execSQL(query);

    }
    public boolean addOrder(String user,String totalprice,String Address)
    {
        SQLiteDatabase SqLiteDatabase=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(T4COL2,user);
        values.put(T4COL3,totalprice);
        values.put(T4COL4,Address);


        long r= SqLiteDatabase.insert(TABLE4_NAME,null,values);

        if(r>0){
            return true;
        }
        else{
            return  false;
        }
    }

    public Cursor getOrders()
    {
        SQLiteDatabase sqldb=this.getReadableDatabase();
        String query="SELECT * from " +TABLE4_NAME;
        Cursor c=sqldb.rawQuery(query,null);
        return c;

    }








}
