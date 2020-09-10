package com.example.otp_log;

//Adapter activity
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class Intro extends AppCompatActivity {

    public static ViewPager viewPager;
    OnboardAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        viewPager= findViewById(R.id.page);
        String txt[]= {"Connected with the world!","Rich and true news!", "News Of the World"};
        adapter= new OnboardAdapter(Intro.this, txt);
        viewPager.setAdapter(adapter);//Adapter for Onboard

        if(isSeen())//checking if app is opened for the first time or not.
        {
          Intent intent= new Intent(Intro.this,MainScreen.class);
          intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
          startActivity(intent);//Going to Home Screen
        }
        else
        {
            //updating shared preferences
            SharedPreferences.Editor editor= getSharedPreferences("Check",MODE_PRIVATE).edit();
            editor.putBoolean("Check",true);
            editor.commit();
        }
    }

    //fun to check if app is opened for the first time or not.
    private boolean isSeen() {

        SharedPreferences sharedPreferences= getSharedPreferences("Check",MODE_PRIVATE);
        boolean r= sharedPreferences.getBoolean("Check",false);
        return  r;
    }


}