package com.korbkenny.doodle_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public static final String ID_KEY = "id_key";
    private TextView mTitle, mType, mColor, mDescription, mPrice;
    private ImageView mIcon;
    private Button mAddToCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTitle = (TextView)findViewById(R.id.detail_title);
        mType = (TextView)findViewById(R.id.detail_type);
        mColor = (TextView)findViewById(R.id.detail_color);
        mDescription = (TextView)findViewById(R.id.detail_description);
        mPrice = (TextView)findViewById(R.id.detail_price);
        mIcon = (ImageView)findViewById(R.id.detail_image);
        mAddToCart = (Button)findViewById(R.id.detail_button);



        int id = getIntent().getIntExtra(ID_KEY,-1);
        if(id == -1){finish();}

        ShopItem theItem = ShopSQLHelper
                .getInstance(this)
                .getItemByID(id);

        if(theItem == null){finish();}
        String pricePlus = "Price: ";
        String typePlus = "Type: ";
        String colorPlus = "Color: ";
        mTitle.setText(theItem.getName());
        mType.setText(typePlus + theItem.getType());
        mColor.setText(colorPlus + theItem.getColor());
        mDescription.setText(theItem.getDescription());
        mPrice.setText(pricePlus + theItem.getPrice());

        ArrayList<Integer> icons = SingletonPictures.getInstance().getIcons();
        mIcon.setImageResource(icons.get(id-1));

    }
}
