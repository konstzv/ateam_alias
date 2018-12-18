package ru.androidacademy.ateam.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import ru.androidacademy.ateam.R;
import ru.androidacademy.ateam.ui.activity.addword.ListWordActivity;

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
        mButtonContinue = findViewById(R.id.continue_button);

        mButtonStart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        mButtonRules.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, RulesActivity.class);
                startActivity(intent);
            }
        });

        mButtonContinue.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ListWordActivity.class);
                startActivity(intent);
            }
        });
    }





}
