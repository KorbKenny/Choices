package com.korbkenny.doodle_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.korbkenny.doodle_1.Singletons.SingletonCart;
import com.korbkenny.doodle_1.Singletons.SingletonCurrentCash;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    TextView mCash1, mCash2, mCash3;
    ImageView mCheckout;
    RecyclerView mRecyclerView;
    CartAdapter mCartAdapter;
    ArrayList<ShopItem> mShopItems;
    int mTotal, mCurrent, mDifference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);



        mShopItems = SingletonCart.getInstance().getItemsInCart();
        for(int i = 0; i < mShopItems.size(); i++){
            mTotal += mShopItems.get(i).getPrice();
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.cart_recyclerview);
        mCartAdapter = new CartAdapter(mShopItems);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mCartAdapter);

        mCash1 = (TextView) findViewById(R.id.cart_current_cash);
        mCash2 = (TextView) findViewById(R.id.cart_total);
        mCash3 = (TextView) findViewById(R.id.cart_remaining);

        mCheckout = (ImageView) findViewById(R.id.cart_checkout_button);

        mCurrent = SingletonCurrentCash.getInstance().getCash();
        mDifference = mCurrent - mTotal;

        String current = Integer.toString(mCurrent);
        String total = Integer.toString(mTotal);
        String difference = Integer.toString(mDifference);

        mCash1.setText("Current Cash: " + current);
        mCash2.setText("Total: " + total);
        mCash3.setText("Remaining: " + difference);


        mCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mDifference < 0){
                    Toast.makeText(CartActivity.this, "Not enough money!", Toast.LENGTH_SHORT).show();
                }
                else{
                    for (int i = 0; i < mShopItems.size(); i++) {
                        mShopItems.get(i).setBought(1);
                    }
                    Toast.makeText(CartActivity.this, "Purchase Complete", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });






    }
}
