package com.example.evian.a4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Evian on 2018-03-22.
 */

public class LoadQuestion4 extends AppCompatActivity {
    int number;
    int totalNumber;
    String name;
    String []answer;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        Intent intent = getIntent();
        this.answer = intent.getStringArrayExtra("answer");
        //answer[1] = "";
        this.name = intent.getStringExtra("name");
        this.totalNumber = intent.getIntExtra("totalNumber",-1);
        this.number = intent.getIntExtra("number",-1);
        //this.initialized = intent.getBooleanExtra("initialized",false);
        setName(name);

        if(answer[3] != null){
            if(this.answer[3].equals("A")){
                RadioButton rb = findViewById(R.id.radioNetherlands);
                rb.setChecked(true);
            }
            if(this.answer[3].equals("B")){
                RadioButton rb = findViewById(R.id.radioTaiwan);
                rb.setChecked(true);
            }
            if(this.answer[3].equals("C")){
                RadioButton rb = findViewById(R.id.radioChina);
                rb.setChecked(true);
            }
            if(this.answer[3].equals("D")){
                RadioButton rb = findViewById(R.id.radioSlovakia);
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
        s ="4/"+s;
        tv.setText(s);
    }
    public void onRadioButtonClicked(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()){
            case R.id.radioCanada:
                if(checked) {
                    this.answer[3] = "A";
                }
                break;
            case R.id.radioIndia:
                if(checked)
                    this.answer[3] = "B";
                break;
            case R.id.radioBrazil:
                if(checked)
                    this.answer[3] = "C";
                break;
            case R.id.radioSouthKorea:
                if(checked)
                    this.answer[3] = "D";
                break;
        }

    }

    public void goNextPage(View view){
        if(number == 1) {
            Intent intent = new Intent(this,Finishpage.class);
            intent.putExtra("name",name);
            intent.putExtra("answer",answer);
            intent.putExtra("totalNumber",totalNumber);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, LoadQuestion5.class);
            intent.putExtra("number", number-1);
            intent.putExtra("totalNumber", totalNumber);
            intent.putExtra("name", name);
            intent.putExtra("answer",answer);
              startActivity(intent);
        }
    }

    public void goPreviousPage(View view){
        Intent intent = new Intent(this, LoadQuestion3.class);
        intent.putExtra("number", number+1);
        intent.putExtra("totalNumber", totalNumber);
        intent.putExtra("name", name);
        intent.putExtra("answer",answer);
        intent.putExtra("goPrevious",true);
        startActivity(intent);
    }

    void setName(String name){
        TextView label = findViewById(R.id.displayName);
        label.setText(name);
    }

    public void logout(View view){
        Intent intent = new Intent(this,Welcomepage.class);
        startActivity(intent);
    }
}
