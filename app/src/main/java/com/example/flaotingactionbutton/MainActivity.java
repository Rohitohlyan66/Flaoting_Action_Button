package com.example.flaotingactionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton plus,fav,shop;
    Animation open,close,clockwise,anticlockwise;
    boolean isopen=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus=findViewById(R.id.fab_plus);
        fav=findViewById(R.id.fab_fav);
        shop=findViewById(R.id.fab_shop);

        open= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        close= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        clockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        anticlockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isopen)
                {
                    fav.startAnimation(close);
                    shop.startAnimation(close);
                    plus.startAnimation(anticlockwise);
                    close.setDuration(300);
                    anticlockwise.setDuration(300);
                    fav.setClickable(false);
                    shop.setClickable(false);
                    isopen=false;
                }

                else
                {
                    fav.startAnimation(open);
                    shop.startAnimation(open);
                    plus.startAnimation(clockwise);
                    open.setDuration(300);
                    clockwise.setDuration(300);
                    fav.setClickable(true);
                    shop.setClickable(true);
                    isopen=true;
                }
            }
        });
    }
}
