package ru.androidacademy.ateam.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;
import ru.androidacademy.ateam.R;

import java.util.Objects;

public class RoundActivity extends AppCompatActivity {

    TextView mTimeTv;
    TextView mWordTv;
    Button mButtonOk;
    Button mButtonSkip;
    MaterialProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.now_playing);

        mTimeTv = findViewById(R.id.timer_text_view);
        mWordTv = findViewById(R.id.word_tv);
        mButtonOk = findViewById(R.id.ok_button);
        mButtonSkip = findViewById(R.id.skip_button);
        mProgressBar = findViewById(R.id.timer_progress);

        mProgressBar.setVisibility(View.VISIBLE);
    }
}
