package com.example.evian.a4;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;

/**
 * Created by Evian on 2018-03-20.
 */

public class TopicSelect extends AppCompatActivity implements OnItemSelectedListener {
    Spinner sp;
    static final String[] items= {"1","2","3","4","5"};
    String name;
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topicselect);
        sp= (Spinner) findViewById(R.id.numberOfQuestions);
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(TopicSelect.this,android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);;

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        this.name = name;
        setName(name);

    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        number = position + 1;
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    void setName(String name){
        TextView label = findViewById(R.id.displayName);
        label.setText(name);
    }

    public void loadQuestions(View view){
        Intent intent = new Intent(this, LoadQuetsion1.class);
        intent.putExtra("number",number);
        intent.putExtra("totalNumber",number);
        intent.putExtra("name",name);
        intent.putExtra("goPrevious",false);
        startActivity(intent);
    }

    public void logout(View view){
        Intent intent = new Intent(this,Welcomepage.class);
        startActivity(intent);
    }
}
