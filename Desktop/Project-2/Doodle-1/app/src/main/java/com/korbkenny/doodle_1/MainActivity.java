package com.korbkenny.doodle_1;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.korbkenny.doodle_1.Database.ShopSQLHelper;
import com.korbkenny.doodle_1.Singletons.SingletonEquip;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView mDoodlePic, dPicHair, dPicHat, dPicShoes, dPicElemental, dPicWeapon;
    Button mButton, mRefresh, mEquip;
    TextView mDoodleName;
    List<Integer> dHair, dHat, dElemental, dWeapon, dShoes;
    List<Integer> doodle = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final int[] doodle = {R.drawable.up_doodle,R.drawable.down_doodle};


//        final int[] dHair = {R.drawable.up6truckerred,R.drawable.down6truckerred};
//        final int[] dWeapon = {R.drawable.up11strongarm, R.drawable.down11strongarm};

        mDoodlePic = (ImageView) findViewById(R.id.doodlePic);
        dPicHair = (ImageView) findViewById(R.id.dpicHair);
        dPicWeapon = (ImageView) findViewById(R.id.dpicWeapon);
        dPicElemental = (ImageView) findViewById(R.id.dpicElemental);
        dPicHat = (ImageView) findViewById(R.id.dpicHat);
        dPicShoes = (ImageView) findViewById(R.id.dpicShoes);

        mRefresh = (Button) findViewById(R.id.ButtonRefresh);

        mButton = (Button) findViewById(R.id.ButtonShop);
        mEquip = (Button) findViewById(R.id.ButtonEquip);
        mDoodleName = (TextView) findViewById(R.id.Title);

        doodle.add(R.drawable.up_doodle);
        doodle.add(R.drawable.down_doodle);

        dHair = SingletonEquip.getInstance().getHair();
        dHat = SingletonEquip.getInstance().getHat();
        dWeapon = SingletonEquip.getInstance().getWeapon();
        dElemental = SingletonEquip.getInstance().getElemental();
        dShoes = SingletonEquip.getInstance().getShoes();

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;
            public void run() {
                mDoodlePic.setImageResource(doodle.get(i));
                if(!dHair.isEmpty()) {
                    dPicHair.setImageResource(dHair.get(i));
                }
                if(!dWeapon.isEmpty()){
                    dPicWeapon.setImageResource(dWeapon.get(i));
                }
                if(!dHat.isEmpty()){
                    dPicHat.setImageResource(dHat.get(i));
                }
                if(!dElemental.isEmpty()){
                    dPicElemental.setImageResource(dElemental.get(i));
                }
                if(!dShoes.isEmpty()){
                    dPicShoes.setImageResource(dShoes.get(i));
                }

                i++;
                if(i == 2){i = 0;}
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ShopActivity.class);
                startActivity(intent);
            }
        });

        mEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,EquipActivity.class);
                startActivity(intent);
            }
        });

        mRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ShopItem> allItems = ShopSQLHelper.getInstance(MainActivity.this).getBought();
                ShopSQLHelper.getInstance(MainActivity.this).nothingBought(allItems);
                Toast.makeText(MainActivity.this, "Started Over", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        doodle.add(R.drawable.up_doodle);
//        doodle.add(R.drawable.down_doodle);
//
//        dHair = SingletonEquip.getInstance().getHair();
//        dHat = SingletonEquip.getInstance().getHat();
//        dWeapon = SingletonEquip.getInstance().getWeapon();
//        dElemental = SingletonEquip.getInstance().getElemental();
//        dShoes = SingletonEquip.getInstance().getShoes();
//
//        final Handler handler = new Handler();
//        Runnable runnable = new Runnable() {
//            int i = 0;
//            public void run() {
//                mDoodlePic.setImageResource(doodle.get(i));
//                if(!dHair.isEmpty()) {
//                    dPicHair.setImageResource(dHair.get(i));
//                }
//                if(!dWeapon.isEmpty()){
//                    dPicWeapon.setImageResource(dWeapon.get(i));
//                }
//                if(!dHat.isEmpty()){
//                    dPicHat.setImageResource(dHat.get(i));
//                }
//                if(!dElemental.isEmpty()){
//                    dPicElemental.setImageResource(dElemental.get(i));
//                }
//                if(!dShoes.isEmpty()){
//                    dPicShoes.setImageResource(dShoes.get(i));
//                }
//
//                i++;
//                if(i == 2){i = 0;}
//                handler.postDelayed(this, 1000);
//            }
//        };
//        handler.postDelayed(runnable, 1000);
    }



