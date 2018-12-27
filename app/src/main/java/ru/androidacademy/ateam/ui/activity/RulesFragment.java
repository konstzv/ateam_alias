package ru.androidacademy.ateam.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import ru.androidacademy.ateam.R;

import java.util.Objects;

public class RulesFragment extends Fragment {

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;
    int backColor;


    static RulesFragment newInstance(int page) {
        RulesFragment pageFragment = new RulesFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = Objects.requireNonNull(getArguments()).getInt(ARGUMENT_PAGE_NUMBER);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rules_fragment, null);

        TextView tvPage = view.findViewById(R.id.tvPage);
        TextView tvRulesChapter = view.findViewById(R.id.tvRulesChapter);

        switch (pageNumber) {
            case 0:
                tvRulesChapter.setText(getString(R.string.rules_chapter_1));
                tvPage.setText(getString(R.string.rules_page_0));
                tvPage.setBackgroundColor(backColor);
                break;
            case 1:
                tvRulesChapter.setText(getString(R.string.rules_chapter_2));
                tvPage.setText(getString(R.string.rules_page_1));
                tvPage.setBackgroundColor(backColor);
                break;
            case 2:
                tvRulesChapter.setText(getString(R.string.rules_chapter_3));
                tvPage.setText(getString(R.string.rules_page_2));
                tvPage.setBackgroundColor(backColor);
                break;
        }
        return view;
    }
}
