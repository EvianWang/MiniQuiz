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

public class LoadQuestion3 extends AppCompatActivity {
    int number;
    int totalNumber;
    String name;
    String []answer;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        Intent intent = getIntent();
        this.answer = intent.getStringArrayExtra("answer");
        boolean goPrevious = intent.getBooleanExtra("goPrevious",false);
        //answer[1] = "";
        this.name = intent.getStringExtra("name");
        this.totalNumber = intent.getIntExtra("totalNumber",-1);
        this.number = intent.getIntExtra("number",-1);
        //this.initialized = intent.getBooleanExtra("initialized",false);
        setName(name);

        if(answer[2] != null){
            if(this.answer[2].equals("A")){
                RadioButton rb = findViewById(R.id.radioNetherlands);
                rb.setChecked(true);
            }
            if(this.answer[2].equals("B")){
                RadioButton rb = findViewById(R.id.radioTaiwan);
                rb.setChecked(true);
            }
            if(this.answer[2].equals("C")){
                RadioButton rb = findViewById(R.id.radioChina);
                rb.setChecked(true);
            }
            if(this.answer[2].equals("D")){
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
        s ="3/"+s;
        tv.setText(s);
    }

    public void onRadioButtonClicked(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()){
            case R.id.radioNetherlands:
                if(checked) {
                    this.answer[2] = "A";
                }
                break;
            case R.id.radioTaiwan:
                if(checked)
                    this.answer[2] = "B";
                break;
            case R.id.radioChina:
                if(checked)
                    this.answer[2] = "C";
                break;
            case R.id.radioSlovakia:
                if(checked)
                    this.answer[2] = "D";
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
            Intent intent = new Intent(this, LoadQuestion4.class);
            intent.putExtra("number", number-1);
            intent.putExtra("totalNumber", totalNumber);
            intent.putExtra("name", name);
            intent.putExtra("answer",answer);
            startActivity(intent);
        }
    }

    public void goPreviousPage(View view){
        Intent intent = new Intent(this, LoadQuestion2.class);
        intent.putExtra("number", number+1);
        intent.putExtra("totalNumber", totalNumber);
        intent.putExtra("name", name);
        intent.putExtra("answer",answer);
        //intent.putExtra("initialized",initialized);
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
