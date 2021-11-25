package com.weeworld.gogodriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashDriverActivity extends AppCompatActivity {

    Animation logo_anim , slogan_anim;
    ImageView driver_logo;
    TextView slogan_sp;

    private static int sp_screen = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_driver);

        logo_anim = AnimationUtils.loadAnimation(this,R.anim.logo_anim);

        driver_logo = findViewById(R.id.driver_logo);

        driver_logo.setAnimation(logo_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashDriverActivity.this , LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },sp_screen);
    }
}