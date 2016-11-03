package com.korbkenny.doodle_1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KorbBookProReturns on 10/31/16.
 */

public class ShopSQLHelper extends SQLiteOpenHelper {
    private static final String TAG = ShopSQLHelper.class.getCanonicalName();

    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "DoodleShopItems.db";
    public static final String SHOP_TABLE = "SHOP_TABLE";

    public static final String COL_ID = "ID";
    public static final String COL_NAME = "NAME";
    public static final String COL_PRICE = "PRICE";
    public static final String COL_TYPE = "TYPE";
    public static final String COL_COLOR = "COLOR";
    public static final String COL_DESCRIPTION = "DESCRIPTION";
    public static final String COL_BOUGHT = "BOUGHT";

    public static final String[] ALL_COLUMNS = {COL_ID,COL_NAME,COL_PRICE,COL_TYPE,COL_COLOR,COL_DESCRIPTION,COL_BOUGHT};

    private static final String CREATE_TABLE =
            "CREATE TABLE " + SHOP_TABLE + "(" +
                    COL_ID + " INTEGER PRIMARY KEY, " +
                    COL_NAME + " TEXT, " +
                    COL_PRICE + " INTEGER, " +
                    COL_TYPE + " TEXT, " +
                    COL_COLOR + " TEXT, " +
                    COL_DESCRIPTION + " TEXT, " +
                    COL_BOUGHT + " INTEGER)";

    private static ShopSQLHelper mInstance;

    public static ShopSQLHelper getInstance(Context context){
        if(mInstance == null){
            mInstance = new ShopSQLHelper(context.getApplicationContext());
        }
        return mInstance;
    }

    private ShopSQLHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SHOP_TABLE);
        this.onCreate(db);
    }

    public List<ShopItem> getAllAsList(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(SHOP_TABLE,
                ALL_COLUMNS,null,null,null,null,null);

        List<ShopItem> itemList = new ArrayList<>();

        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                Integer id = cursor.getInt(cursor.getColumnIndex(COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
                int price = cursor.getInt(cursor.getColumnIndex(COL_PRICE));
                String type = cursor.getString(cursor.getColumnIndex(COL_TYPE));
                String color = cursor.getString(cursor.getColumnIndex(COL_COLOR));
                String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                int bought = cursor.getInt(cursor.getColumnIndex(COL_BOUGHT));

                ShopItem shopItem = new ShopItem(id,name,price,type,color,description,bought);
                itemList.add(shopItem);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return itemList;
    };

    public ShopItem getItemID(int id){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(SHOP_TABLE, // a. table
                ALL_COLUMNS, // b. column names
                COL_ID + " = ?", // c. selections
                new String[] {String.valueOf(id)}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
    }
}
