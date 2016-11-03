package com.korbkenny.doodle_1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView mDoodlePic, mDPicHair;
    Button mButton;
    TextView mDoodleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] doodle = {R.drawable.doodle_up,R.drawable.doodle_down};
        int[] dAccessoryUp = {R.drawable.emohair_up};
        int[] dAccessoryDown = {R.drawable.emohair_down};
        final int[] dHair = {R.drawable.emohair_up,R.drawable.emohair_down};

        mDoodlePic = (ImageView) findViewById(R.id.doodlePic);
        mDPicHair = (ImageView) findViewById(R.id.dpicHair);


        mButton = (Button) findViewById(R.id.ButtonShop);
        mDoodleName = (TextView) findViewById(R.id.Title);

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;
            public void run() {
                mDoodlePic.setImageResource(doodle[i]);
                if(dHair !=null){mDPicHair.setImageResource(dHair[i]);}
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

    }




}
