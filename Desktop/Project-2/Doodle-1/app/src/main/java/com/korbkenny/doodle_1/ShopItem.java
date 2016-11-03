package com.korbkenny.doodle_1;

/**
 * Created by KorbBookProReturns on 10/31/16.
 */

public class ShopItem {
    private Integer mID;
    private int mPrice, mBought;
    private String mName, mType, mColor, mDescription;

    public ShopItem(Integer ID, String name, int price, String type, String color, String description, int bought) {
        mID = ID;
        mName = name;
        mPrice = price;
        mType = type;
        mColor = color;
        mDescription = description;
        mBought = bought;
    }


    public void setBought(int bought) {
        mBought = bought;
    }

    public void setPrice(int price) {
        mPrice = price;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setType(String type) {
        mType = type;
    }

    public void setColor(String color) {
        mColor = color;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Integer getID() {
        return mID;
    }

    public int getPrice() {
        return mPrice;
    }

    public String getName() {
        return mName;
    }

    public String getType() {
        return mType;
    }

    public String getColor() {
        return mColor;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getBought() {
        return mBought;
    }
}
