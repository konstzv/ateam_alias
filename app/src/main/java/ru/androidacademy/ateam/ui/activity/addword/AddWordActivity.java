package ru.androidacademy.ateam.ui.activity.addword;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import ru.androidacademy.ateam.R;
import ru.androidacademy.ateam.ui.activity.addword.fragment.AddWordInDeckFragment;

public class AddWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        AddWordInDeckFragment addWordInDeckFragment = new AddWordInDeckFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment, addWordInDeckFragment);
        ft.commit();
    }
}
