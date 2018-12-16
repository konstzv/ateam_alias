package ru.androidacademy.ateam.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import ru.androidacademy.ateam.R;

public class MainActivity extends AppCompatActivity {

    TextView mGameName;
    Button mButtonStart;
    Button mButtonContinue;
    Button mButtonRules;
    Button mButtonHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonStart = findViewById(R.id.start_new_button);
        mButtonRules = findViewById(R.id.rules_button);

        mButtonStart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, RoundActivity.class);
                startActivity(intent);
            }
        });

        mButtonRules.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, RulesActivity.class);
                startActivity(intent);
            }
        });
    }





}
