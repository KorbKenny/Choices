package com.korbkenny.doodle_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.List;

public class ShopActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ShopAdapter mShopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        List<ShopItem> shopItemList = ShopSQLHelper.getmInstance(this).getAllAsList();

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(new ShopAdapter(shopItemList));

        Intent intent = getIntent();




    }
}
