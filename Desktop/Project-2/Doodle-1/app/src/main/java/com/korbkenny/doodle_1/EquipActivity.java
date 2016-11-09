package com.korbkenny.doodle_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.korbkenny.doodle_1.Database.ShopSQLHelper;

import java.util.List;

public class EquipActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    EquipAdapter mEquipAdapter;
    List<ShopItem> mShopItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip);


        mShopItemList = ShopSQLHelper.getInstance(this).getBought();

        mEquipAdapter = new EquipAdapter(mShopItemList);
        mRecyclerView = (RecyclerView) findViewById(R.id.equipRecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mEquipAdapter);

        getIntent();



    }
}
