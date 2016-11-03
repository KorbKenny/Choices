package com.korbkenny.doodle_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    public static final String ID_KEY = "id_key";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);





        int id = getIntent().getIntExtra(ID_KEY,-1);
        if(id == -1){finish();}

        ShopItem item = ShopSQLHelper
                .getInstance(this)
                .getItemId(id);

        if(item == null){finish();}
    }
}
