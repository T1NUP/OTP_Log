package com.example.otp_log;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class OnboardAdapter extends PagerAdapter {

    Context ctx;
    String text[]= new String[3];//array for text storage for displaying in on boards
    Animation animation,animation1,animation2,animation3;
    //constructor for initialization
    public OnboardAdapter(Context context, String text[]) {
        this.ctx = context;
        for(int i=0;i<3;i++)
        {
            this.text[i]= text[i];
        }
    }

    @Override
    public int getCount() {
        return 3;
    }//setting no of boards 3.

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    //Putting everything in layouts
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        LayoutInflater layoutInflater= (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.disp,container,false);

        ImageView big= view.findViewById(R.id.pic1);//big title image

        ImageView i1= view.findViewById(R.id.doa);//for sliding button1
        ImageView i2= view.findViewById(R.id.d);//for sliding button2
        ImageView i3= view.findViewById(R.id.dob);//for sliding button3

        TextView title= view.findViewById(R.id.text1);//text on board

        Button button= view.findViewById(R.id.start);//next button

        //for designing different boards
        switch (position)
        {
            case 0:
                big.setImageResource(R.drawable.earth);
                title.setText(text[position]);
                i2.setVisibility(View.INVISIBLE);
                i3.setVisibility(View.INVISIBLE);
                button.setText("Next");

                 animation= AnimationUtils.loadAnimation(ctx,R.anim.fadein);
                 animation1= AnimationUtils.loadAnimation(ctx,R.anim.lefttoright);
                 animation2= AnimationUtils.loadAnimation(ctx,R.anim.blink_anim);
                 animation3= AnimationUtils.loadAnimation(ctx,R.anim.zoomout);
                big.startAnimation(animation);
                title.startAnimation(animation1);
                i1.startAnimation(animation3);
                button.startAnimation(animation2);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intro.viewPager.setCurrentItem(position+1);
                    }
                });
                break;
            case 1:
                big.setImageResource(R.drawable.news);
                title.setText(text[position]);
                i1.setVisibility(View.INVISIBLE);
                i2.setVisibility(View.VISIBLE);
                i3.setVisibility(View.INVISIBLE);
                button.setText("Next");

                 animation= AnimationUtils.loadAnimation(ctx,R.anim.fadein);
                 animation1= AnimationUtils.loadAnimation(ctx,R.anim.lefttoright);
                 animation2= AnimationUtils.loadAnimation(ctx,R.anim.blink_anim);
                 animation3= AnimationUtils.loadAnimation(ctx,R.anim.zoomout);
                big.startAnimation(animation);
                title.startAnimation(animation1);
                i2.startAnimation(animation3);
                button.startAnimation(animation2);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intro.viewPager.setCurrentItem(position+1);
                    }
                });
                break;
            case 2:
                big.setImageResource(R.drawable.earthnews);
                title.setText(text[position]);
                i1.setVisibility(View.INVISIBLE);
                i2.setVisibility(View.INVISIBLE);
                i3.setVisibility(View.VISIBLE);
                button.setText("Start");

                animation= AnimationUtils.loadAnimation(ctx,R.anim.fadein);
                animation1= AnimationUtils.loadAnimation(ctx,R.anim.lefttoright);
                animation2= AnimationUtils.loadAnimation(ctx,R.anim.blink_anim);
                animation3= AnimationUtils.loadAnimation(ctx,R.anim.zoomout);
                big.startAnimation(animation);
                title.startAnimation(animation1);
                i3.startAnimation(animation3);
                button.startAnimation(animation2);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent= new Intent(ctx,Welcome.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                        ctx.startActivity(intent);
                    }
                });
                break;

        }

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
