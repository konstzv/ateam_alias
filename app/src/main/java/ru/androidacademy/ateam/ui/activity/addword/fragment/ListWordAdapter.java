package ru.androidacademy.ateam.ui.activity.addword.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.androidacademy.ateam.R;
import ru.androidacademy.ateam.model.Word;

import java.util.ArrayList;
import java.util.List;

public class ListWordAdapter extends RecyclerView.Adapter<ListWordAdapter.ViewHolder> {
    @NonNull
    private final List<Word> wordList = new ArrayList<>();
    @NonNull
    private final LayoutInflater inflater;

    public ListWordAdapter(@NonNull Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(inflater.inflate(viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(wordList.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.add_word_recycler_tab;
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }


    public void replaceItems(@NonNull List<Word> items) {
        wordList.clear();
        wordList.addAll(items);
        notifyDataSetChanged();
    }

    public void addItem(@NonNull Word word) {
        wordList.add(word);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @NonNull
        private final TextView word;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.add_word_recycler_tab_word);
        }

        public void bind(Word words) {
            word.setText(words.getText());
        }
    }
}
