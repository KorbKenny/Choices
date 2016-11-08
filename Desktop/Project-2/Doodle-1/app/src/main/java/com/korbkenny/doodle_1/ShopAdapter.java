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
    public void onBindViewHolder(final ShopViewHolder holder, int position) {
        //holder.mIcon.setImageResource();

        ArrayList<Integer> icons = SingletonPictures.getInstance().getIcons();
        List<Integer> ids = ShopSQLHelper.getInstance(holder.mIcon.getContext()).getIds();

        holder.mIcon.setImageResource(icons.get(mShopItemList.get(position).getIconId()));
        holder.mName.setText(mShopItemList.get(position).getName());
        holder.mPrice.setText(String.valueOf(mShopItemList.get(position).getPrice()));

        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DetailActivity.class);
                intent.putExtra(DetailActivity.ID_KEY,mShopItemList.get(holder.getAdapterPosition()).getID());
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mShopItemList.size();
    }

    public void replaceData(List<ShopItem> newList){
        mShopItemList = newList;
        notifyDataSetChanged();
    }
}
