package com.example.evian.a4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import java.lang.String;
import android.content.Intent;
import android.widget.Button;

public class Welcomepage extends AppCompatActivity {
    EditText eText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eText = findViewById(R.id.name);
        btn = findViewById(R.id.next);
        // disable the next button before edit text get edited
        btn.setEnabled(false);
        // build new edit text listener
        eText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().trim().equals("")){
                    btn.setEnabled(false);
                }else{
                    btn.setEnabled(true);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void goNextPage(View view){
        String name = eText.getText().toString();
        Intent intent = new Intent(this, TopicSelect.class);
        intent.putExtra("name",name);
        startActivity(intent);
    }
}
