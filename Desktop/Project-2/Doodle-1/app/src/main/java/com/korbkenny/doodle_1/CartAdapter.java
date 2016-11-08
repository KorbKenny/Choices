package com.korbkenny.doodle_1;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.korbkenny.doodle_1.Database.ShopSQLHelper;
import com.korbkenny.doodle_1.Singletons.SingletonPictures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KorbBookProReturns on 11/7/16.
 */

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {
    List<ShopItem> mCartItemList;

    public CartAdapter(List<ShopItem> itemList){mCartItemList = itemList;}


    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new CartViewHolder(inflater.inflate(R.layout.shop_viewholder,parent,false));
    }

    @Override
    public void onBindViewHolder(final CartViewHolder holder, int position) {

        ArrayList<Integer> icons = SingletonPictures.getInstance().getIcons();
        List<Integer> ids = ShopSQLHelper.getInstance(holder.mIcon.getContext()).getIds();

        holder.mIcon.setImageResource(icons.get(mCartItemList.get(position).getIconId()));
        holder.mName.setText(mCartItemList.get(position).getName());
        holder.mPrice.setText(String.valueOf(mCartItemList.get(position).getPrice()));

        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return mCartItemList.size();
    }

    public void replaceData(List<ShopItem> newList){
        mCartItemList = newList;
        notifyDataSetChanged();
    }
}


