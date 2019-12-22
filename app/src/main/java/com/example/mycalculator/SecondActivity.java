package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView lenth_input;
    private TextView lenth_output;
    private Spinner spinner1;
    private Spinner spinner2;
    private String lenth_str="";
    Button buttons[] = new Button[14];
    int ids[] = new int[]{R.id.Button_lenth_CE, R.id.Button_lenth_back, R.id.Button_lenth_7, R.id.Button_lenth_8, R.id.Button_lenth_9, R.id.Button_lenth_4, R.id.Button_lenth_5, R.id.Button_lenth_6, R.id.Button_lenth_1, R.id.Button_lenth_2, R.id.Button_lenth_3, R.id.Button_lenth_equal, R.id.Button_lenth_0, R.id.Button_lenth_poi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.length_trans_layout);
        ActionBar actionbar=getSupportActionBar();
        if(actionbar !=null){
            actionbar.hide();
        }
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = findViewById(ids[i]);
            buttons[i].setOnClickListener(this);
        }
        lenth_input = findViewById(R.id.lenth_input);
        lenth_output=findViewById(R.id.lenth_output);
        spinner1=findViewById(R.id.first_length);
        spinner2=findViewById(R.id.second_length);
    }
    public void onClick(View view){
        int id = view.getId();
        Button button = findViewById(id);
        String current = button.getText().toString();
        switch (current) {
            case "0": {
                lenth_str += "0";
                lenth_input.setText(lenth_str);
            }
            break;
            case "1": {
                lenth_str += "1";
                lenth_input.setText(lenth_str);
            }
            break;
            case "2": {
                lenth_str += "2";
                lenth_input.setText(lenth_str);
            }
            break;
            case "3": {
                lenth_str += "3";
                lenth_input.setText(lenth_str);
            }
            break;
            case "4": {
                lenth_str += "4";
                lenth_input.setText(lenth_str);
            }
            break;
            case "5": {
                lenth_str += "5";
                lenth_input.setText(lenth_str);
            }
            break;
            case "6": {
                lenth_str += "6";
                lenth_input.setText(lenth_str);
            }
            break;
            case "7": {
                lenth_str += "7";
                lenth_input.setText(lenth_str);
            }
            break;
            case "8": {
                lenth_str += "8";
                lenth_input.setText(lenth_str);
            }
            break;
            case "9": {
                lenth_str += "9";
                lenth_input.setText(lenth_str);
            }
            break;
            case "=": {
                int i=spinner1.getSelectedItemPosition();
                int j=spinner2.getSelectedItemPosition()+1;
                Transform trans=new Transform(Double.parseDouble(lenth_str));
                double[] result=trans.getLengthResult(i);
                //lenth_str = lenth_str + "=" + String.valueOf(result);
                lenth_input.setText(lenth_str);
                lenth_output.setText(String.valueOf(result[j]));
            }
            break;
            case ".": {
                lenth_str += ".";
                lenth_input.setText(lenth_str);
            }
            break;
            case "Back": {
                if (lenth_str.substring(lenth_str.length() - 1, lenth_str.length()) == " ") {
                    lenth_str = lenth_str.substring(0, lenth_str.length() - 2);
                    lenth_input.setText(lenth_str);
                } else {
                    lenth_str = lenth_str.substring(0, lenth_str.length() - 1);
                    lenth_input.setText(lenth_str);
                }
            }
            break;
            case "CE": {
                lenth_str = "";
                lenth_input.setText(lenth_str);
            }
            break;
        }
    }
}
