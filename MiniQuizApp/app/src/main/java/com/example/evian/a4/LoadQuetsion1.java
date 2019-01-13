package com.example.evian.a4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import java.lang.String;
import android.view.View;

/**
 * Created by Evian on 2018-03-21.
 */

public class LoadQuetsion1 extends AppCompatActivity {
    int number;
    int totalNumber;
    String name;
    String []answer;
    //boolean initialized;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        Intent intent = getIntent();
        boolean goPrevious = intent.getBooleanExtra("goPrevious",false);
        if(!goPrevious) {
            answer = new String[5];
        }
        this.name = intent.getStringExtra("name");
        this.totalNumber = intent.getIntExtra("totalNumber",-1);
        this.number = intent.getIntExtra("number",-1);
        if(goPrevious) {
            this.answer = intent.getStringArrayExtra("answer");
        }
        setName(name);

        //boolean goPrevious = intent.getBooleanExtra("goPrevious",false);
        if(goPrevious){
            if(this.answer[0].equals("A")){
                RadioButton rb = findViewById(R.id.radioCanada);
                rb.setChecked(true);
            }
            if(this.answer[0].equals("B")){
                RadioButton rb = findViewById(R.id.radioTaiwan);
                rb.setChecked(true);
            }
            if(this.answer[0].equals("C")){
                RadioButton rb = findViewById(R.id.radioChina);
                rb.setChecked(true);
            }
            if(this.answer[0].equals("D")){
                RadioButton rb = findViewById(R.id.radioPeru);
                rb.setChecked(true);
            }
        }

        if(number == 1){
            Button btn = findViewById(R.id.next);
            String finish = "Finish";
            btn.setText(finish);
        }

        TextView tv = findViewById(R.id.index);
        String s = String.valueOf(this.totalNumber);
        s ="1/"+s;
        tv.setText(s);
        Button btn = findViewById(R.id.previous);
        btn.setEnabled(false);
    }

    void setName(String name){
        TextView label = findViewById(R.id.displayName);
        label.setText(name);
    }

    public void onRadioButtonClicked(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()){
            case R.id.radioCanada:
                if(checked) {
                    this.answer[0] = "A";
                }
                    break;
            case R.id.radioTaiwan:
                if(checked)
                    this.answer[0] = "B";
                    break;
            case R.id.radioChina:
                if(checked)
                    this.answer[0] = "C";
                    break;
            case R.id.radioPeru:
                if(checked)
                    this.answer[0] = "D";
                    break;
        }

    }

    public void goNextPage(View view){
        //if(this.answer[0] == "A"){
        //    totalScore += 1;
        //}
        if(number == 1) {
            Intent intent = new Intent(this,Finishpage.class);
            intent.putExtra("name",name);
            intent.putExtra("answer",answer);
            intent.putExtra("totalNumber",totalNumber);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, LoadQuestion2.class);
            intent.putExtra("number", number-1);
            intent.putExtra("totalNumber", totalNumber);
            intent.putExtra("name", name);
            intent.putExtra("answer",answer);
            //intent.putExtra("initialized",initialized);
            startActivity(intent);
        }
    }

    public void logout(View view){
        Intent intent = new Intent(this,Welcomepage.class);
        startActivity(intent);
    }

}
