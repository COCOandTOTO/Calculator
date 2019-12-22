package com.example.mycalculator;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volume_trans_layout);
        ActionBar actionbar=getSupportActionBar();
        if(actionbar !=null){
            actionbar.hide();
        }
    }
}
