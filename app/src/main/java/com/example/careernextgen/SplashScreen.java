package com.example.careernextgen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER=4000;

    //variables

    TextView splashMotto;
    LottieAnimationView lottieAnimationView;

//    private static final int NUM_PAGES=3;
//    private ViewPager viewPager;
//    private ScreenSlidePagerAdapter pagerAdapter;

    //Animations
    Animation sideAnim,bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //hooks

        splashMotto=findViewById(R.id.motto);
        lottieAnimationView=findViewById(R.id.lottie);

//viewPager=findViewById(R.id.pager);
//pagerAdapter=new ScreenSlidePagerAdapter(getSupportFragmentManager());
//viewPager.setAdapter(pagerAdapter);

        //Animations
        sideAnim= AnimationUtils.loadAnimation(this,R.anim.side_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        //splashMotto.animate().translationY(-1400).setDuration(1000).setStartDelay(4000);
        //set animations on elements

        splashMotto.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),Walkthrough.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_TIMER);
    }

    }



