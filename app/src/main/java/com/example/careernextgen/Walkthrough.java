package com.example.careernextgen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.careernextgen.HelperClass.SliderAdapter;
import com.example.careernextgen.Sign.Login;

public class Walkthrough extends AppCompatActivity {
    ViewPager viewPager;
    ViewPager2 viewpager2;

    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;

    TextView[] dots;
    Button letsGetStarted,skip_btn;
    Animation animation;
    int currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_walkthrough);
        viewPager=findViewById(R.id.slider);
        dotsLayout=findViewById(R.id.dots);
        letsGetStarted=findViewById(R.id.get_started_btn);



        letsGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Walkthrough.this, Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });

        //call adapter
        sliderAdapter=new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);

        viewPager.addOnPageChangeListener(changeListener);

        skip_btn = findViewById(R.id.skip_btn);
        skip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Walkthrough.this, Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });

    }

    public void skip(View view){
    }

    public void next(View view){
        viewPager.setCurrentItem(currentPos+1);


    }

    private void addDots(int position){

        dots=new TextView[3];
        dotsLayout.removeAllViews();

        for (int i=0;i<dots.length;i++){

            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if (dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.white));
        }

    }

    ViewPager.OnPageChangeListener changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);

            currentPos=position;

            if (position==0){
                letsGetStarted.setVisibility(View.INVISIBLE);

            }
            else if (position==1){
                letsGetStarted.setVisibility(View.INVISIBLE);

            }
            else{
                animation= AnimationUtils.loadAnimation(Walkthrough.this,R.anim.bottom_animation);
                letsGetStarted.setAnimation(animation);
                letsGetStarted.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    }
