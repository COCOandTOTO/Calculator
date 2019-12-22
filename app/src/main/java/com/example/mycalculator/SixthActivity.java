package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SixthActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView jinzhi_input;
    private TextView jinzhi_output;
    private Spinner spinner1;
    private Spinner spinner2;
    private String jinzhi_str="";
    Button buttons[] = new Button[14];
    int ids[] = new int[]{R.id.Button_jinzhi_CE, R.id.Button_jinzhi_back, R.id.Button_jinzhi_7, R.id.Button_jinzhi_8, R.id.Button_jinzhi_9, R.id.Button_jinzhi_4, R.id.Button_jinzhi_5, R.id.Button_jinzhi_6, R.id.Button_jinzhi_1, R.id.Button_jinzhi_2, R.id.Button_jinzhi_3, R.id.Button_jinzhi_equal, R.id.Button_jinzhi_0, R.id.Button_jinzhi_poi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jinzhi_trans_layout);
        ActionBar actionbar=getSupportActionBar();
        if(actionbar !=null){
            actionbar.hide();
        }
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = findViewById(ids[i]);
            buttons[i].setOnClickListener(this);
        }
        jinzhi_input = findViewById(R.id.jinzhi_input);
        jinzhi_output=findViewById(R.id.jinzhi_output);
        spinner1=findViewById(R.id.first_jinzhi);
        spinner2=findViewById(R.id.second_jinzhi);
        }
        public void onClick(View view){
            int id = view.getId();
            Button button = findViewById(id);
            String current = button.getText().toString();
            switch (current) {
                case "0": {
                    jinzhi_str += "0";
                    jinzhi_input.setText(jinzhi_str);
                }
                break;
                case "1": {
                    jinzhi_str += "1";
                    jinzhi_input.setText(jinzhi_str);
                }
                break;
                case "2": {
                    jinzhi_str += "2";
                    jinzhi_input.setText(jinzhi_str);
                }
                break;
                case "3": {
                    jinzhi_str += "3";
                    jinzhi_input.setText(jinzhi_str);
                }
                break;
                case "4": {
                    jinzhi_str += "4";
                    jinzhi_input.setText(jinzhi_str);
                }
                break;
                case "5": {
                    jinzhi_str += "5";
                    jinzhi_input.setText(jinzhi_str);
                }
                break;
                case "6": {
                    jinzhi_str += "6";
                    jinzhi_input.setText(jinzhi_str);
                }
                break;
                case "7": {
                    jinzhi_str += "7";
                    jinzhi_input.setText(jinzhi_str);
                }
                break;
                case "8": {
                    jinzhi_str += "8";
                    jinzhi_input.setText(jinzhi_str);
                }
                break;
                case "9": {
                    jinzhi_str += "9";
                    jinzhi_input.setText(jinzhi_str);
                }
                break;
                case "=": {
                    int i=spinner1.getSelectedItemPosition();
                    int j=spinner2.getSelectedItemPosition()+1;
                    Transform trans=new Transform(jinzhi_str);
                    String[] result=trans.getSystemResult(i);
                    //lenth_str = lenth_str + "=" + String.valueOf(result);
                    jinzhi_input.setText(jinzhi_str);
                    jinzhi_output.setText(result[j]);
                }
                break;
                case ".": {
                    jinzhi_str += ".";
                    jinzhi_input.setText(jinzhi_str);
                }
                break;
                case "Back": {
                    if (jinzhi_str.substring(jinzhi_str.length() - 1, jinzhi_str.length()) == " ") {
                        jinzhi_str = jinzhi_str.substring(0, jinzhi_str.length() - 2);
                        jinzhi_input.setText(jinzhi_str);
                    } else {
                        jinzhi_str = jinzhi_str.substring(0, jinzhi_str.length() - 1);
                        jinzhi_input.setText(jinzhi_str);
                    }
                }
                break;
                case "CE": {
                    jinzhi_str = "";
                    jinzhi_input.setText(jinzhi_str);
                }
                break;
            }
        }
}
