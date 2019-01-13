package com.example.evian.a4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Evian on 2018-03-22.
 */

public class Finishpage extends AppCompatActivity {
    String name;
    int totalScore;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishpage);
        // Get the intent that started this activity
        Intent intent = getIntent();
        String [] answer = intent.getStringArrayExtra("answer");
        totalScore = 0;
        if(answer[0] != null && answer[0].equals("A")){
            totalScore += 1;
        }
        if(answer[1] != null && answer[1].equals("AC")){
            totalScore += 1;
        }
        if(answer[2] != null && answer[2].equals("C")){
            totalScore += 1;
        }
        if(answer[3] != null && answer[3].equals("D")){
            totalScore += 1;
        }
        if(answer[4] != null && answer[4].equals("CD")){
            totalScore += 1;
        }

        int totalNumber = intent.getIntExtra("totalNumber",-1);
        String s = String.valueOf(totalScore);
        String r = String.valueOf(totalNumber);
        s = s+"/"+r;
        TextView tv =  findViewById(R.id.displayScore);
        tv.setText(s);
        name = intent.getStringExtra("name");
        tv = (TextView) findViewById(R.id.displayName);
        tv.setText(name);

    }

    public void goTopicSelect(View view){
        Intent intent = new Intent(this, TopicSelect.class);
        intent.putExtra("name",name);
        startActivity(intent);
    }


    public void logout(View view){
        Intent intent = new Intent(this,Welcomepage.class);
        startActivity(intent);
    }
}
