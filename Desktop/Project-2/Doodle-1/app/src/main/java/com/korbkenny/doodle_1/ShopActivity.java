package com.korbkenny.doodle_1;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.korbkenny.doodle_1.Database.DBAssetHelper;
import com.korbkenny.doodle_1.Database.ShopSQLHelper;
import com.korbkenny.doodle_1.Singletons.SingletonCurrentCash;

import java.util.List;

public class ShopActivity extends AppCompatActivity {

    ImageView mCartButton;
    TextView mCurrentCash;
    RecyclerView mRecyclerView;
    ShopAdapter mShopAdapter;
    List<ShopItem> mShopItemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        DBAssetHelper dbSetup = new DBAssetHelper(ShopActivity.this);
        dbSetup.getReadableDatabase();

        mShopItemList = ShopSQLHelper.getInstance(this).getAllAsList();

        mCartButton = (ImageView)findViewById(R.id.checkoutbutton);
        mCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });

        mCurrentCash = (TextView)findViewById(R.id.shopMoney);
        mCurrentCash.setText(Integer.toString(SingletonCurrentCash.getInstance().getCash()));

        mShopAdapter = new ShopAdapter(mShopItemList);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mShopAdapter);

        Intent intent = getIntent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        ComponentName componentName = new ComponentName(this,ShopActivity.class);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));

        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent){
        if(Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);
            List<ShopItem> searchList = ShopSQLHelper.getInstance(this).searchQuery(query);
            mShopAdapter.replaceData(searchList);
            }
    }

}
