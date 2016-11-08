package com.korbkenny.doodle_1.Singletons;

import android.widget.Toast;

import com.korbkenny.doodle_1.ShopItem;

import java.util.ArrayList;

/**
 * Created by KorbBookProReturns on 11/7/16.
 */
public class SingletonCart {
    private static SingletonCart cartInstance;
    private ArrayList<ShopItem> mItemsInCart;

    public static SingletonCart getInstance() {
        if(cartInstance == null){
            cartInstance = new SingletonCart();
        }
        return cartInstance;
    }

    private SingletonCart() {
        mItemsInCart = new ArrayList<>();
    }

    public void addToCart(ShopItem itemToAdd) {
        if (!mItemsInCart.contains(itemToAdd)) {
            mItemsInCart.add(itemToAdd);
        }
    }

    public void removeFromCart(ShopItem itemToRemove){
        mItemsInCart.remove(itemToRemove);
    }

    public ArrayList<ShopItem> getItemsInCart(){
        return mItemsInCart;
    }
}
