package com.korbkenny.doodle_1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KorbBookProReturns on 10/31/16.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopViewHolder> {
    List<ShopItem> mShopItemList;

    public ShopAdapter(List<ShopItem> itemList){mShopItemList = itemList;}


    @Override
    public ShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ShopViewHolder(inflater.inflate(R.layout.shop_viewholder,parent,false));
    }

    @Override
    public void onBindViewHolder(ShopViewHolder holder, int position) {
        //holder.mIcon.setImageResource();

        ArrayList<Integer> icons = SingletonPictures.getInstance().getIcons();

        holder.mIcon.setImageResource(icons.get(position));
        holder.mName.setText(mShopItemList.get(position).getName());
        holder.mPrice.setText(Integer.toString(mShopItemList.get(position).getPrice()));

    }

    @Override
    public int getItemCount() {
        return mShopItemList.size();
    }
}
