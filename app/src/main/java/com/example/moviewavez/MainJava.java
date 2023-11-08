package com.example.moviewavez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainJava extends AppCompatActivity {

    LinearLayout appname;
    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_java);

        appname=findViewById(R.id.textViewAppName);
        lottieAnimationView=findViewById(R.id.lottie);

        appname.animate().translationY(-1400).setDuration(2700).setStartDelay(0);
        lottieAnimationView.animate().translationX(2000).setDuration(2000).setStartDelay(2900);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(), Home.class);
                startActivity(intent);

            }
        },5000);

    }
}