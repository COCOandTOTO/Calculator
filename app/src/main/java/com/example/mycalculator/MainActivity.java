package com.example.mycalculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView input;
    private String str = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int orientation=getResources().getConfiguration().orientation;
        if(orientation== Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.first_layout);
            Button buttons[] = new Button[19];
            int ids[] = new int[]{R.id.Button_C, R.id.Button_back, R.id.Button_7, R.id.Button_8, R.id.Button_9, R.id.Button_4, R.id.Button_5, R.id.Button_6, R.id.Button_1, R.id.Button_2, R.id.Button_3, R.id.Button_equal, R.id.Button_0, R.id.Button_poi,R.id.Button_add,R.id.Button_sub,R.id.Button_mul,R.id.Button_div,R.id.Button_per};
            for (int i = 0; i < buttons.length; i++) {
                buttons[i] = findViewById(ids[i]);
                buttons[i].setOnClickListener(this);
            }
            input = findViewById(R.id.input);
            }
        else if(orientation==Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.first_layout_land);
            Button buttons[] = new Button[34];
            int ids[] = new int[]{R.id.Button_C, R.id.Button_div, R.id.Button_mul, R.id.Button_back, R.id.Button_7, R.id.Button_8, R.id.Button_9, R.id.Button_sub, R.id.Button_4, R.id.Button_5, R.id.Button_6, R.id.Button_add, R.id.Button_1, R.id.Button_2, R.id.Button_3, R.id.Button_equal, R.id.Button_per, R.id.Button_0, R.id.Button_poi, R.id.Button_left, R.id.Button_right, R.id.Button_daoshu, R.id.Button_pingfang, R.id.Button_lifang, R.id.Button_jiecheng, R.id.Button_genhao, R.id.Button_ln, R.id.Button_log, R.id.Button_sin, R.id.Button_cos, R.id.Button_tan, R.id.Button_arcsin, R.id.Button_arccos, R.id.Button_arctan};
            for (int i = 0; i < buttons.length; i++) {
                buttons[i] = findViewById(ids[i]);
                buttons[i].setOnClickListener(this);
            }
            input = findViewById(R.id.input);
        }
        ActionBar actionbar=getSupportActionBar();
        if(actionbar !=null){
            actionbar.hide();
        }
        NavigationView navView=findViewById(R.id.nav_view);
        navView.setCheckedItem(R.id.length_trans);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.length_trans:{
                        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

                        intent.setClass(MainActivity.this,SecondActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case R.id.area_trans:{
                        Intent intent=new Intent(MainActivity.this,ThirdActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case R.id.volumn_trans:{
                        Intent intent=new Intent(MainActivity.this,FourthActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case R.id.weight_trans:{
                        Intent intent=new Intent(MainActivity.this,FivthActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case R.id.jinzhi_trans:{
                        Intent intent=new Intent(MainActivity.this,SixthActivity.class);
                        startActivity(intent);
                    }
                    break;
                }
                return true;
            }
        });
    }
    public void onClick(View view){
        int id = view.getId();
        Button button = findViewById(id);
        String current = button.getText().toString();

        switch (current) {
            case "0": {
                str += "0";
                input.setText(str);
            }
            break;
            case "1": {
                str += "1";
                input.setText(str);
            }
            break;
            case "2": {
                str += "2";
                input.setText(str);
            }
            break;
            case "3": {
                str += "3";
                input.setText(str);
            }
            break;
            case "4": {
                str += "4";
                input.setText(str);
            }
            break;
            case "5": {
                str += "5";
                input.setText(str);
            }
            break;
            case "6": {
                str += "6";
                input.setText(str);
            }
            break;
            case "7": {
                str += "7";
                input.setText(str);
            }
            break;
            case "8": {
                str += "8";
                input.setText(str);
            }
            break;
            case "9": {
                str += "9";
                input.setText(str);
            }
            break;
            case "+": {
                str += "+";
                input.setText(str);
            }
            break;
            case "-": {
                str += "-";
                input.setText(str);
            }
            break;
            case "×": {
                str += "×";
                input.setText(str);
            }
            break;
            case "÷": {
                str += "÷";
                input.setText(str);
            }
            break;
            case "=": {
                //str+="=";
                //input.setText(str);
                Calculate cal = new Calculate(str);
                double result = cal.calculate(cal.PostfixEvaluator(cal.splitString()));
                str = str + "=" + String.valueOf(result);
                input.setText(str);
            }
            break;
            case ".": {
                str += ".";
                input.setText(str);
            }
            break;
            case "%": {
                str += "%";
                input.setText(str);
            }
            break;
            case "Back": {
                if (str.substring(str.length() - 1, str.length()) == " ") {
                    str = str.substring(0, str.length() - 2);
                    input.setText(str);
                } else {
                    str = str.substring(0, str.length() - 1);
                    input.setText(str);
                }
            }
            break;
            case "CE": {
                str = "";
                input.setText(str);
            }
            break;
            case "(": {
                str += "(";
                input.setText(str);
            }
            break;
            case ")": {
                str += ")";
                input.setText(str);
            }
            break;
            case "1/x": {
                Calculate cal = new Calculate(str);
                double result0 = cal.calculate(cal.PostfixEvaluator(cal.splitString()));
                double result = 1 / result0;
                str = String.valueOf(result);
                input.setText(str);
            }
            break;
            case "x²": {
                Calculate cal = new Calculate(str);
                double result0 = cal.calculate(cal.PostfixEvaluator(cal.splitString()));
                double result = result0 * result0;
                str = String.valueOf(result);
                input.setText(str);
            }
            break;
            case "x³": {
                Calculate cal = new Calculate(str);
                double result0 = cal.calculate(cal.PostfixEvaluator(cal.splitString()));
                double result = result0 * result0 * result0;
                str = String.valueOf(result);
                input.setText(str);
            }
            break;
            case "x!": {
                Calculate cal = new Calculate(str);
                double result0 = cal.calculate(cal.PostfixEvaluator(cal.splitString()));
                double result = 1;
                String str0 = "";
                if ((result0 - Math.floor(result0) != 1) || (result0 - Math.floor(result0) != -1)) {
                    str0 = "error";
                } else {
                    if (result0 == 0 || result0 == 1) {
                        result = 1;
                    } else {
                        for (int i = 1; i <= result0; i++) {
                            result = result * i;
                        }
                    }
                    str0 = String.valueOf(result);
                }
                input.setText(str0);
            }
            case "√": {
                Calculate cal = new Calculate(str);
                double result0 = cal.calculate(cal.PostfixEvaluator(cal.splitString()));
                double result = Math.sqrt(result0);
                str = String.valueOf(result);
                input.setText(str);
            }
            break;
            case "ln": {
                Calculate cal = new Calculate(str);
                double result0 = cal.calculate(cal.PostfixEvaluator(cal.splitString()));
                double result = Math.log(result0);
                str = String.valueOf(result);
                input.setText(str);
            }
            break;
            case "log": {
                Calculate cal = new Calculate(str);
                double result0 = cal.calculate(cal.PostfixEvaluator(cal.splitString()));
                double result = Math.log10(result0);
                str = String.valueOf(result);
                input.setText(str);
            }
            break;
            case "sin": {
                Calculate cal = new Calculate(str);
                double result0 = cal.calculate(cal.PostfixEvaluator(cal.splitString()));
                double result = Math.sin(result0);
                str = String.valueOf(result);
                input.setText(str);
            }
            break;
            case "cos": {
                Calculate cal = new Calculate(str);
                double result0 = cal.calculate(cal.PostfixEvaluator(cal.splitString()));
                double result = Math.cos(result0);
                str = String.valueOf(result);
                input.setText(str);
            }
            break;
            case "tan": {
                Calculate cal = new Calculate(str);
                double result0 = cal.calculate(cal.PostfixEvaluator(cal.splitString()));
                double result = Math.tan(result0);
                str = String.valueOf(result);
                input.setText(str);
            }
            break;
            case "arcsin": {
                Calculate cal = new Calculate(str);
                double result0 = cal.calculate(cal.PostfixEvaluator(cal.splitString()));
                double result = Math.asin(result0);
                str = String.valueOf(result);
                input.setText(str);
            }
            break;
            case "arccos": {
                Calculate cal = new Calculate(str);
                double result0 = cal.calculate(cal.PostfixEvaluator(cal.splitString()));
                double result = Math.acos(result0);
                str = String.valueOf(result);
                input.setText(str);
            }
            break;
            case "arctan": {
                Calculate cal = new Calculate(str);
                double result0 = cal.calculate(cal.PostfixEvaluator(cal.splitString()));
                double result = Math.atan(result0);
                str = String.valueOf(result);
                input.setText(str);
            }
            break;
        }
    }
}







