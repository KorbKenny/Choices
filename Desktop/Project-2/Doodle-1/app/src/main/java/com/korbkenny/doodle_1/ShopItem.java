package com.korbkenny.doodle_1;

/**
 * Created by KorbBookProReturns on 10/31/16.
 */

public class ShopItem {
    private Integer mID;
    private int mPrice;
    private String mName, mType, mColor, mDescription;

    public ShopItem(Integer ID, String name, int price, String type, String color, String description) {
        mID = ID;
        mName = name;
        mPrice = price;
        mType = type;
        mColor = color;
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
}
