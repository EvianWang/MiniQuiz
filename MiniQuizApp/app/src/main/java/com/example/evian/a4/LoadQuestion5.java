package com.example.evian.a4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Evian on 2018-03-22.
 */

public class LoadQuestion5 extends AppCompatActivity {
    int number;
    int totalNumber;
    String name;
    String []answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        Intent intent = getIntent();
        this.answer = intent.getStringArrayExtra("answer");
        boolean goPrevious = intent.getBooleanExtra("goPrevious", false);
        if (answer[4] == null) {
            answer[4] = "";
        }
        this.name = intent.getStringExtra("name");
        this.totalNumber = intent.getIntExtra("totalNumber", -1);
        this.number = intent.getIntExtra("number", -1);
        setName(name);

        // if we are creating this activity through "Previous"
        if (!answer[4].equals("")) {
            if (answer[4].contains("A")) {
                CheckBox cb = findViewById(R.id.checkboxCanada);
                cb.setChecked(true);
            }
            if (answer[4].contains("B")) {
                CheckBox cb = findViewById(R.id.checkboxTaiwan);
                cb.setChecked(true);
            }
            if (answer[4].contains("C")) {
                CheckBox cb = findViewById(R.id.checkboxSouthAfrica);
                cb.setChecked(true);
            }
            if (answer[4].contains("D")) {
                CheckBox cb = findViewById(R.id.checkboxUK);
                cb.setChecked(true);
            }
        }

        if (number == 1) {
            Button btn = findViewById(R.id.next);
            String finish = "Finish";
            btn.setText(finish);
        }

        TextView tv = findViewById(R.id.index);
        String s = String.valueOf(this.totalNumber);
        s = "5/" + s;
        tv.setText(s);
    }
    void setName(String name){
        TextView label = findViewById(R.id.displayName);
        label.setText(name);
    }

    public void logout(View view){
        Intent intent = new Intent(this,Welcomepage.class);
        startActivity(intent);
    }
    public void onCheckBoxClicked(View view){
        int index = 0;
        // Is the button now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()){
            case R.id.checkboxCanada:
                if(checked)
                    answer[4] += "A";
                else {
                    index = answer[4].indexOf("A");
                    StringBuilder sb = new StringBuilder(answer[4]);
                    sb.deleteCharAt(index);
                    String resultString = sb.toString();
                    answer[4] = resultString;
                }
                break;
            case R.id.checkboxTaiwan:
                if(checked)
                    answer[4] += "B";
                else {
                    index = answer[4].indexOf("B");
                    StringBuilder sb = new StringBuilder(answer[4]);
                    sb.deleteCharAt(index);
                    String resultString = sb.toString();
                    answer[4] = resultString;
                }
                break;
            case R.id.checkboxSouthAfrica:
                if(checked)
                    answer[4] += "C";
                else {
                    index = answer[4].indexOf("C");
                    StringBuilder sb = new StringBuilder(answer[4]);
                    sb.deleteCharAt(index);
                    String resultString=sb.toString();
                    answer[4] = resultString;
                }
                break;
            case R.id.checkboxUK:
                if(checked)
                    answer[4] += "D";
                else {
                    index = answer[4].indexOf("D");
                    StringBuilder sb = new StringBuilder(answer[4]);
                    sb.deleteCharAt(index);
                    String resultString=sb.toString();
                    answer[4] = resultString;
                }
                break;
        }

    }
    public void goNextPage(View view){
        Intent intent = new Intent(this, Finishpage.class);
        //intent.putExtra("number", number-1);
        intent.putExtra("totalNumber", totalNumber);
        intent.putExtra("name", name);
        intent.putExtra("answer",answer);
        startActivity(intent);
    }

    public void goPreviousPage(View view){
        Intent intent = new Intent(this, LoadQuestion4.class);
        intent.putExtra("number", number+1);
        intent.putExtra("totalNumber", totalNumber);
        intent.putExtra("name", name);
        intent.putExtra("answer",answer);
        intent.putExtra("goPrevious",true);
        startActivity(intent);
    }
}
