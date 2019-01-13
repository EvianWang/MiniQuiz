package com.example.evian.a4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import java.lang.String;
import android.view.View;

/**
 * Created by Evian on 2018-03-22.
 */

public class LoadQuestion2 extends AppCompatActivity {
    int number;
    int totalNumber;
    String name;
    String []answer;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        Intent intent = getIntent();
        this.answer = intent.getStringArrayExtra("answer");
        boolean goPrevious = intent.getBooleanExtra("goPrevious",false);
        if(answer[1]==null) {
            answer[1] = "";
        }
        this.name = intent.getStringExtra("name");
        this.totalNumber = intent.getIntExtra("totalNumber",-1);
        this.number = intent.getIntExtra("number",-1);
        setName(name);

        // if we are creating this activity through "Previous"
        if(!answer[1].equals("")){
            if(answer[1].contains("A")){
                CheckBox cb = findViewById(R.id.checkboxBrazil);
                cb.setChecked(true);
            }
            if(answer[1].contains("B")){
                CheckBox cb = findViewById(R.id.checkboxIvoryCoast);
                cb.setChecked(true);
            }
            if(answer[1].contains("C")){
                CheckBox cb = findViewById(R.id.checkboxArgentina);
                cb.setChecked(true);
            }
            if(answer[1].contains("D")){
                CheckBox cb = findViewById(R.id.checkboxLuxembourg);
                cb.setChecked(true);
            }
        }

        if(number == 1){
            Button btn = findViewById(R.id.next);
            String finish = "Finish";
            btn.setText(finish);
        }

        TextView tv = findViewById(R.id.index);
        String s = String.valueOf(this.totalNumber);
        s ="2/"+s;
        tv.setText(s);
    }


    public void onCheckBoxClicked(View view){
        int index = 0;
        // Is the button now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()){
            case R.id.checkboxBrazil:
                if(checked)
                    answer[1] += "A";
                else {
                    index = answer[1].indexOf("A");
                    StringBuilder sb = new StringBuilder(answer[1]);
                    sb.deleteCharAt(index);
                    String resultString = sb.toString();
                    answer[1] = resultString;
                }
                break;
            case R.id.checkboxIvoryCoast:
                if(checked)
                    answer[1] += "B";
                else {
                    index = answer[1].indexOf("B");
                    StringBuilder sb = new StringBuilder(answer[1]);
                    sb.deleteCharAt(index);
                    String resultString = sb.toString();
                    answer[1] = resultString;
                }
                break;
            case R.id.checkboxArgentina:
                if(checked)
                    answer[1] += "C";
                else {
                    index = answer[1].indexOf("C");
                    StringBuilder sb = new StringBuilder(answer[1]);
                    sb.deleteCharAt(index);
                    String resultString=sb.toString();
                    answer[1] = resultString;
                }
                break;
            case R.id.checkboxLuxembourg:
                if(checked)
                    answer[1] += "D";
                else {
                    index = answer[1].indexOf("D");
                    StringBuilder sb = new StringBuilder(answer[1]);
                    sb.deleteCharAt(index);
                    String resultString=sb.toString();
                    answer[1] = resultString;
                }
                break;
        }

    }


    void setName(String name){
        TextView label = findViewById(R.id.displayName);
        label.setText(name);
    }

    public void logout(View view){
        Intent intent = new Intent(this,Welcomepage.class);
        startActivity(intent);
    }

    public void goNextPage(View view){
        if(number == 1) {
            Intent intent = new Intent(this,Finishpage.class);
            intent.putExtra("name",name);
            intent.putExtra("answer",answer);
            intent.putExtra("totalNumber",totalNumber);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, LoadQuestion3.class);
            intent.putExtra("number", number-1);
            intent.putExtra("totalNumber", totalNumber);
            intent.putExtra("name", name);
            intent.putExtra("answer",answer);
            startActivity(intent);
        }
    }

    public void goPreviousPage(View view){
        Intent intent = new Intent(this, LoadQuetsion1.class);
        intent.putExtra("number", number+1);
        intent.putExtra("totalNumber", totalNumber);
        intent.putExtra("name", name);
        intent.putExtra("answer",answer);
        intent.putExtra("goPrevious",true);
        startActivity(intent);
    }

}
