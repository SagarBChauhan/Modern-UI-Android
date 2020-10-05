package com.example.moderndashboardui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class AppIntroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isFirstStart())
        {
            startMainActivity();
        }

        addSlide(AppIntroFragment.newInstance("Welcome to","Trip and Turn tours and travels",
                R.drawable.plane_roundedcorner_icon, ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance("Book packages","Tour packages from all around world",
                R.drawable.tour_package_inro, ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance("Book hotels","at reasonable price",
                R.drawable.hotel, ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance("Book Transports","at reasonable price",
                R.drawable.transport_intr, ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance("Passport Assistance","at reasonable price",
                R.drawable.passport_intro, ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance("Eran gift vouchers","on booking of any service",
                R.drawable.gift_voucher, ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary)));
    }

    private boolean isFirstStart()
    {
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("Intro", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("Flag",true);
    }

    private void setStartStatus(boolean status)
    {
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("Intro", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("Flag",status);
        editor.commit();
    }

    @Override
    public void onDonePressed(Fragment fragment) {
        super.onDonePressed(fragment);
        startMainActivity();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        startMainActivity();
    }
    public void startMainActivity(){
        setStartStatus(false);

        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}
