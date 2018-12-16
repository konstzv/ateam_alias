package ru.androidacademy.ateam.ui.activity.addword;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import ru.androidacademy.ateam.R;

public class WordAddToDeck extends AppCompatActivity {
    Button btnSave;
    EditText saveText;
    String temp;
    long id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        id = getArguments().getLong("id");
        btnSave = findViewById(R.id.btn_save_word);
        saveText = findViewById(R.id.word_add_edit_text);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = saveText.getText().toString();
                checkString(temp);
            }
        });
    }

    private String[] checkString(String temp) {
        String[] tempStr = temp.split(",");
        for (int i = 0; i < tempStr.length; i++) {
            tempStr[i] = tempStr[i].trim();
            Log.d("Taf", tempStr[i]);
        }
        return tempStr;
    }


}
